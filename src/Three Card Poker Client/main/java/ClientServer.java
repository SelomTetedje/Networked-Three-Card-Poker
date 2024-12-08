import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientServer extends Thread{
    Integer portNumber;
    String serverAddress = "127.0.0.1"; // Localhost
    Boolean serverOn = false;
    Socket tempSocket;
    Boolean clientOn = true;
    Socket clientSocket;
    Message message;
    ObjectOutputStream objOut;
    ObjectInputStream objIn;
    Socket socket;
    Message receivedMessage;
    Message responseMessage;

    ClientServer(){

    }

    void setPortNumerber(Integer port) throws IOException {
        this.portNumber = port;
        message = new Message();

    }

    public void run(){
        try{

            System.out.println("Client Stats and listening port: "+portNumber);
            socket = new Socket(serverAddress, getPortNumber());
            while(socket.isConnected()){
                // try connecting to the output and input stream
                try {
                    objOut = new ObjectOutputStream(clientSocket.getOutputStream());
                    objIn = new ObjectInputStream(clientSocket.getInputStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                // get message from server
//                try {
                Object obj = objIn.readObject();
                if (obj instanceof Message) {
                    this.receivedMessage = (Message) obj;
                    System.out.println("Received Message: " + this.receivedMessage);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();;
        }

    }

    public Integer getPortNumber(){
        return portNumber;
    }

    public Boolean isClientConnected(){
        return socket.isConnected();
    }

    public Message getMessage(){
        return receivedMessage;
    }

    }
