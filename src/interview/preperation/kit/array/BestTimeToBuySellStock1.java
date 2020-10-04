package interview.preperation.kit.array;

/*
Say you have an array for which the ith element is the price of a given stock on 
day i.

If you were only permitted to complete at most one transaction (i.e., buy one
 and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6),
 			 profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuySellStock1 {
	public static void main(String[] args) {
		int arr1[] = new int[] {7,1,5,3,6,4};	//out = 5
		System.out.println(maxProfit(arr1));
		int arr2[] = new int[] {7,6,4,3,1};		//out = 0
		System.out.println(maxProfit(arr2));
		int arr3[] = new int[] {2,1,4};			//out = 3
		System.out.println(maxProfit(arr3));
	}
	
	//time complexity O(n), space complexity )(1)
	public static int maxProfitEff(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int leftMin = Integer.MAX_VALUE;
        int max = 0;
        int len = prices.length;
        for(int i = 0; i < len; i++){
            if(prices[i] < leftMin){
                leftMin = prices[i];
            }else{
                int curMax = prices[i] - leftMin;
                if(curMax > max){
                    max = curMax;
                }
            }        
        }
        return max;
    }
	
	//time complexity O(n), space complexity )(n)
	public static int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int max = 0;
        int len = prices.length;
        int rightMax[] = new int[len];
        rightMax[len - 1] = prices[len - 1];
        for(int i = len - 2; i >= 0; i--){
            if(prices[i] > rightMax[i + 1]){
                rightMax[i] = prices[i];
            }else{
                rightMax[i] = rightMax[i + 1];
            }
        }
        for(int i = 0; i < len; i++){
            if(prices[i] < rightMax[i]){
                int curMax = rightMax[i] - prices[i];
                if(curMax > max){
                    max = curMax;
                }
            }
        }
        return max;
    }

}
