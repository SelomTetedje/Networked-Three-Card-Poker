import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Server extends Thread {
    private ServerSocket server;
    private DataInputStream in;
    private DataOutputStream out;
    private Boolean serverStatus = false;
    private Integer numClients = 0;
    private static int port = 8080;
    public static final String STOP_SERVER = "###";
    public static Map<Integer, ClientStats> clientsStat = new ConcurrentHashMap<>();

    public static Map<Integer, Thread> clientThreads =  new ConcurrentHashMap<>();


    public Server(int port) {
        try {
            this.port = port;
            server = new ServerSocket(port, 50, InetAddress.getByName("127.0.0.1"));
            serverStatus = true;
            //startServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void run() {
        while (serverStatus) {
            try {
                // Check if the server should stop
                if (Thread.interrupted()) {
                    System.out.println("Server is closing remove client");
                    break;
                    //throw new InterruptedException(); // Explicitly throw an exception to exit the loop
                }
                System.out.println("Server is active and waiting for a client");
                Socket clientSocket = server.accept();
//
                System.out.println("Here server has accepted connection");
                int clientId = numClients++;
                // syncronizes addding client
                synchronized (clientsStat) {
                    clientsStat.put(clientId, new ClientStats(clientId));
                }
                Thread clientThread = new Thread(() -> {
                    try {
                        int localClientId = clientId;
                        ClientConnection newClient = new ClientConnection(clientSocket);



                        while (newClient.getClientConnected() && newClient.getGame().getContinueGame() && serverStatus) {
                            newClient.readMessage();
                            synchronized (clientsStat) {
                                clientsStat.get(localClientId).setNumRounds(newClient.getGame().getNumRounds());
                                clientsStat.get(localClientId).setNumWins(newClient.getGame().getNumPlayerWins());
                                clientsStat.get(localClientId).setCurBet(newClient.getPlayer().getCurrBet());
                                clientsStat.get(localClientId).setGameStatus(newClient.getGameStatus());
                            }
                        }
                        synchronized (clientsStat) {
                            if (clientsStat.containsKey(localClientId)) {
                                System.out.println("Client with ID " + localClientId + " disconnected abruptly.");
                                clientsStat.remove(localClientId);
                            }
                        }
                        newClient.close();
                        // Remove client thread from the map and notify the server
                        if (clientThreads.containsKey(localClientId)) {
                            clientThreads.get(localClientId).interrupt();
                            clientThreads.remove(localClientId);
                        }

                        System.out.println("Closed Client Thread");
                    } catch (IOException e) {
                        System.err.println("Error while handling client connection: " + e.getMessage());
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                });


                clientThread.start();

                System.out.println("New Client was added");

            }
            catch (IOException e) {
                System.err.println("Error while accepting client connection: " + e.getMessage());
                try {
                    stopServer();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                e.printStackTrace();
            }
        }
        serverStatus = false;
    }

    public void stopServer() throws IOException {
        serverStatus = false;
        clientsStat.clear();
        clientThreads.clear();
        server.close();
    }

    public Integer getNumClients(){
        return numClients;
    }

    public Boolean serverIsLive(){
        return !server.isClosed();
    }

    public ArrayList<ClientStats> getClientsStats(){
        return new ArrayList<>(clientsStat.values());
    }

    public Boolean getServerStatus(){
        return serverStatus;
    }
}

