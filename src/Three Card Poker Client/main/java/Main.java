import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private Scene welcomeScene;
    private Scene gameScene;
    private Scene exitScene;
    private ClientServer server;
    GameController controllerServer;

//    private Game game;
    private String currentStyle = "css/OldTime.css";

    @Override
    public void start(Stage primaryStage) throws Exception {
        server = new ClientServer();

        this.primaryStage = primaryStage;
        primaryStage.setTitle("Three Card Poker");
        loadWelcomeScene();
        loadGameScene();
        loadExitScene();

        showWelcomeScene();
    }

    public void loadWelcomeScene() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/welcome.fxml"));

        Parent root = loader.load();

        WelcomeController controller = loader.getController();
        controller.setMainApp(this);

        welcomeScene = new Scene(root, 1500, 700);
        welcomeScene.getStylesheets().add(getClass().getResource(currentStyle).toExternalForm());
        primaryStage.setScene(welcomeScene);
        primaryStage.show();
    }

    private void loadGameScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/game.fxml"));
        Parent root = loader.load();

        GameController controller = loader.getController();
        controllerServer = controller;
//        controller.setGameObject(getServer());
//        controller.setGameObject(new Game(), new ThreeCardLogic());
        controller.setMainApp(this);

        gameScene = new Scene(root, 1500, 700);
        gameScene.getStylesheets().add(getClass().getResource(currentStyle).toExternalForm());
        primaryStage.setScene(gameScene);
    }

    private void loadExitScene() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/exit.fxml"));
        Parent root = loader.load();

        ExitController controller = loader.getController();
        controller.setMainApp(this);

        exitScene = new Scene(root, 1500, 700);
        exitScene.getStylesheets().add(getClass().getResource(currentStyle).toExternalForm());
        primaryStage.setScene(exitScene);
    }

    public void showWelcomeScene() {
        primaryStage.setScene(welcomeScene);
    }

    public void showGameScene() throws Exception {
        controllerServer.setGameObject(getServer());
        primaryStage.setScene(gameScene);
    }

    public void showExitScene() throws Exception {
        primaryStage.setScene(exitScene);
    }

    public void changeStyle(boolean isNewLookPressed) throws IOException {

        welcomeScene.getStylesheets().clear();
        gameScene.getStylesheets().clear();
        exitScene.getStylesheets().clear();


        if (currentStyle.equals("css/OldTime.css")) {
            currentStyle = "css/BenTen.css";
        }
        else {
            currentStyle = "css/OldTime.css";
        }

        // Apply the new style to both scenes
        welcomeScene.getStylesheets().add(getClass().getResource(currentStyle).toExternalForm());
        gameScene.getStylesheets().add(getClass().getResource(currentStyle).toExternalForm());
        exitScene.getStylesheets().add(getClass().getResource(currentStyle).toExternalForm());
    }

    public ClientServer getServer(){
        return server;
    }

    public static void main(String[] args) {
        launch(args);
    }
}