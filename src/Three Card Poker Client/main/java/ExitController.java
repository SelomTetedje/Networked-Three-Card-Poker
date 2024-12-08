import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.animation.*;

import java.io.IOException;

public class ExitController {

    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private TextField portNumber;

    @FXML
    private void quitGame() throws Exception {
        mainApp.showWelcomeScene();
    }

    @FXML
    private void returnToGame() throws Exception {
        mainApp.showGameScene();
    }
}
