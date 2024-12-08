import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Card> {

    // Constructor to create a new shuffled deck
    public Deck() {
        newDeck();
    }

    // Method to clear and create a new shuffled deck
    public void newDeck() {
        // Clear any existing cards
        this.clear();

        // Loop through each suit and value to create the 52 cards
        char[] suits = {'S', 'H', 'D', 'C'};
        for (char suit : suits) {
            for (int value = 2; value <= 14; value++) {
                this.add(new Card(suit, value));
            }
        }
        // Shuffle the deck
        Collections.shuffle(this);
    }

    // Getter for the deck
    public ArrayList<Card> getDeck(){
        return new ArrayList<Card>(this);
    }

    // Adding an array of cards to the deck
    public void addToDeck(ArrayList<Card> deck){
        this.addAll(deck);
    }

    public void shuffle(){
        Collections.shuffle(this);
    }
}
