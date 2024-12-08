import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientTester{
    String serverAddress = "127.0.0.1"; // Localhost
    int port = 12345; // Port number the server is listening on
    Socket tempSocket;
    Boolean clientOn = true;
    BufferedReader input;
    PrintWriter output;
    BufferedReader consoleInput;
    ClientTester(){
        String serverAddress = "127.0.0.1"; // Localhost
        int port = 12345; // Port number the server is listening on

        try {

            Socket socket = new Socket(serverAddress, port);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            if(socket.isConnected()){
                System.out.println("Connected to the server at " + serverAddress + " on port " + port);
                System.out.println("debug : assigning tempsocket");
                tempSocket = socket;
                System.out.println("debug when assigning tempsocket : " + tempSocket);
            }
            else{
                System.out.println("Client failed to connect with server at " + serverAddress + " on port " + port);
                return;
            }


            // Communication loop
            String userInput;
            while (tempSocket.isConnected() && clientOn) {
//                System.out.print("Enter a message (type 'exit' to quit): ");
//                userInput = consoleInput.readLine(); // Read user input from the console
//
////                if ("exit".equalsIgnoreCase(userInput)) {
////                    System.out.println("Closing connection...");
////                    clientOn = false;
////                    break;
////                }
//
//                output.println(userInput); // Send message to the server
//                String serverResponse = input.readLine(); // Read response from the server
//                System.out.println("Server response: " + serverResponse);
            }

            if (tempSocket.isClosed()) {
                System.out.println("Server got closed");
            }

            if(!clientOn){
                System.out.println("debug : checking if its going in condition when client is off");
                close();
            }
        } catch (IOException e) {
            System.err.println("Error connecting to the server: " + e.getMessage());
        }
    }

    void close() throws IOException {
        clientOn = false;
        tempSocket.close();
    }

    Boolean getClientStatus(){
        return clientOn;
    }
}
