import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.animation.*;


public class GameController {

    private Main mainApp;
//    private Game game;
//    private Player player1;
//    private Dealer dealer;
//    private ThreeCardLogic cardLogic;
    ClientServer server;


    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    public void setGameObject(ClientServer server) {
        this.server = server;
        System.out.println("Server Port in Game set: " + server.getPortNumber());
        server.start();
        new Thread(() -> {
            while(server.isClientConnected()){
                if(server.getMessage().getClientCommand() != null){

                }
            }

        });
    }

//    // Labels in game.fxml
    @FXML
    private Label menuTitleTextField;

    @FXML
    private Label earningsTextBox1;

    @FXML
    private Label PlayersPlusValuePlayer1;

    @FXML
    private Label earningsValuePlayer1;

    @FXML
    private Label WagerBetBoxLabel1;

    @FXML
    private Label pairPlusBet1;

    @FXML
    private Label AnteBetBoxLabel1;

    @FXML
    private Label BestPairPlusBetBoxLabel1;

    @FXML
    private Label playerOneInfo;

    // Text Fields in game.fxml
    @FXML
    private TextField AnteBetTextBox1;

    @FXML
    private TextField BestPairTextBox1;

    @FXML
    private TextField WagerBetTextBox1;

    // Buttons in game.fxml
    @FXML
    private Button confirmBetPlayer1;

    @FXML
    private Button foldPlayer1;

    @FXML
    private Button wagerPlayer1;

    @FXML
    private Button exit;

    @FXML
    private Button freshStart;

    @FXML
    private Button newLook;

    // Images in game.fxml
    @FXML
    private ImageView playerOneCard1;

    @FXML
    private ImageView playerOneCard2;

    @FXML
    private ImageView playerOneCard3;

    @FXML
    private ImageView playerTwoCard3;

    @FXML
    private ImageView dealerCard1;

    @FXML
    private ImageView dealerCard2;

