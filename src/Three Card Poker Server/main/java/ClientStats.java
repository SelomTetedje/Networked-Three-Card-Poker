public class ClientStats {
    private int numRounds;
    private String gameStatus;
    private Double curBet;
    private Double winLossRatio;
    private int numWins;
    private int clientID;


    ClientStats() {
        numRounds = 0;
        gameStatus = "Start";
        curBet = 0.0;
        numWins = 0;
        winLossRatio = 0.0;
    }
    ClientStats(Integer id) {
        numRounds = 0;
        gameStatus = "Start";
        curBet = 0.0;
        numWins = 0;
        winLossRatio = 0.0;
        clientID = id;
    }

    void setNumRounds(int numRounds) {
        this.numRounds = numRounds;
    }
    int getNumRounds() {
        return numRounds;
    }

    void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }
    String getGameStatus() {
        return gameStatus;
    }

    void setCurBet(Double curBet) {
        this.curBet = curBet;
    }
    Double getCurBet() {
        return curBet;
    }

    void setWinLossRatio(Double winLossRatio) {
        this.winLossRatio = winLossRatio;
    }
    Double getWinLossRatio() {
        return winLossRatio;
    }

    void setNumWins(int numWins) {
        this.numWins = numWins;
    }
    void getNumWins() {
        this.numWins = numWins;
    }

    void setClientID(int id){
        this.clientID = id;
    }
    Integer getClientID(){
        return clientID;
    }
}
