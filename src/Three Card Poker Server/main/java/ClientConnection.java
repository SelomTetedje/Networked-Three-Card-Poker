import java.io.*;
import java.net.Socket;

public class ClientConnection extends Thread{
    // server
    private Socket clientSocket;
    private Boolean clientConnected = true;
    private ObjectInputStream in;
    private DataOutputStream out;
    private Message message;
    // game
    private Game game;
    private Player player;
    private Dealer dealer;
    private ThreeCardLogic cardLogic;
    boolean lockAnteBetPlayer = false;
    private String GameStatus = "New Round";

    // connects to client and initialize game and message class
    public ClientConnection(Socket cleintSocket) throws IOException {
        this.clientSocket = cleintSocket;
        try{
            this.in = new ObjectInputStream(new BufferedInputStream(cleintSocket.getInputStream()));
            this.out = new DataOutputStream(new BufferedOutputStream(cleintSocket.getOutputStream()));
            this.game = new Game();
            player = game.getPlayer1();
            dealer = game.getDealer();
            cardLogic = new ThreeCardLogic();
            this.message = new Message();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void run(){
        while(clientSocket.isConnected() && game.continueGame){
            if(Thread.interrupted()){
                try {
                    close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            try {
                if(clientSocket.isConnected()){
                    readMessage();
                }
                else{
                    System.out.println("Client Abruptly shutsdown");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public void readMessage() throws IOException, ClassNotFoundException {
        if(in.readUTF() == "exit"){
            System.out.println("Server wants to close");
        }
        else if(clientSocket.isConnected()){
            message = (Message) in.readObject();
            if(message.buttonPressed == "Fold"){
                playerFold();
                GameStatus = "Fold Bet";
            }
            else if(message.buttonPressed == "Wager"){
                playerWager();
                GameStatus = "Wager Bet";
            }
            else if(message.buttonPressed == "Exit"){
                playerExit();
                GameStatus = "Leave Game";
            }
            else if(message.buttonPressed == "BetConfirmend"){
                GameStatus = "Bet Confirmend";
            }
        }
        else{
            clientConnected = false;
        }
    }

    public void close() throws IOException {
        try{
            if (clientSocket != null && !clientSocket.isClosed()) {
                clientSocket.close();
            }
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public Boolean getClientConnected(){
        return clientSocket.isConnected();
    }

    public Socket getClientSocket(){
        return clientSocket;
    }

    // Game
    public Game getGame() {
        return game;
    }

    // returns the player
    public Player getPlayer(){
        return player;
    }
    // check if player folds
    private void playerFold(){
        player.setPlayerFolded(true);
        double playerPairEarnings = 0;
        int tempTotalEarningsP1 = player.getTotalWinnings() - player.getAnteBet() - player.getPairPlusBet();
        if(tempTotalEarningsP1 < 0){
            player.setTotalWinnings(0);
        }
        else{
            player.setTotalWinnings(tempTotalEarningsP1);
        }
        player.setPlayerRoundDictionary(-1);
    }


    // calculates player bet and whether player won or not
    private void playerWager(){
        // checks if dealer is High enough
        boolean isDealerHighEnough = cardLogic.compareHands(dealer.getDealersHand(), player.getHand()) != 3;
        // check if player won pair plus bet
        int playerPairEarnings = cardLogic.evalPPWinnings(player.getHand() ,player.getPairPlusBet() );
        if(isDealerHighEnough){
            boolean playerHigherHand = cardLogic.compareHands(dealer.getDealersHand(), player.getHand()) == 2;
            // check if player have a higher hand then dealer
            if(playerHigherHand){
                // Player beat dealer
                player.setTotalWinnings(player.getTotalWinnings() + player.getPlayBet());
                getGame().addPlayerWins();
                // sets the info for the round
                player.setPlayerRoundDictionary(1);

            }
            else{
                // Dealer Beat Player
                int tempTotalEarningsPlayer1 = player.getTotalWinnings() - player.getPlayBet() - player.getAnteBet();
                    if(tempTotalEarningsPlayer1 < 0){
                        player.setTotalWinnings(0);
                    }
                else{
                    player.setTotalWinnings(tempTotalEarningsPlayer1);;
                }
                // sets the info of game round
                player.setPlayerRoundDictionary(-1);
            }
            getGame().addRound();
        }
        // dealer has lower hand than required
        else{
            // Dealer does not have High Enough Cards
            lockAnteBetPlayer = true;
            // set info for game round
            player.setPlayerRoundDictionary(0);
            player.setPlayBet(0);
        }
        player.setTotalWinnings(player.getTotalWinnings() + playerPairEarnings);


        // *** IMPORTANT - what keeps the history of player previous games ***
        //Game.addToPlayerHistory(Player.getPlayerRoundDictionary());
        newRound();
    }

    // creates an new game round for the players
    private void newRound(){

        player.setPlayBet(0);
        player.setPairPlusBet(0);
        if(!lockAnteBetPlayer){
            player.setAnteBet(0);
        }
        dealHands();
    }

    // dealer deals hand
    void dealHands(){
        dealer.dealDealerHand();
        player.setHand(dealer.dealHand());
    }

    // sets tha player exits game
    private void playerExit(){
        getGame().setContinueGame(false);

    }

    // get the status of the game
    public String getGameStatus(){
        return GameStatus;
    }

}
