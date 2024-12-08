import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private Scene serverScene;
    private Scene gameScene;
    private Scene exitScene;
    private Game game;
    private String currentStyle = "css/OldTime.css";

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Three Card Poker Server");

        loadServerScene();

        showServerScene();
    }

    public void loadServerScene() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/server.fxml"));

        Parent root = loader.load();

        ServerController controller = loader.getController();
        controller.setMainApp(this);

        serverScene = new Scene(root, 1500, 700);
        serverScene.getStylesheets().add(getClass().getResource(currentStyle).toExternalForm());
        primaryStage.setScene(serverScene);
        primaryStage.show();
    }


    public void showServerScene() {
        primaryStage.setScene(serverScene);
    }

    public void changeStyle(boolean isNewLookPressed) throws IOException {

        serverScene.getStylesheets().clear();
        gameScene.getStylesheets().clear();
        exitScene.getStylesheets().clear();


        if (currentStyle.equals("css/OldTime.css")) {
            currentStyle = "css/BenTen.css";
        }
        else {
            currentStyle = "css/OldTime.css";
        }

        // Apply the new style to both scenes
        serverScene.getStylesheets().add(getClass().getResource(currentStyle).toExternalForm());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
