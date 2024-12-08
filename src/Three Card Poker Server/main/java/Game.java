import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private ArrayList<Player> Players;
    private Dealer House;
    private int numPlayers;
    public Boolean continueGame = true;
    int numPlayerWins = 0;
    int numRounds = 0;

    private ArrayList<HashMap<String, String>> playerGameHistory;

    // constructor
    Game(){
        numPlayers = 2;
        Players = new ArrayList<>(2);
        for (int i = 0; i < 2; i++) {
            Players.add(new Player());
        }
        House = new Dealer();
        playerGameHistory = new ArrayList<>();
    }
//    // constructior
//    Game(int playerNum){
//        numPlayers = playerNum;
//        Players = new ArrayList<>(playerNum);
//        for (int i = 0; i < playerNum; i++) {
//            Players.add(new Player());
//        }
//        House = new Dealer();
//    }

    public Dealer getDealer(){
        return House;
    }

    public Player getPlayer1(){
        System.out.println("Getting player 1...");
        return Players.get(0);
    }

    public Player getPlayer2(){
        System.out.println("Getting player 2...");
        return Players.get(1);
    }

    void reset(){
        for(int i = 0; i < numPlayers; i++){
            Players.get(i).resetPlayer();
        }
        House.resetDealer();

    }

    Boolean getContinueGame(){
        return continueGame;
    }
    void setContinueGame(Boolean continueGame){
        this.continueGame= continueGame;
    }

    int getNumPlayerWins(){
        return numPlayerWins;
    }
    void addPlayerWins(){
        numPlayerWins++;
    }

    int getNumRounds(){
        return numRounds;
    }
    void addRound(){
        numRounds++;
    }


    void addToPlayerHistory(HashMap<String, String> Round){
        playerGameHistory.add(Round);
    }

    public ArrayList<HashMap<String,String>> getPlayerHistory(){
        return playerGameHistory;
    }




}
