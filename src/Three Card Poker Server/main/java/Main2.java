//import javafx.fxml.FXML;
public class Main2 {


    public static void main(String[] args) {
        System.out.println("Debug: ClientTester initialization started");
        ClientTester client = new ClientTester();


// Initialize the object that might be causing the issue
        System.out.println("Debug: Object initialized: " + (client == null ? "null" : "initialized"));

        System.out.println("Main2 executed successfully!");
    }
}
