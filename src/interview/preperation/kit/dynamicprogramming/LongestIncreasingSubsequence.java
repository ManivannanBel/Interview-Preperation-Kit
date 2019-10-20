package interview.preperation.kit.dynamicprogramming;

import java.util.Arrays;

/**
 * 
 * @author Manivannan
 * Longest Increasing subsequence
 */

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		System.out.println(longestIncreasingSubsequence(new int[] {3, 4, -1, 0, 6, 2, 3}));
		System.out.println(longestIncreasingSubsequence(new int[] {3, 10, 2, 1, 20}));
		System.out.println(longestIncreasingSubsequence(new int[] {3, 2}));
		System.out.println(longestIncreasingSubsequence(new int[] {50, 3, 10, 7, 40, 80}));
	}
	
	public static int longestIncreasingSubsequence(int arr[]) {
		
		int T[] = new int[arr.length];
		Arrays.fill(T, 1);
		int i = 0, j = 1;
		while(j < arr.length) {
			for(i = 0; i < j; i++) {
				if(arr[i] < arr[j]) {
					if(T[i] + 1 > T[j])
						T[j] = T[i] + 1;
				}
			}
			j++;
		}
		
		/*for( i=0; i< arr.length; i++) {
			System.out.print(T[i]+" ");
		}*/
		return T[arr.length - 1];
	}
	
}
