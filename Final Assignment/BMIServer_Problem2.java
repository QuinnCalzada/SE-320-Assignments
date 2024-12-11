// Problem 2: Multithreaded Server Program 
import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BMIServer_Problem2 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool(); // Thread pool for handling clients
        System.out.println("[SERVER] Server is running...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept(); // Accept client connection
                System.out.println("[SERVER] Connected to a client.");
                executor.execute(new ClientHandler(clientSocket)); // Handle each client in a separate thread
            }
        } catch (IOException e) {
            System.err.println("[SERVER] Error starting server: " + e.getMessage());
        } finally {
            executor.shutdown(); // Shutdown thread pool when server stops
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {

            // Read data from client
            double weight = in.readDouble();
            double height = in.readDouble();

            // Calculate BMI
            double bmi = weight / (height * height);
            System.out.println("[SERVER] Calculated BMI: " + bmi);

            // Send BMI response back to client
            out.writeUTF("Your BMI is: " + String.format("%.2f", bmi));
            out.flush();
        } catch (IOException e) {
            System.err.println("[SERVER] Error handling client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close(); // Ensure client socket is closed
                System.out.println("[SERVER] Disconnected from client.");
            } catch (IOException e) {
                System.err.println("[SERVER] Error closing client socket: " + e.getMessage());
            }
        }
    }
}