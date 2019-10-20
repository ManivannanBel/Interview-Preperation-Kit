package interview.preperation.kit.dynamicprogramming;

/**
 * 
 * @author Manivannan
 *
 * Given two string, you can perform delete, modify or add character to convert one string to another.
 * Find the minimum number of edits needed to convert one string to another
 *
 */

public class MinimumEditDistance {

	public static void main(String[] args) {
		System.out.println(getMinimumEditDistance("abcdef", "azced"));
		System.out.println(getMinimumEditDistance("un", "atur"));
		System.out.println(getMinimumEditDistance("cat", "cut"));
		System.out.println(getMinimumEditDistance("sunday", "saturday"));
	}
	
	public static int getMinimumEditDistance(String str1, String str2) {
		
		int T[][] = new int[str1.length() + 1][str2.length() + 1];
		
		for(int i = 0; i < str1.length() + 1; i++) {
			for(int j = 0; j < str2.length() + 1; j++) {
				if(i==0) {
					T[i][j] = j;
					continue;
				}
				if(j==0) {
					T[i][j] = i;
					continue;
				}
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					T[i][j] = T[i - 1][j - 1]; 
				}else {
					T[i][j] = Math.min(T[i - 1][j - 1], Math.min(T[i - 1][j], T[i][j - 1])) + 1; 
				}
			}
		}
		
		return T[str1.length()][str2.length()];
		
	}
	
}
