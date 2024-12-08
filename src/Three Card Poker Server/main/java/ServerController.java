import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ServerController {

    private Main mainApp;
    private Server server;
    Thread serverThread;
    Thread clientThread;
    Integer numClients = 0;
    Integer serverPort = 0;

    ClientTester testClient;
    @FXML
    TextField PortNumTextField;
    @FXML
    Button ServerOffButton;
    @FXML
    Button ServerOnButton;
    @FXML
    ListView<String> ServerNotiList;
    @FXML
    ListView<String> ClientList;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        ServerOffButton.setDisable(true);

    }

    private void guiUpdate(){
        clientThread = new Thread(() ->{
            System.out.println("System is live: " + server.serverIsLive());
            // Code to update UI components safely on the FX Application Thread
            while(server.getServerStatus()){
//                System.out.println("GUI is updating");
                if(numClients != server.getClientsStats().size()){
                    System.out.println("GUI Updated");;
                    // Safely update the UI on the JavaFX Application Thread
                    Platform.runLater(() -> {
                        ServerNotiList.getItems().clear();
                        ClientList.getItems().clear();
                        addServerNotification("Server Started port: " + 1);
                        for (ClientStats clientStats : server.getClientsStats()) {
                            addServerNotification("Client " + clientStats.getClientID() + " joined server");
                            upDateClientList("Client: " + clientStats.getClientID());
                        }
                    });
                    numClients = server.getClientsStats().size();
                }
            }

            numClients = 0;
            System.out.println("System is live: " + server.serverIsLive());

        });

        clientThread.start();
    }

    private void clientAdded(Integer ClientID){

    }

    @FXML
    private void startServer() throws Exception {
        // Get input from the text boxes
        String portNumber = PortNumTextField.getText();


        // Validate the ante bet to ensure it's numeric and within range
        if (portNumber.isEmpty()){
            PortNumTextField.setText("Needs Valid Port Number");
            return;
        }

        // check if user put valid port number
        int port = Integer.parseInt(portNumber);
        if(port <= 0 || port >= 65535){
            PortNumTextField.setText("Needs Valid Port Number");
            return;
        }

        // initialize server and update server notification
        System.out.println("Starting Server");
        serverPort = port;
        server = new Server(port);

        // create a new thread for
//        serverThread = new Thread(() -> {
//            try{
//
//                server.run();
//            }
//            catch(Exception e){
//                e.printStackTrace();
//            }
//        });
        guiUpdate();
        server.start();

        ServerOnButton.setDisable(true);
        ServerOffButton.setDisable(false);
        addServerNotification("Server Started port: " + port);
        System.out.println("Server Started port: '" + port+"'");

    }

    @FXML
    private void stopServer() throws Exception {
        System.out.println("Stopping Server");


        numClients = 0;
        // clear server notification then add server stopped
//        ServerNotiList.getItems().clear();
//        ServerNotiList.getItems().add("Server Stopped");
//        System.out.println("Server Stopped");

        server.stopServer();
        ServerOnButton.setDisable(false);
        ServerOffButton.setDisable(true);



    }

    @FXML
    private void addServerNotification(String message){
        ServerNotiList.getItems().add(message);
    }

    @FXML
    private void upDateClientList(String message){
        ClientList.getItems().add(message);
    }

    @FXML
    private void addClientServer(int ClientID){

    }
}