    @FXML
    private ImageView dealerCard3;
//
//    @FXML
//    private ImageView deck;
//    //     Functions for onHandle
//    @FXML
//    public void initialize() throws Exception{
//        playerOneCard1.setCache(false);
//        playerOneCard2.setCache(false);
//        playerOneCard3.setCache(false);
//
//        playerTwoCard1.setCache(false);
//        playerTwoCard2.setCache(false);
//        playerTwoCard3.setCache(false);
//
//        dealerCard1.setCache(false);
//        dealerCard2.setCache(false);
//        dealerCard3.setCache(false);
//
//        deck.setCache(false);
//
//        Image newImage = new Image("Playing Cards/back_of_card.png");
//
//        PauseTransition delay = new PauseTransition(Duration.seconds(3));
//        delay.setOnFinished(event -> deck.setImage(newImage));
//        delay.play();
//
//        dealHandFaceDownPlayer1();
//        dealHandFaceDownPlayer2();
//        dealHandFaceDownDealer();
//
//        WagerBetTextBox1.setDisable(true);
//        WagerBetTextBox2.setDisable(true);
//
//        wagerPlayer1.setDisable(true);
//        foldPlayer1.setDisable(true);
//
//        wagerPlayer2.setDisable(true);
//        foldPlayer2.setDisable(true);
//
//
//
//
//
//
//        confirmBetPlayer1.disableProperty().addListener((observable, oldValue, newValue) -> checkAndDealHands());
//        confirmBetPlayer2.disableProperty().addListener((observable, oldValue, newValue) -> checkAndDealHands());
//
////        earningsValuePlayer1.setText(player1.getBankAcc() + "");
////        earningsValuePlayer2.setText(player2.getBankAcc() + "");
//    }
//
//    @FXML
//    // makes sure that both players Confirm Bet buttons are disabled
//    private void checkAndDealHands() {
//        if (confirmBetPlayer1.isDisable() && confirmBetPlayer2.isDisable()) {
//            dealHands();
//        }
//    }
//
    @FXML
    // shows the welcome screen after the exit button is pressed
    private void exitMethod() throws Exception{
        mainApp.showExitScene();
    }
//
    @FXML
//    // resets the players and dealers and sets everything back to the start
    private void freshStartMethod() throws Exception{
//        player1.resetPlayer();
//        player2.resetPlayer();
//        dealer.resetDealer();
//
//        earningsValuePlayer1.setText(player1.getTotalWinnings() + "");
//        earningsValuePlayer2.setText(player2.getTotalWinnings() + "");
//
//
//
//        dealHandFaceDownPlayer1();
//        dealHandFaceDownPlayer2();
//        dealHandFaceDownDealer();
//
//        AnteBetTextBox1.setDisable(false);
//        BestPairTextBox1.setDisable(false);
//        confirmBetPlayer1.setDisable(false);
//
//        AnteBetTextBox2.setDisable(false);
//        BestPairTextBox2.setDisable(false);
//        confirmBetPlayer2.setDisable(false);

    }
//
//
//
//    @FXML
//    // resets the players and dealers and sets everything back to the start
//    private void newRound(boolean playerOneFold, boolean PlayerTwoFold, boolean dealerHighEngough) throws Exception{
//        int player1Ante = 0;
//        int player2Ante = 0;
//        if(cardLogic.compareHands(dealer.getDealersHand(), player2.getHand()) == 3){
//            player1Ante = player1.getAnteBet();
//            player2Ante = player2.getAnteBet();
//        }
//        player1.resetPlayerRound();
//        player2.resetPlayerRound();
//        dealer.resetDealer();
//
//        earningsValuePlayer1.setText(player1.getTotalWinnings() + "");
//        earningsValuePlayer2.setText(player2.getTotalWinnings() + "");
//
//
//        String anteBetText2 = AnteBetTextBox2.getText();
//        String bestPairText2 = BestPairTextBox2.getText();
//
//        // Validate the ante bet to ensure it's numeric and within range
//        if (anteBetText2.isEmpty()) {
//            AnteBetTextBox2.setText("5 - 25");
//            return;
//        }
//
//        // parse out the textfield for ante bet and pair plus bet
//        int anteBet2 = Integer.parseInt(anteBetText2);
//        int bestPairBet2 = bestPairText2.isEmpty() ? 0 : Integer.parseInt(bestPairText2);
//
//        // checks if ante Bet is a valid range
//        if (anteBet2 < 5 || anteBet2 > 25) {
//            AnteBetTextBox2.setText("5 - 25");
//            return;
//        }
//        // check if best pair is a valid range
//        if ((bestPairBet2 != 0 && (bestPairBet2 < 5 || bestPairBet2 > 25)) && !bestPairText2.isEmpty()) {
//            BestPairTextBox2.setText("0, 5 - 25");
//            throw new IllegalArgumentException("Pair plus bet must be 0, or between 5 and 25.");
//        }
//
//        // Disable the text boxes and the confirm button after successful parsing
//        AnteBetTextBox2.setDisable(true);
//        BestPairTextBox2.setDisable(true);
//        confirmBetPlayer2.setDisable(true);
//
//        // set player 2 ante bet and pair bet
//        player2.setAnteBet(anteBet2);
//        player2.setPairPlusBet(bestPairBet2);
//
//        dealHandFaceDownPlayer1();
//        dealHandFaceDownPlayer2();
//        dealHandFaceDownDealer();
//
//        dealHands();
//
//        // if player folds remove ante
//        if (playerOneFold || dealerHighEngough) {
//            AnteBetTextBox1.setDisable(false);
//            AnteBetTextBox1.setText("0");
//        }
//        else if( !playerOneFold && !dealerHighEngough ){
//            playerOneInfo.setText("Dealer No Queen High");
//            player1.setAnteBet(player1Ante);
//        }
//
//        BestPairTextBox1.setDisable(false);
//        confirmBetPlayer1.setDisable(false);
//        WagerBetTextBox1.setDisable(true);
//        WagerBetTextBox1.setText("0");
//        BestPairTextBox1.setText("0");
//        PlayersPlusValuePlayer1.setText("0");
//
//        if (PlayerTwoFold || dealerHighEngough) {
//            AnteBetTextBox2.setDisable(false);
//            AnteBetTextBox2.setText("0");
//        }
//        else if (!PlayerTwoFold && !dealerHighEngough){
//            playerTwoInfo.setText("Dealer No Queen High");
//            player2.setAnteBet(player2Ante);
//        }
//
//        BestPairTextBox2.setDisable(false);
//        confirmBetPlayer2.setDisable(false);
//        WagerBetTextBox2.setDisable(true);
//
//        WagerBetTextBox2.setText("0");
//        BestPairTextBox2.setText("0");
//        PlayersPlusValuePlayer2.setText("0");
//    }
//
    @FXML
    private void newLookMethod() throws Exception{
        mainApp.changeStyle(true);
    }
//
    @FXML
//    // deals player 1 card face down
    private void dealHandFaceDownPlayer1() throws Exception{
//        Image newImage = new Image("Playing Cards/back_of_card.png");
//
//        PauseTransition delay1 = new PauseTransition(Duration.seconds(4));
//        delay1.setOnFinished(event -> playerOneCard1.setImage(newImage));
//
//        PauseTransition delay2 = new PauseTransition(Duration.seconds(4.5));
//        delay2.setOnFinished(event -> playerOneCard2.setImage(newImage));
//
//        PauseTransition delay3 = new PauseTransition(Duration.seconds(5));
//        delay3.setOnFinished(event -> playerOneCard3.setImage(newImage));
//
//        delay1.play();
//        delay2.play();
//        delay3.play();
    }
//
//
    @FXML
//    // deals player 2 cards face down
    private void dealHandFaceDownPlayer2() throws Exception{
//        Image newImage = new Image("Playing Cards/back_of_card.png");
//
//        PauseTransition delay1 = new PauseTransition(Duration.seconds(4));
//        delay1.setOnFinished(event -> playerTwoCard1.setImage(newImage));
//
//        PauseTransition delay2 = new PauseTransition(Duration.seconds(4.5));
//        delay2.setOnFinished(event -> playerTwoCard2.setImage(newImage));
//
//        PauseTransition delay3 = new PauseTransition(Duration.seconds(5));
//        delay3.setOnFinished(event -> playerTwoCard3.setImage(newImage));
//
//        delay1.play();
//        delay2.play();
//        delay3.play();
    }
//
    @FXML
//    // deals the dealer cards face down
    private void dealHandFaceDownDealer() throws Exception{
//        Image newImage = new Image("Playing Cards/back_of_card.png");
//
//        PauseTransition delay1 = new PauseTransition(Duration.seconds(4));
//        delay1.setOnFinished(event -> dealerCard1.setImage(newImage));
//
//        PauseTransition delay2 = new PauseTransition(Duration.seconds(4.5));
//        delay2.setOnFinished(event -> dealerCard2.setImage(newImage));
//
//        PauseTransition delay3 = new PauseTransition(Duration.seconds(5));
//        delay3.setOnFinished(event -> dealerCard3.setImage(newImage));
//
//        delay1.play();
//        delay2.play();
//        delay3.play();
    }

