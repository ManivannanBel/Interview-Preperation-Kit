package interview.preperation.kit.array;

/*
Say you have an array prices for which the ith element is the price of a given
 stock on day i.

Design an algorithm to find the maximum profit. You may complete as 
many transactions as you like (i.e., buy one and sell one share of the 
stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you 
must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, 
             as you are
             engaging multiple transactions at the same time. You must sell 
             before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuySellStock2 {
	public static void main(String[] args) {
		int arr1[] = new int[] {7,1,5,3,6,4};	//out = 7
		System.out.println(maxProfit(arr1));
		int arr2[] = new int[] {1,2,3,4,5};		//out = 4
		System.out.println(maxProfit(arr2));
	}
	
	// run time O(n), space complexity (1)
	public static int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int leftMin = prices[0];
        int totalProfit = 0;
        int len = prices.length;
        int i;
        for(i = 1; i < len; i++){
            if(prices[i] < prices[i - 1]){
                int curMax = prices[i - 1] - leftMin;
                totalProfit += curMax;
                leftMin = prices[i];
            }
            if(prices[i] < leftMin){
                leftMin = prices[i];
            }
        }
        if(leftMin < prices[i -1]){
            totalProfit += prices[i - 1] - leftMin;
        }
        return totalProfit;
    }
}
