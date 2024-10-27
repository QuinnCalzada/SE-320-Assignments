import java.util.Scanner;

public class SumTwoIntegers {

	public static void main(String [] args) {

	int sum = 0;
	int integerCount = 2;
	boolean valid = false;
	    
    Scanner input = new Scanner(System.in);
    
	 while(!valid) {   
		 
	    try {
	    
	    	for(int i = 0; i < integerCount; i++) {
	            System.out.print("Enter an integer " + (i + 1) + ": ");
	    		String inStr = input.next();
		        sum += Integer.parseInt(inStr); //convert to int, or throw exception if not an int.
	    	}
	            
	        valid = true;
	            
	    } catch (NumberFormatException e) {
	    	
	    	// Catch the exception is the input is not an integer
	    	System.out.println("Invalid input. Please enter a valid Integer\n");
	        sum = 0;    
	        
	    }
	 }
	 
	 input.close();
     System.out.println("\nThe sum of the integers is: " + sum);
    
	}
}
