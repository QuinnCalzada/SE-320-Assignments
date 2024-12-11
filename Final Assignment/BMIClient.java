import java.io.*;
import java.net.*;

class BMIClient {
    private static final double WEIGHT = 89.36; // Weight(kg), edit this value to change
    private static final double HEIGHT = 1.98;  // Height(m),  edit this value to change

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234)) { // Connect to server on port 12346
            System.out.println("[CLIENT] Connected to server.");

            try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

                // Send data to server
                out.writeDouble(WEIGHT);
                out.writeDouble(HEIGHT);
                out.flush();

                // Receive BMI response and print it
                String response = in.readUTF();
                System.out.println("[CLIENT] " + response);

            } catch (IOException e) {
                System.err.println("[CLIENT] Error during communication: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("[CLIENT] Unable to connect to server: " + e.getMessage());
        }
    }
}