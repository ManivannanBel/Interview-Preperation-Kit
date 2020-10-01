package interview.preperation.kit.dynamicprogramming;

public class ClimbingStairs {
	public static void main(String args[]) {
		//Bottom up approach
		System.out.println(climbingStairsTopDown(15));	//987
		System.out.println(climbingStairsBottomUp(15));
	}
	
	public static int climbingStairsTopDown(int n) {
		int cache[] = new int[n + 1];
		return climbingStairsTopDown(n, cache);
	}
	
	//Top Down
	public static int climbingStairsTopDown(int n, int[] cache) {
		if(n <= 1) return 1;
		if(cache[n] == 0) {
			cache[n] = climbingStairsTopDown(n - 1, cache) + climbingStairsTopDown(n - 2, cache);
		}
		return cache[n];
	}
	
	//Bottom Up
	public static int climbingStairsBottomUp(int n) {
		if(n <= 1) return 1;
		int dp[] = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
