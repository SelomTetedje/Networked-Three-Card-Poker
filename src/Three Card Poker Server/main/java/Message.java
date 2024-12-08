import java.io.Serializable;

public class Message implements Serializable {
    String buttonPressed;
    String clientCommand;
    Double AnteBet;
    Double PairPlusBet;
    Double PlayerBet;

    Message(){
        buttonPressed = null;
        clientCommand = null;
        AnteBet = 0.0;
        PairPlusBet = 0.0;
        PlayerBet = 0.0;
    }

    // sets the command that the client will be using to communicate the server
    void setButtonPressed(String buttonPressed){
        this.buttonPressed = buttonPressed;
    }
    String getButtonPressed(){
        return buttonPressed;
    }

    // set the command that the server will be using to commmunicate with the client
    void setClientCommand(String clientCommand){
        this.clientCommand = clientCommand;
    }
    String getClientCommand(){
        return clientCommand;
    }

    //getters and setters for a ante bet
    void setAnteBet(Double bet){
        this.AnteBet = bet;
    }
    Double getAnteBet(){
        return AnteBet;
    }

    // getter and setters for pair plus bet
    void setPairPlusBetBet(Double bet){
        this.PairPlusBet = bet;
    }
    Double getPairPlusBetBet(){
        return PairPlusBet;
    }

    // getters and setters for player bet
    void setPlayerBet(Double bet){
        this.PlayerBet = bet;
    }
    Double getPairPlusBet(){
        return PlayerBet;
    }

}
