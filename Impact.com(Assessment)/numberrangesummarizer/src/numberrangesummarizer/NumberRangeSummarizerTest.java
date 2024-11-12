package numberrangesummarizer;
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberRangeSummarizerTest {
	//This module test the collect method on the interface to make it returns a sorted list.
	@Test
	void testCase1() {
		DemoNumberRangeSummarizer inputCollector = new DemoNumberRangeSummarizer();
		Collection<Integer> results = inputCollector.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
		assertEquals(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31), results);
	}
	//checks if it still returns correct output even if there are duplicates in the list.
	@Test
		void testCollectWithDuplicates() {
			String input = "1,3,3,5,7,9";
			DemoNumberRangeSummarizer inputCollector = new DemoNumberRangeSummarizer();
			Collection<Integer> results = inputCollector.collect("1,3,3,5,7,9");
			assertEquals(Arrays.asList(1, 3, 3, 5, 7, 9), results);
		}
	//This module test the summarizeCollection	 method on the interface.
	@Test
	void testCase2() {
		DemoNumberRangeSummarizer inputCollector = new DemoNumberRangeSummarizer();
		Collection<Integer> results = inputCollector.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
		String summerizedRange = inputCollector.summarizeCollection(results);
		assertEquals("1, 3, 6 - 8, 12 - 15, 21 - 24, 31", summerizedRange);
		}
	//checks for invalid input, expected to throw an error
	@Test
		void testEmptyInput() {
			DemoNumberRangeSummarizer inputCollector = new DemoNumberRangeSummarizer();
			Collection<Integer> results = inputCollector.collect("");
			String summerizedRange = inputCollector.summarizeCollection(results);
			assertEquals("", summerizedRange);
		}
	
	

}
