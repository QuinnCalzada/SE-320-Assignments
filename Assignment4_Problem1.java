import java.util.LinkedHashSet;

public class Assignment4_Problem1 {
     
	 public static void main(String[] args) {
		
	     LinkedHashSet<String> set1 = new LinkedHashSet<>();
	     LinkedHashSet<String> set2 = new LinkedHashSet<>();

	     // Set 1 data
	     set1.add("George");
	     set1.add("Jim");
	     set1.add("John");
	     set1.add("Blake");
	     set1.add("Kevin");
	     set1.add("Michael");

	    // Set 2 data
	     set2.add("George");
	     set2.add("Katie");
	     set2.add("Kevin");
	     set2.add("Michelle");
	     set2.add("Ryan");

	     // Union
	     LinkedHashSet<String> union = new LinkedHashSet<>(set1);
	     union.addAll(set2);
	     System.out.println("Union       : " + union);

	     // Difference
	     LinkedHashSet<String> difference = new LinkedHashSet<>(set1);
	     difference.removeAll(set2);
	     System.out.println("Difference  : " + difference);

	     // Intersection
	     LinkedHashSet<String> intersection = new LinkedHashSet<>(set1);
	     intersection.retainAll(set2);
	     System.out.println("Intersection: " + intersection);
	    }
}