    @FXML
//    // makes sure that the confirmBet for player 1 is valid before player can move to the wager or fold
    private void betConfirmPlayer() throws Exception{
////    private void betConfirmPlayer1() throws Exception {
//        try{
//            String anteBetText1 = AnteBetTextBox1.getText();
//            String bestPairText1 = BestPairTextBox1.getText();
//
//            // Validate the ante bet to ensure it's numeric and within range
//            if (anteBetText1.isEmpty()) {
//                AnteBetTextBox1.setText("5 - 25");
//                return;
//            }
//            System.out.println("Pass");
//            int anteBet1 = Integer.parseInt(anteBetText1);
//            int bestPairBet1 = bestPairText1.isEmpty() ? 0 : Integer.parseInt(bestPairText1);
//
//            if (anteBet1 < 5 || anteBet1 > 25) {
////            throw new IllegalArgumentException("Ante bet must be between 5 and 25.");
//                AnteBetTextBox1.setText("5 - 25");
//                return;
//            }
//            if ((bestPairBet1 != 0 && (bestPairBet1 < 5 || bestPairBet1 > 25)) && !bestPairText1.isEmpty()) {
////            throw new IllegalArgumentException("Pair plus bet must be 0, or between 5 and 25.");
//                BestPairTextBox1.setText("0, 5 - 25");
//                return;
//            }
//            player1.setAnteBet(anteBet1);
//            player1.setPairPlusBet(bestPairBet1);
//
//            // Disable the text boxes and the confirm button after successful parsing
//            AnteBetTextBox1.setDisable(true);
//            BestPairTextBox1.setDisable(true);
//            confirmBetPlayer1.setDisable(true);
//            dealHands();
//
//
//        } catch (NumberFormatException e) {
//            // Handle invalid (non-numeric) input
//            System.err.println("Please enter valid numeric values for bets.");
//        } catch (IllegalArgumentException e) {
//            // Handle validation errors
//            System.err.println(e.getMessage());
//        }
//
//
    }

