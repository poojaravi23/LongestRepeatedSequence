/*Pooja Ravi
 *1001578517
 *Longest Repeated Subsequence using Recursion without memoization
*/
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatedSubsequenceRecursion {
	public static Map<Integer,Character> index=new HashMap<Integer,Character>();
	public static Map<Integer,Integer>coveredcombos=new HashMap<Integer,Integer>();
	public static String repeated_sequence="";
	 public static int LRSLength(String user_input, int index_1, int index_2)
	    {
	        // return if we have reached the end of either string
	        if (index_1 == 0 || index_2 == 0) {
	            return 0;
	        }

	        // if characters matches and index is different
	        if (user_input.charAt(index_1 - 1) == user_input.charAt(index_2 - 1) && index_1 != index_2) {
	        
            //if the index is already been checked then the characters are not added to the repeated sequence
	        	if(coveredcombos.containsKey(index_1-1)||coveredcombos.containsValue(index_1-1)) {	        		
	    		     coveredcombos.put(index_1-1, index_2-1);

	        	}
	        	else {
	        		coveredcombos.put(index_1-1, index_2-1);
        			index.put(index_1-1, user_input.charAt(index_1-1));

	        	}
	        	

	            return LRSLength(user_input, index_1 - 1, index_2 - 1) + 1;
	        }
	        // else if characters at indices don't match
	        return Integer.max(LRSLength(user_input, index_1, index_2 - 1),
	                LRSLength(user_input, index_1 - 1, index_2));
	    }

	    // main function
	    public static void main(String[] args)
	    {
	    	String user_input = args[0];
	    	if(user_input.isEmpty()) {
				System.out.println("invalid input"); //when the input string is empty,throws an error
				}
	    	
	        int string_length = user_input.length(); //command line input
	        long start_time = System.nanoTime();
	        System.out.println("Length of Longest Repeating Subsequence is " +
	                LRSLength(user_input, string_length, string_length));
	        for (Integer i: index.keySet()){
	        	repeated_sequence+=index.get(i);
	        	
	        }
	        long end_time = System.nanoTime();
	        
	        System.out.println(repeated_sequence);
	        if(repeated_sequence.isEmpty()) { //when there is no common subsequence
	        	System.out.println("No common Subsequence found");
	        	 
	        }
	        System.out.println("\nExecution Time: "+(end_time-start_time)+ " nanoseconds");//execution time in nano seconds
	    }
}
