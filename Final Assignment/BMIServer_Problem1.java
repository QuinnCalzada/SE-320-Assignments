import java.io.*;
import java.net.*;

class BMIServer_Problem1 {
    private static final int PORT = 1234;
    
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) { // Listening on port 12346
            System.out.println("[SERVER] Server is running...");
            
            while (true) {
                Socket clientSocket = serverSocket.accept(); // Accept client connection
                System.out.println("[SERVER] Connected to a client.");

                try (ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                     ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {

                    // Read data from client
                    double weight = in.readDouble();
                    double height = in.readDouble();

                    // Calculate BMI
                    double bmi = weight / (height * height);

                    // Send BMI response back to client as a string
                    out.writeUTF("Your BMI is: " + bmi);
                    out.flush();

                } catch (IOException e) {
                    System.err.println("[SERVER] Error processing client request: " + e.getMessage());
                } finally {
                    clientSocket.close(); // Close connection
                    System.out.println("[SERVER] Disconnected from client.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
