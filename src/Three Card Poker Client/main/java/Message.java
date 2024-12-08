import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L; // Best pract
    String buttonPressed;
    String clientCommand;
    Double AnteBet;
    Double PairPlusBet;
    Double PlayerBet;
    private ArrayList<Card> dealersHand;
    private ArrayList<Card> playerHand;


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
    Double getPairPlusBet(){
        return PairPlusBet;
    }

    // getters and setters for player bet
    void setPlayerBet(Double bet){
        this.PlayerBet = bet;
    }
    Double getPlayerBet(){
        return PlayerBet;
    }

    @Override
    public String toString() {
        return "Message{" +
                "buttonPressed='" + buttonPressed + '\'' +
                ", clientCommand='" + clientCommand + '\'' +
                ", anteBet=" + getAnteBet() +
                ", pairPlusBet=" + getPairPlusBet() +
                ", playerBet=" + getPlayerBet() +
                '}';
    }
}