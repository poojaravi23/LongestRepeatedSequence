/*Pooja Ravi
 *1001578517
 *Longest Repeated Subsequence using Dynamic Programming
*/
public class LongestRepeatedSubsequenceDynamic {
	
	public static String user_input ="";
	public static String repeated_subsequence="";
	
	public static void findLongestRepeatedSubsequence() {
		//create a DP table
		int LRS_table[][]=new int[user_input.length()+1][user_input.length()+1];
	    //
		for(int i=0;i<LRS_table.length;i++) 
			LRS_table[i][0]=0;
		for(int j=0;j<LRS_table.length;j++) 
			LRS_table[0][j]=0;
		for(int i=1;i<LRS_table.length;i++) {//first row and first column of the lookup table
			for(int j=1;j<LRS_table.length;j++) {
		//characters match and different indices
				if(user_input.charAt(i-1)==user_input.charAt(j-1)&&i!=j) 
					LRS_table[i][j]=1+LRS_table[i-1][j-1];
				else//Characters don't match
					LRS_table[i][j] = Math.max(LRS_table[i][j-1],LRS_table[i-1][j]);
			}
		}
		genratesubsequence(user_input.length(), LRS_table);
		
	}
	/*finding the subsequence when DP table is filled*/
	public static void genratesubsequence(int length,int LRS_table[][]) {
		int i=length;
		int j=length;
		while(i>0 && j>0) {
			/*same characters are present if the current cell is same as diagonally adjacent above cell*/ 
			if(LRS_table[i][j] == LRS_table[i-1][j-1] +1 ) {
				repeated_subsequence+=user_input.charAt(i-1);
				i-=1;
				j-=1;
			}
			/* if not same, to obtain the maximum result, move to the side*/
			else if(LRS_table[i][j] == LRS_table[i-1][j]) {
				i -=1;
			}
			else
				j -=1;
			
		}
	}
	/*Throws an error when we leave argument blank that is zero input string*/
	public static void main(String[] args)
    {
		user_input=args[0];
		if(user_input.isEmpty()) {
			System.out.println("invalid input");
		}
		long start_time = System.nanoTime();
        findLongestRepeatedSubsequence();
        long end_time = System.nanoTime();
        if(repeated_subsequence.isEmpty()) { //when there is no common subsequence
        	System.out.println("No common Subsequence found");
        }
        StringBuffer subsequence = new StringBuffer(repeated_subsequence);
        System.out.println(subsequence.reverse());
        System.out.println("\nExecution Time: "+(end_time-start_time)+ " nanoseconds");//execution time in nano seconds
    }
	
}
