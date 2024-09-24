import java.util.Random;
import java.util.Scanner;

public class RandomIntegerArray {
	
	 public static void main(String[] args) {
		 
	        int[] randomNumbersArray = new int[100];
	        Random rand = new Random();
	         boolean valid = false;
		    
	        //Fills array with random integers between 0 and 999
	        for (int i = 0; i < randomNumbersArray.length; i++) {
	        	randomNumbersArray[i] = rand.nextInt(1000);
	        }
	       
	        Scanner input = new Scanner(System.in);
	        
	    	while(!valid) {   
	    		 
	    	    try {
	    	    
	    	    	System.out.print("Enter an index between 0 and 99: ");
	    	    	String inStr = input.next();
	    	    	int index =  Integer.parseInt(inStr);
	    	    	System.out.println("\nThe value at index " + index + " is " + randomNumbersArray[index]);
	    	        valid = true;
	    	            
	    	    } catch (ArrayIndexOutOfBoundsException e) {
	    	    	
		            // Catch the exception if the index is out of bounds
		            System.out.println("Out of Bounds. Try again.\n");
		            
		        } catch (NumberFormatException e) {
		        	
		            // Catch the exception is the input is not an integer
		        	System.out.println("Invalid input. Please enter a valid Integer\n");
		        }
	    	}
	    	    
	        input.close();
	    	
	 }
}