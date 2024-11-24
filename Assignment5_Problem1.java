import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Assignment5_Problem1 {
	
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
    	// Define a constant for the number of milliseconds in a day
        final long MILLISECONDS_PER_DAY = 1000 * 60 * 60 * 24;
        int day = 0, month = 0, year = 0;
        
        Scanner scanner = new Scanner(System.in);

        // Validate the month input
        while (true) {
            System.out.print("Enter the month you were born (1-12): ");
            month = scanner.nextInt();
            if (month >= 1 && month <= 12) {
                break; // valid month
            } else {
                System.out.println("Invalid month. Please enter a value between 1 and 12.\n");
            }
        }

        // Validate the day input
        while (true) {
            System.out.print("Enter the day you were born (1-31): ");
            day = scanner.nextInt();
            if (isValidDay(day, month, year)) {
                break; // valid day for the given month
            } else {
                System.out.println("Invalid day for the given month. Please enter a valid day.\n");
            }
        }

        // Validate the year input
        while (true) {
            System.out.print("Enter the year you were born: ");
            year = scanner.nextInt();
            int currentYear = new Date().getYear() + 1900; // get the current year
            if (year <= currentYear) {
                break; // valid year
            } else {
                System.out.println("Invalid year. Please enter a valid year.\n");
            }
        }

        // Format the user input into a string that is compatible with the DateFormat parser
        String birthDateString = String.format("%02d %02d %04d", day, month, year);

        // Create a SimpleDateFormat instance for parsing the input string into a Date object
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");

        try {
            // Parse the birth date string into a Date object
            Date birthDate = dateFormat.parse(birthDateString);
            Date currentDate = new Date();

            // Calculate the elapsed time between the two dates which will be given in milliseconds
            long elapsedTime = currentDate.getTime() - birthDate.getTime();
            // Convert the elapsed time from milliseconds to days
            long daysElapsed = elapsedTime / MILLISECONDS_PER_DAY;

            // Display the result
            System.out.println("Days since birth: " + daysElapsed);

        } catch (ParseException e) {
            // Handle invalid date input
            System.out.println("Invalid date. Please check your input.");
        }

        scanner.close(); // Close the scanner resource
    }
    
    // Method to check if the given year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }
    
    // Method to check if the day is valid for the given month and year
    private static boolean isValidDay(int day, int month, int year) {
        // Days in each month
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // If the month is February[1], check for leap year
        if (month == 2) {
            if (isLeapYear(year)) {
                daysInMonth[1] = 29;
            } else {
                daysInMonth[1] = 28; 
            }
        }

        // Check if the day is within the valid range for the given month
        return day >= 1 && day <= daysInMonth[month - 1];
    }
}