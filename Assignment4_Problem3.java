import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Assignment4_Problem3 {
	
	public static void main(String[] args) {
        double number = 12345.678;
        String numberString = "12,345.678";
        
        // a. Format  12345.678 in the United Kingdom locale
        NumberFormat ukFormat = NumberFormat.getNumberInstance(Locale.UK);
        ukFormat.setMaximumFractionDigits(2); // Set to 2 decimal places
        System.out.println("UK format: " + ukFormat.format(number));
        
        // b. format 12345.678 in U.S. currency
        NumberFormat usCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("U.S. Currency format: " + usCurrencyFormat.format(number));
        
        // c. Parse 12,345.678 into a number
        try {
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
            Number parsedNumber = numberFormat.parse(numberString);
            System.out.println("Parsed number: " + parsedNumber);
            
        } catch (ParseException e) {
        	System.out.println(e);
        }
    }

}
