package interview.preperation.kit.dynamicprogramming;

/**
 * 
 * @author Manivannan
 * 0/1 Knapsack problem - Given items of certain weights/values and maximum allowed weight
 * how to pick items to pick items from this set to maximize sum of value of items such that
 * sum of weights is less than or equal to maximum allowed weight.
 * 
 * Time Complexity: O(no of items * total weight)
 */
public class KnapsackProblem {

	public int bottomUp(int weight[], int value[], int totalWeight) {
		int T[][] = new int[weight.length + 1][totalWeight + 1];
		
		int row = 1, column = 1;
		for(row = 1; row < T.length; ++row) {
			for(column = 1; column <= totalWeight; ++column) {
				/*
				 * if current maximum weight is less than weight of the respective object then select T[i - 1][j] (Top element);
				 * else select Max((V[i] + T[i - 1][j - W[i]]), T[i - 1][j] (Maximum of sum of current weight and T[i -1][j - current weight] or Top element)
				 * i.e in else statement, including current element or without including current element.
				 */
				if(column < weight[row - 1]) {
					T[row][column] = T[row - 1][column];
				}else {
					T[row][column] = Math.max(value[row - 1] + T[row - 1][column - weight[row - 1]], T[row - 1][column]);
				}
			}
		}
		
		return T[row - 1][column - 1];
	}
	
	public static void main(String[] arg) {
		
		KnapsackProblem knapsack = new KnapsackProblem();
		
		int val[] = {1, 4, 5, 7};
		int wt[] = {1, 3, 4, 5};
		int total = 7;
		
		System.out.println(knapsack.bottomUp(wt, val, total));
		
		val = new int[] {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        wt = new int[] {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
        System.out.println(knapsack.bottomUp(wt, val, 30));
        
	}
	
}
