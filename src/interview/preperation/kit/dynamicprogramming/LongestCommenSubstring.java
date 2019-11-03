package interview.preperation.kit.dynamicprogramming;

public class LongestCommenSubstring {

	public static void main(String args[]) {
		System.out.println(longestCommonSubstring("zbcdf", "abcdef"));
		System.out.println(longestCommonSubstring("abcdxyz", "xyzabcd"));
		System.out.println(longestCommonSubstring("zxabcdezy", "yzabcdezx"));
	}
	
	public static int longestCommonSubstring(String s1, String s2) {
		
		int T[][] = new int[s1.length() + 1][s2.length() + 1];
		int max = 0;
		
		for(int i = 1; i < s1.length() + 1; i++) {
			for(int j = 1; j < s2.length() + 1; j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					T[i][j] = T[i - 1][j - 1] + 1; 
					if(T[i][j] > max) {
						max = T[i][j];
					}
				}
			}
		}
			
		
		return max;
		
	}
	
}
