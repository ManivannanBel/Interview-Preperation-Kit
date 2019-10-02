package interview.preperation.kit.dynamicprogramming;

/**
 * 
 * @author Manivannan
 * Longest Common Subsequence Problem
 * 
 * Time Complexity: O(M*N)
 */
public class LongestCommonSubsequence {

	public int LCS(String s1, String s2) {
		int T[][] = new int[s1.length() + 1][s2.length() + 1];
		
		
		for(int i = 1; i < T.length; ++i) {
			for(int j = 1; j < T[0].length; ++j) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					T[i][j] = T[i - 1][j - 1] + 1;
				}else {
					T[i][j] = Math.max(T[i - 1][j], T[i][j - 1]); 
				}
			}
		}
		
		return T[T.length - 1][T[0].length - 1];
		
	}
	
	public static void main(String args[]) {
		
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String s1 = "abcdaf";
		String s2 = "acbcf";
		
		System.out.println(lcs.LCS(s1, s2));
		
	}
	
}