    @FXML
//    // allows the fold and wager button to be clicked
    private void enablePlayerFoldOrWager(){
//
//        WagerBetTextBox1.setDisable(false);
//        WagerBetBoxLabel1.setDisable(false);
//
//        foldPlayer1.setDisable(false);
//        wagerPlayer1.setDisable(false);
//
//        WagerBetTextBox2.setDisable(false);
//        WagerBetBoxLabel2.setDisable(false);
//
//        foldPlayer2.setDisable(false);
//        wagerPlayer2.setDisable(false);
    }
//
    @FXML
//    // shows the cards of the players face up
    private void dealHands(){
//        // checks that both players confirm bet buttons are face up
//        if (confirmBetPlayer1.isDisable() ) {
//            enablePlayerFoldOrWager();
//
//            dealer.dealDealerHand();
//            player1.setHand(dealer.dealHand());
//            player2.setHand(dealer.dealHand());
//
//            // Get the file names for each card and set the images
//            String player1First = String.format("%d_%s.png", player1.getHand().get(0).getValue(), player1.getHand().get(0).getSuit());
//            String player1Second = String.format("%d_%s.png", player1.getHand().get(1).getValue(), player1.getHand().get(1).getSuit());
//            String player1Third = String.format("%d_%s.png", player1.getHand().get(2).getValue(), player1.getHand().get(2).getSuit());
//
//            String player2First = String.format("%d_%s.png", player2.getHand().get(0).getValue(), player2.getHand().get(0).getSuit());
//            String player2Second = String.format("%d_%s.png", player2.getHand().get(1).getValue(), player2.getHand().get(1).getSuit());
//            String player2Third = String.format("%d_%s.png", player2.getHand().get(2).getValue(), player2.getHand().get(2).getSuit());
//            System.out.println("Playing Cards/" + player1First);
//            // Load and set images
//
//            flipCard(playerOneCard1, player1First, Duration.seconds(0.5));
//            flipCard(playerOneCard2, player1Second, Duration.seconds(1.5));
//            flipCard(playerOneCard3, player1Third, Duration.seconds(2.5));
//
//            flipCard(playerTwoCard1, player2First, Duration.seconds(0.5));
//            flipCard(playerTwoCard2, player2Second, Duration.seconds(1.5));
//            flipCard(playerTwoCard3, player2Third, Duration.seconds(2.5));
//
//
//            // pair plus 1 card compare
//            int pairWinings1 = cardLogic.evalPPWinnings(player1.getHand(), player1.getPairPlusBet());
//            if (pairWinings1 == 0) {
//                PlayersPlusValuePlayer1.setText("0");
//            }
//            else{
//                PlayersPlusValuePlayer1.setText(pairWinings1 + "");
//            }
//
//            // pair plus 2 card compare
//            int pairWinings2 = cardLogic.evalPPWinnings(player2.getHand(), player2.getPairPlusBet());
//            if (pairWinings2 == 0) {
//                PlayersPlusValuePlayer2.setText("0");
//            }
//            else{
//                PlayersPlusValuePlayer2.setText(pairWinings2 + "");
//            }
//        }
    }
//
//    @FXML
//    private void showDealerHand(){
//        String dealerFirst = String.format("%d_%s.png", dealer.getDealersHand().get(0).getValue(), dealer.getDealersHand().get(0).getSuit());
//        String dealerSecond = String.format("%d_%s.png", dealer.getDealersHand().get(1).getValue(), dealer.getDealersHand().get(1).getSuit());
//        String dealerThird = String.format("%d_%s.png", dealer.getDealersHand().get(2).getValue(), dealer.getDealersHand().get(2).getSuit());
//
//        flipCard(dealerCard1, dealerFirst, Duration.seconds(0.5));
//        flipCard(dealerCard2, dealerSecond, Duration.seconds(1.5));
//        flipCard(dealerCard3, dealerThird, Duration.seconds(2.5));
//    }
//
//
//    @FXML
//    private void flipCard(ImageView cardView, String frontImage, Duration delay) {
//
//        TranslateTransition liftUp = new TranslateTransition(Duration.millis(300), cardView);
//        liftUp.setToY(-30);
//
//        ScaleTransition flipMid = new ScaleTransition(Duration.millis(300), cardView);
//        flipMid.setFromX(1.0);
//        flipMid.setToX(0.0);
//
//        flipMid.setOnFinished(event -> cardView.setImage(new Image("Playing Cards/" + frontImage)));
//
//        ScaleTransition flipEnd = new ScaleTransition(Duration.millis(300), cardView);
//        flipEnd.setFromX(0.0);
//        flipEnd.setToX(1.0); // Expand back to full width
//
//        TranslateTransition lower = new TranslateTransition(Duration.millis(300), cardView);
//        lower.setToY(0);
//
//        SequentialTransition fullFlip = new SequentialTransition(
//                new PauseTransition(delay),
//                liftUp,
//                flipMid,
//                flipEnd,
//                lower
//        );
//
//        fullFlip.play();
//    }
//
//
//    // wager functions
//    @FXML
//    // makes sure that the wager for player 1 is valid before moving to compairson with dealer
//    private void wagerButtonPressed1() throws Exception{
//        try {
//            // Get input from the text boxes
//            String wagerBetText = WagerBetTextBox1.getText();
//
//
//            // Validate the ante bet to ensure it's numeric and within range
//            if (wagerBetText.isEmpty()) {
//                WagerBetTextBox1.setText( (player1.getAnteBet() + "") + " - 25");
//                return;
//            }
//
//            // gets the wager bet from the text box and the checks if its a valid range
//            int wagerBet = Integer.parseInt(wagerBetText);
//            if (wagerBet < player1.getAnteBet() || wagerBet > 25) {
//                WagerBetTextBox1.setText( (player1.getAnteBet() + "") + " - 25");
//                return;
//            }
//
//            // Disable the text boxes and the confirm button after successful parsing
//            WagerBetTextBox1.setDisable(true);
//            player1.setPlayBet(wagerBet);
//
//            // disable the fold and the wager button for player 1
//            wagerPlayer1.setDisable(true);
//            foldPlayer1.setDisable(true);
//            player1.setPlayerFolded(false);
////            BothPlayerMadeWagerOrFoldChoice();
//            BothPlayerMadeChoiceToBet();
//
//        } catch (NumberFormatException e) {
//            // Handle invalid (non-numeric) input
//            System.err.println("Please enter valid numeric values for bets.");
//        } catch (IllegalArgumentException e) {
//            // Handle validation errors
//            System.err.println(e.getMessage());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    // Fold functions
//    @FXML
//    private void foldButtonPressed1() throws Exception{
//
//        // Disable the text boxes and the confirm button after successful parsing
//        WagerBetTextBox1.setDisable(true);
//
//        // disable the fold and the wager button for player 1
//        wagerPlayer1.setDisable(true);
//        foldPlayer1.setDisable(true);
//
//        player1.setPlayerFolded(true);
////        BothPlayerMadeWagerOrFoldChoice();
//        BothPlayerMadeChoiceToBet();
//    }
//
//
//    // compares the cards of both players
//    @FXML
//    private void BothPlayerMadeChoiceToBet() throws Exception{
//        if (!WagerBetTextBox1.isDisable() || !WagerBetTextBox2.isDisable()) {
//            return;
//        }
//        showDealerHand();
//
//        boolean isDealerHighEnough = cardLogic.compareHands(dealer.getDealersHand(), player1.getHand()) != 3;
//        int player1PairEarnings = cardLogic.evalPPWinnings(player1.getHand() ,player1.getPairPlusBet() );
//
//        boolean lockAnteBetPlayer1 = false;
//
//
//        PlayersPlusValuePlayer2.setText(player1PairEarnings + "");
//
//
//        if(player1.PlayerFolded()){
//            playerOneInfo.setText("Player 1 Folded");
//            player1PairEarnings = 0;
//            int tempTotalEarningsP1 = player1.getTotalWinnings() - player1.getAnteBet() - player1.getPairPlusBet();
//            if(tempTotalEarningsP1 < 0){
//                player1.setTotalWinnings(0);
//            }
//            else{
//                player1.setTotalWinnings(tempTotalEarningsP1);
//            }
//        }
//        else{
//            // Reveal DealersHand
//            // does dealer have high enough card
//            if(isDealerHighEnough){
//                boolean playerHigherHand = cardLogic.compareHands(dealer.getDealersHand(), player1.getHand()) == 2;
//                // check if player have a higher hand then dealer
//                if(playerHigherHand){
//                    playerOneInfo.setText("Player 1 Beat Dealer");
//                    player1.setTotalWinnings(player1.getTotalWinnings() + player1.getPlayBet());
//                }
//                else{
//                    playerOneInfo.setText("Dealer beat Player 1");
////                    player1PairEarnings = 0;
//                    int tempTotalEarningsPlayer1 = player1.getTotalWinnings() - player1.getPlayBet() - player1.getAnteBet();
//                    if(tempTotalEarningsPlayer1 < 0){
//                        player1.setTotalWinnings(0);
//                    }
//                    else{
//                        player1.setTotalWinnings(tempTotalEarningsPlayer1);;
//                    }
//                }
//            }
//            // dealer has lower hand than required
//            else{
//                playerOneInfo.setText("Dealer has less than Queen High. Wager Returned");
//                lockAnteBetPlayer1 = true;
//                player1.setPlayBet(0);
//            }
//            player1.setTotalWinnings(player1.getTotalWinnings() + player1PairEarnings);
//        }
//
//
//
//        if(player2.PlayerFolded()){
//            playerTwoInfo.setText("Player 2 Folded");
//            player2PairEarnings = 0;
//            int tempTotalEarningsP2 = player2.getTotalWinnings() - player2.getAnteBet() - player2.getPairPlusBet();
//            if(tempTotalEarningsP2 < 0){
//                player2.setTotalWinnings(0);
//            }
//            else{
//                player2.setTotalWinnings(tempTotalEarningsP2);
//            }
//        }
//        else{
//            // Reveal DealersHand
//            // does dealer have high enough card
//            if(isDealerHighEnough){
//                boolean playerHigherHand = cardLogic.compareHands(dealer.getDealersHand(), player2.getHand()) == 2;
//                // check if player have a higher hand then dealer
//                if(playerHigherHand){
//                    playerTwoInfo.setText("Player 2 Beat Dealer");
//                    player2.setTotalWinnings(player2.getTotalWinnings() + player2.getPlayBet() + player2PairEarnings);
//                }
//                else{
//                    playerTwoInfo.setText("Dealer Beat Player 2");
//                    int tempTotalEarningsPlayer2 = player2.getTotalWinnings()- player2.getPlayBet() - player2.getAnteBet();
//                    if(tempTotalEarningsPlayer2 < 0){
//                        player2.setTotalWinnings(0);
//                    }
//                    else{
//                        player2.setTotalWinnings(tempTotalEarningsPlayer2);;
//                    }
//                }
//            }
//            // dealer has lower hand than required
//            else{
//                playerTwoInfo.setText("Dealer has less than Queen High. Wager Returned");
//                lockAnteBetPlayer2 = true;
//                player2.setPlayBet(0);
//            }
//            player2.setTotalWinnings(player2.getTotalWinnings() + player2PairEarnings);
//        }
//
//
//        newRoundDisplay(lockAnteBetPlayer1, lockAnteBetPlayer2);
//
//
//    }
//
//    @FXML
//    private void newRoundDisplay(boolean lockPlayer1AnteBet) throws Exception{
//        // Let Server Know that a new Round is beginning
//        player1.setPlayBet(0);
//        player1.setPairPlusBet(0);
//
//        player2.setPlayBet(0);
//        player2.setPairPlusBet(0);
//
//        foldPlayer1.setDisable(true);
//        wagerPlayer1.setDisable(true);
//        foldPlayer2.setDisable(true);
//        wagerPlayer2.setDisable(true);
//
//        AnteBetTextBox1.setDisable(false);
//        BestPairTextBox1.setDisable(false);
//        confirmBetPlayer1.setDisable(false);
//
//        if(lockPlayer1AnteBet){
//            AnteBetTextBox1.setDisable(true);
//        }
//        else{
//            player1.setAnteBet(0);
//        }
//
//
//
//
//        player1.setPlayBet(0);
//
//
//
//
//        AnteBetTextBox1.setText(player1.getAnteBet() + "");
//
//
//        WagerBetTextBox1.setText(player1.getPlayBet() + "");
//
//
//        BestPairTextBox1.setText(player1.getPairPlusBet() + "");
//
//
//
//
//        earningsValuePlayer1.setText(player1.getTotalWinnings() + "");
//
//
//        PlayersPlusValuePlayer1.setText(player1.getPairPlusBet() + "");
//
//
//        dealHandFaceDownPlayer1();
//        dealHandFaceDownPlayer2();
//        dealHandFaceDownDealer();
//        dealHands();
//    }
}
