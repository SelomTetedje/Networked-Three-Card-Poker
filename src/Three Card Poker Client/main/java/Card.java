public class Card {
    private char suit;
    private int value;

    // Constructor
    public Card(char suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    // Getters and Setters for suit and value
    public char getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    public void setValue(int value) {
        this.value = value;
    }
}