package interview.preperation.kit.dynamicprogramming;

import java.util.Arrays;

/**
 * 
 * @author Manivannan
 *
 * Given a total value, we have infinite supply of each coin of set S, 
 * we have to minimum number of coins that sum up to the given total value
 *
 */

public class CoinChangingProblemMinNoOfCoins {

	public static void main(String[] args) {
		
		//System.out.println(findMininumNumberOfCoins(new int[] {25, 10, 5}, 30));
		System.out.println(findMininumNumberOfCoins(new int[] {1, 5, 6, 8}, 11));
	}
	
	public static int findMininumNumberOfCoins(int arr[], int total) {
		
		int T[] = new int[total + 1]; // To store no of coins
		int R[] = new int[total + 1]; // To track the coin combination
		
		Arrays.fill(T, Integer.MAX_VALUE - 1);
		T[0] = 0;
		Arrays.fill(R, -1);
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 1; j < total + 1; j++) {
				if(j >= arr[i]) {
					if(T[j - arr[i]] + 1 < T[j]) {
						T[j] = T[j - arr[i]] + 1;
						R[j] = i; 
					}
				}
			}
		}
		
		/*for(int i = 0; i< total+1; i++) {
			System.out.print(T[i]+" ");
		}
		System.out.println();
		for(int i = 0; i< total+1; i++) {
			System.out.print(R[i]+" ");
		}*/
		//Print combination of coins
		printCombination(R, arr);
		//No of coins
		return T[total];		
	}
	
	public static void printCombination(int R[], int arr[]) {
		System.out.println();
		for(int i = R.length - 1; i > 0;) {
			int coin = arr[R[i]];
			System.out.print(coin +" ");
			i = i - coin;
		}
		System.out.println();
	}
	
}
