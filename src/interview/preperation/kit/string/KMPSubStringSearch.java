package interview.preperation.kit.string;

/**
 * 
 * @author Manivannan
 *
 *Knuth-Morris-Pratt Algorithm is the efficient pattern matching algorithm used for substring matching
 *
 *Time Complexity: O(m + n) , m is length of the string, n is the length of the substring
 *Space Complexity: O(n) , for temp array
 */

public class KMPSubStringSearch {
	
	public int[] computeTempArray(String pattern) {
		int i=1,j=0;
		int arr[] = new int[pattern.length()];
		arr[0] = 0;
		while (i < pattern.length()) {
			if(pattern.charAt(j) == pattern.charAt(i)) {
				arr[i] = j + 1;
				j++;
				i++;
			}else {
				if(j == 0) {
					arr[i] =0; 
				}else {
					arr[i] = arr[j - 1]; 
				}
				i++;
			}
		}
		return arr;
	}
	
	public boolean KMPSearch(String str, String pattern) {
		
		int arr[] = computeTempArray(pattern);
		int i = 0, j = 0;
		
		while(i < str.length() && j < pattern.length()) {
			
			if(str.charAt(i) == pattern.charAt(j)) {
				i++; 
				j++;
			}else {
				if(j!=0) {	
					j = arr[j - 1];
				}
				else {
					i++;
				}
			}
			
		}
		
		if(j == pattern.length())
			return true;
		return false;
	}
	
	public static void main(String[] arg) {
		
		String str = "abcxabcdabcdabcy";
		String subString = "abcdabcy";
		KMPSubStringSearch kmpSubStringSearch = new KMPSubStringSearch();
		System.out.println("String: "+str+"\nSunstring: "+subString);
		System.out.println(kmpSubStringSearch.KMPSearch(str, subString));
		
	}
	
}
