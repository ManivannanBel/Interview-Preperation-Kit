package interview.preperation.kit.dynamicprogramming;

public class LongestPalindromicSubsequence {

	public int LPSBottomUp(String str) {
		int T[][] = new int[str.length()][str.length()];
		
		for(int i = 0; i < str.length(); ++i) {
			T[i][i] = 1;
		}
		
		for(int k = 1; k < str.length(); ++k) {
			for(int i = 0; i < str.length() - k; ++i) {
				int j = k + i;
				
				if(str.charAt(i) == str.charAt(j)) {
					T[i][j] = T[i + 1][j - 1] + 2; 
				}else {
					T[i][j] = Math.max(T[i][j - 1], T[i + 1][j]); 
				}
			}
		}

		//To print the actual substring
		int i = 0, j = str.length() - 1;
		StringBuffer s1 = new StringBuffer();
		StringBuffer s2 = new StringBuffer();
		while(i <= j) {
			if(T[i][j] > T[i + 1][j] && T[i][j] > T[i][j - 1]) {
				
				if(i==j) {
					s1.append(str.charAt(i));
					i++;
					j--;
					continue;
				}
				s1.append(str.charAt(i));
				s2.append(str.charAt(j));
				i++;
				j--;
			}else{
				i++;
			}
		}
		//print the substring
		System.out.println(s1.toString()+s2.reverse());
		
		return T[0][str.length() - 1];
		
	}
	
	public static void main(String[] args) {
		String string = "BBABCBCAB";
		//String string = "agbdba";
		System.out.print(new LongestPalindromicSubsequence().LPSBottomUp(string));
	}
	
}
