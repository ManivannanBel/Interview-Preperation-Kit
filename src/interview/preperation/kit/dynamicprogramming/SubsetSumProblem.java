package interview.preperation.kit.dynamicprogramming;

import interview.preperation.kit.string.StringPermutation;

/**
 * 
 * @author Manivannan
 * Given a set of non negative integers and a total value.
 * Determine if there is subset whose sum is equals to the given total value 
 */

public class SubsetSumProblem {

	public static void main(String[] arg) {
		int arr[] = {3, 34, 4, 12, 5, 2};
		System.out.println(findSubsetSum(arr, 9));
		System.out.println(findSubsetSum(new int[] {2, 3, 5, 4, 7}, 30));
	}
	
	public static boolean findSubsetSum(int arr[], int total) {
		
		boolean T[][] = new boolean[arr.length][total + 1];
		
	
		for(int i=1; i < total+1; i++) {
			if(arr[0] == i)
				T[0][i] = true;
			else
				T[0][i] = false; 
		}
		
		for(int i = 1; i < arr.length ; i++) {
			for(int j = 0; j < total+1 ; j++) {
				if(j==0) {
					T[i][j] = true;
					continue;
				}
				if(arr[i] > j) {
					T[i][j] = T[i - 1][j]; 
				}else {
					T[i][j] = T[i - 1][j] || T[i - 1][j - arr[i]];  
				}
			}
		}
		
		return T[arr.length - 1][total];
		
	}
	
}
