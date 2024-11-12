package numberrangesummarizer;

import java.util.*;

public class DemoNumberRangeSummarizer implements NumberRangeSummarizer{

    public Collection<Integer> collect(String input){
        //convert String input into an array of strings
        String[] string = input.split(",");

        //Convert an array of Strings into a list of Integers
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < string.length; i++){
            numbers.add(Integer.valueOf(string[i]));
        }

        //return a list of integers
       
        Collections.sort(numbers);
        return numbers;
    }  
    
    public String summarizeCollection(Collection<Integer> input)
    {
        
        //to store small sequences in a String Buffer
        StringBuffer sb = new StringBuffer();


        //create collection object to collect the input of integers
        ArrayList<Integer> inputItems = new ArrayList<Integer>(input);
        int length = inputItems.size();
        int counter = 0;
        int first;
        int second;
        
        //Loop through the items in the list.
        for (int i = 0; i < length; i++)
        {
            // check if i is the last index then append the last value on the String buffer.
            if (i == length - 1)
            {
                if(inputItems.get(length-2) != inputItems.get(length-1))
                {
                    sb.append(inputItems.get(i) + ",");
                }
                break;
            }
        //  start at the first item on the List and checking for a sequence
            first = (Integer)inputItems.get(i);

            second = (Integer)inputItems.get(i + 1);
            if (second == first + 1)
            {
                counter++;
                int lowestBound = first;

                for (int j = i + 1; ; j++)
                {
                    first = (Integer)inputItems.get(j);
                    second = (Integer)inputItems.get(j + 1);

                    if (second == first + 1)
                    {
                        counter++;
                    }
                    else
                    {
                        i = j;
                        if (counter != 0)
                        {
                            sb.append(lowestBound + " - " + (Integer)inputItems.get(j) + ", ");
                        }
                        break;
                    }
                }
                counter = 0;
            }
            else
            {
            	//elements not in a sequence
                sb.append(first + ", ");
            }
        }
        //combine ranges into a single String
        String ranges = sb.toString();
        return ranges.substring(0, ranges.length() - 1);
    }
	
   
}