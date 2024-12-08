import java.util.ArrayList;
public class Dealer {
    private Deck theDeck;

    // Required
    private ArrayList<Card> dealersHand;

    // Initialize the deck the dealer will use
    Dealer(){
        theDeck = new Deck();
    }

    // Clears the dealer hand
    void clearDealerHand() {
        dealersHand.clear();
    }

    // Set the hand of the Dealer
    void dealDealerHand(){
        dealersHand = dealHand();
    }

    // returns the dealer hand
    ArrayList<Card> getDealersHand(){
        return dealersHand;
    }

    // resets the dealer with an new deck
    void resetDealer(){
        theDeck = new Deck();
    }
    // Required
    // returns a hand of 3 cards that will be given to the users or the dealer
    public ArrayList<Card> dealHand(){
        ArrayList<Card> hand = new ArrayList<>();
        if (theDeck.size() < 35){
            theDeck.newDeck();
        }
        if(theDeck.size() < 3) {
            return hand;
        }
        for(int i = 0; i < 3; i++){
            hand.add(theDeck.remove(theDeck.size() - 1));
        }
        return hand;
    }

    public Deck getDeck(){
        return theDeck;
    }








}
