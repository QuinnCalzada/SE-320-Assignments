import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Assignment4_Problem2 {
	
	 public static void main(String[] args) {
	        // Creates a tree set called namesSet
	        TreeSet<String> namesSet = new TreeSet<>();
	   
	        try {
	        	File file = new File("src/input.txt"); // Might need adjusting on your computer, sorry
	            Scanner scanner = new Scanner(file);

	            // Read words from the file and adds them to the TreeSet
	            while (scanner.hasNext()) {
	                String inputName = scanner.next();
	                namesSet.add(inputName);
	            }

	            scanner.close();

	            // Displays the tree set
	            System.out.println("Nonduplicate words in ascending order: " + namesSet);

	        } catch (FileNotFoundException e) {
	            System.out.println("File not found.");
	        }
	    }
	

}
