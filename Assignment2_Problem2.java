import java.util.ArrayList;
import java.util.HashSet;

public class Assignment2_Problem2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(14);
        list.add(24);
        list.add(14);
        list.add(42);
        list.add(25);

        // Call removeDuplicates method
        ArrayList<Integer> newList = removeDuplicates(list);
        System.out.print(newList);
    }

    // Method to remove duplicates from the original list
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        // Use a HashSet to store unique elements
        HashSet<E> set = new HashSet<>(list);
        
        // Return a new ArrayList with unique elements
        return new ArrayList<>(set);
    }
}
