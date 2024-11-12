package numberrangesummarizer;
import java.util.Collection;
import java.util.List;

public class Main {
	
	public static void main(String[] args)
	    {
	        //Testing the NumberRangeSummarizer with basic input to test functionality
			DemoNumberRangeSummarizer nr = new DemoNumberRangeSummarizer();
	        String input = "1,3,3,5,7,9";
	        try {
	            Collection<Integer> collectionInput = (List<Integer>)nr.collect(input);
	            String range = nr.summarizeCollection(collectionInput);

	            System.out.println(range);
	        } catch (ClassCastException exc) {
	            System.out.println("Please review the string there might be a character");
	        }
	    

	}

}
