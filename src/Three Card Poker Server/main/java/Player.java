import java.util.*;

public class Player {

    public ArrayList<Card> hand;
    public int anteBet;
    public int playBet;
    public int pairPlusBet;
    public int totalWinnings;

    private int totalRoundEarnings;
    private  boolean playerContinue;
    private int bankAccount;

    private HashMap<String, String> roundDictionary;

    private int wagerBet;
    private boolean foldOnWager;

    Player(){
        setAnteBet(0);
        setPlayBet(0);
        setPairPlusBet(0);
        setTotalRoundEarnings(0);
        setPlayerContinue(true);
        setBankAcc(100);
        setPlayerFolded(false);
        setPlayerFolded(false);
        roundDictionary = new HashMap<>();
        roundDictionary.put("Ante Bet", "" + getAnteBet());
        roundDictionary.put("Player Bet", ""+getPlayBet());
        roundDictionary.put("Total Earnings", ""+getTotalWinnings());
        roundDictionary.put("Player Won", "Unknown");
    }

    // Initialize players
    Player(int startAmount){
        setAnteBet(0);
        setPlayBet(0);
        setPairPlusBet(0);
        setTotalRoundEarnings(0);
        setPlayerContinue(true);
        setBankAcc(startAmount);
        setPlayerFolded(false);
        roundDictionary = new HashMap<>();
        roundDictionary.put("Ante Bet", "" + getAnteBet());
        roundDictionary.put("Player Bet", ""+getPlayBet());
        roundDictionary.put("Total Earnings", ""+getTotalWinnings());
        roundDictionary.put("Player Won", "Unknown");
    }

    public void resetPlayer(){
        setAnteBet(0);
        setPlayBet(0);
        setPairPlusBet(0);
        setTotalRoundEarnings(0);
        setTotalWinnings(0);
        setPlayerContinue(true);
        setBankAcc(100);
        clearHand();
        setPlayerFolded(false);
    }

    public void resetPlayerRound(){
        setAnteBet(0);
        setPlayBet(0);
        setPairPlusBet(0);
        setTotalRoundEarnings(0);
        setPlayerContinue(true);
        clearHand();
        setPlayerFolded(false);
    }


    // returns the player ante bet for the round
    public int getAnteBet(){
        return anteBet;
    }
    // sets the player ante bet for the round
    public void setAnteBet(int bet){
        anteBet = bet;
    }

    // returns the player bet for the round
    public int getPlayBet(){
        return playBet;
    }
    // sets the player bet for the round
    public void setPlayBet(int bet){
        playBet = bet;
    }

    // returns the player pairplus bet for the round
    public int getPairPlusBet(){
        return pairPlusBet;
    }
    // sets the player pairplus bet for the round
    public void setPairPlusBet(int bet){
        pairPlusBet = bet;
    }

    // set the total money the player has in the game
    public void setBankAcc(int money){
        bankAccount = money;
    }
    // gets the total amount the player has in the game
    public int getBankAcc(){
        return bankAccount;
    }

    // sets whether the player is coninuing the game or not
    public void setPlayerContinue(boolean playerContinue) {
        this.playerContinue = playerContinue;
    }
    // gets whether the player is continuing the game or not
    public boolean getPlayerContinue(){
        return playerContinue;
    }

    // set the total round earnings for the player
    public void setTotalRoundEarnings(int totalRoundEarnings) {
        this.totalRoundEarnings = totalRoundEarnings;
    }
    // returns the total round earnings of the player
    public int getTotalRoundEarnings(){
        return totalRoundEarnings;
    }


    // sets the hand of the player
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }


    // Gets the hand of the player
    public ArrayList<Card> getHand() {
        return hand;
    }

    // clears the hand of the player
    public void clearHand(){
        hand.clear();
    }

    public void setPlayerFolded(boolean fold){
        foldOnWager = fold;
    }

    public boolean PlayerFolded(){
        return foldOnWager;
    }


    public void setTotalWinnings(int win){
        totalWinnings = win;
    }

    public int getTotalWinnings(){
        return totalWinnings;
    }

    public Double getCurrBet(){return (double) (getAnteBet() + getPlayBet() + getPairPlusBet());}

    public void setPlayerRoundDictionary(int gameState){
        roundDictionary.put("Ante Bet", "" + getAnteBet());
        roundDictionary.put("Player Bet", ""+getPlayBet());
        roundDictionary.put("Total Earnings", ""+getTotalWinnings());
        if(gameState == -1){
            roundDictionary.put("Player Won", "Lost");
        }
        else if(gameState == 0){
            roundDictionary.put("Player Won", "Tied");
        }
        else if(gameState == 1){
            roundDictionary.put("Player Won", "Won");
        }

    }

    public HashMap<String, String> getPlayerRoundDictionary(){
        return roundDictionary;
    }
}
