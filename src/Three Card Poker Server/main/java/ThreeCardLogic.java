import java.util.ArrayList;
import java.util.Collections;

public class ThreeCardLogic {

    // Evaluates the hand and returns a number based on the hand type
    public static int evalHand(ArrayList<Card> hand) {
        // Get the values of each card in the hand
        int firstCardVal = hand.get(0).getValue();
        int secondCardVal = hand.get(1).getValue();
        int thirdCardVal = hand.get(2).getValue();

        // Get the suits of each card in the hand
        char firstCardSuit = hand.get(0).getSuit();
        char secondCardSuit = hand.get(1).getSuit();
        char thirdCardSuit = hand.get(2).getSuit();

        // Sort the values
        ArrayList<Integer> values = new ArrayList<>();
        values.add(firstCardVal);
        values.add(secondCardVal);
        values.add(thirdCardVal);
        Collections.sort(values);

        // Check if it's a Straight Flush, return 1
        if (isStraight(values) && isFlush(firstCardSuit, secondCardSuit, thirdCardSuit)) {
            return 1;
        }

        // Check if it's a Three of a Kind, return 2
        if (firstCardVal == secondCardVal && firstCardVal == thirdCardVal) {
            return 2;
        }

        // Check if it's a Straight, return 3
        if (isStraight(values)) {
            return 3;
        }

        // Check if it's a Flush, return 4
        if (isFlush(firstCardSuit, secondCardSuit, thirdCardSuit)) {
            return 4;
        }

        // Check if it's a Pair, return 5
        if (firstCardVal == secondCardVal || firstCardVal == thirdCardVal || secondCardVal == thirdCardVal) {
            return 5;
        }

        // If none of the above, return 0 for high card
        return 0;
    }

    // Returns the winnings for wager bet
    public static int evalPPWinnings(ArrayList<Card> hand, int bet) {
        int handType = evalHand(hand);

        switch (handType) {
            case 1: // Straight Flush
                return bet * 40;
            case 2: // Three of a Kind
                return bet * 30;
            case 3: // Straight
                return bet * 6;
            case 4: // Flush
                return bet * 3;
            case 5: // Pair
                return bet * 1;
            default: // No winning hand
                return 0;
        }
    }

    // Compares dealer's and player's hands and returns the winner
    public static int compareHands(ArrayList<Card> dealer, ArrayList<Card> player) {
        int dealerHandValue = evalHand(dealer);
        int playerHandValue = evalHand(player);

        // Dealer wins
        if (dealerHandValue > playerHandValue) {
            return 1;
        }
        // Player wins
        else if (playerHandValue > dealerHandValue) {
            return 2;
        }

        // If hand types are the same, use high card rules
        return compareHighCards(dealer, player);
    }

    // Helper method to check if the values form a straight
    private static boolean isStraight(ArrayList<Integer> values) {
        return (values.get(2) - values.get(1) == 1 && values.get(1) - values.get(0) == 1) || (values.contains(14) && values.contains(2) && values.contains(3)); // Ace-low straight
    }

    // Helper method to check if all suits are the same (Flush)
    private static boolean isFlush(char suit1, char suit2, char suit3) {
        return (suit1 == suit2 && suit2 == suit3);
    }

    // Helper method to compare high cards when hand types are the same
    private static int compareHighCards(ArrayList<Card> dealer, ArrayList<Card> player) {
        // Sort cards in each hand for comparison
        ArrayList<Integer> dealerValues = new ArrayList<>();
        ArrayList<Integer> playerValues = new ArrayList<>();

        for (Card card : dealer) {
            dealerValues.add(card.getValue());
        }
        for (Card card : player) {
            playerValues.add(card.getValue());
        }

        Collections.sort(dealerValues, Collections.reverseOrder());
        Collections.sort(playerValues, Collections.reverseOrder());

        if (dealerValues.get(0) < 12) {
            return 3; // Dealer high card is not at least a queen, return stuff to player
        }

        // Compare each card in descending order
        for (int i = 0; i < dealerValues.size(); i++) {
            if (dealerValues.get(i) > playerValues.get(i)) {
                return 1; // Dealer wins
            } else if (playerValues.get(i) > dealerValues.get(i)) {
                return 2; // Player wins
            }
        }

        // If all cards are equal return 0 for tie
        return 0;
    }
}
