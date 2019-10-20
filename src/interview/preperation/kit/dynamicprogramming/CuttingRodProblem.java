package interview.preperation.kit.dynamicprogramming;

/**
 * 
 * @author Manivannan
 * Cutting Rod problem
 *
 */

public class CuttingRodProblem {

	public static void main(String[] args) {
		System.out.println(cuttingRod(new int[] {1, 2, 3, 4}, new int[] {2, 5, 7, 8}, 5));
		System.out.println(cuttingRod(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, new int[] {1, 5, 8, 9, 10, 17, 17, 20}, 8));
	}
	
	public static int cuttingRod(int length[], int price[], int totalLength) {
		int T[][] = new int[length.length][totalLength + 1];
		
		for(int i = 0; i < length.length; i++) {
			for(int j = 1; j < totalLength + 1; j++) {
				if(i == 0) {
					T[i][j] = T[i][j - length[i]] + price[i];
					continue;
				}
				if(j < length[i]) {
					T[i][j] = T[i - 1][j]; 
				}else {
					T[i][j] = Math.max(T[i - 1][j], T[i][j - length[i]] + price[i]); 
				}
			}
		}
		
		return T[length.length - 1][totalLength];
		
	}
	
}
