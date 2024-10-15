import java.util.Scanner;

public class Assignment2_Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        
        try {
            System.out.print("Enter a number between 0 and 10: ");
            number = scanner.nextInt();  // Read user input
            
            // If the assertion passes, print the number
            System.out.println("You entered: " + number);

        } catch (AssertionError e) {
            // Catch and display the assertion error
            System.out.println(e.getMessage());

        } catch (Exception e) {
            // Handle invalid inputs like non-integer values
            System.out.println("Invalid input! Please enter an integer between 0 and 10.");
        }
        
        // Assert to check if the number is between 0 and 10 (inclusive)
        assert (number >= 0 && number <= 10) : "The entered number is out of range";

        scanner.close();
    }
}
