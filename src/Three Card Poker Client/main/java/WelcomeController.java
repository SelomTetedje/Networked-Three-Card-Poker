import javafx.fxml.FXML;
import javafx.scene.control.*;

public class WelcomeController {

    private Main mainApp;


    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private TextField portNumber;

    @FXML
    private void handleStartGame() throws Exception {
        verifyPortNumber();
    }

    @FXML
    private void verifyPortNumber() throws Exception {
        if (portNumber.getText() == null) {
            portNumber.setText("Please enter a port number");
        }

        else if (!(portNumber.getText().equals("12345"))){
            portNumber.setText("Please enter a valid port number");
        }
        else{
            mainApp.showGameScene();
        }
    }
}
