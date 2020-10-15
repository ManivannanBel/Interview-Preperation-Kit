package interview.preperation.kit.dynamicprogramming;

/*
Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
*/

import java.util.*;

public class PartitionArrayToTwoEqualSumSubsets {

	public static void main(String args[]) {
		
		int nums[] = {1,5,11,5}; 	//true
		System.out.println(canPartition(nums));
		int nums2[] = {2,2,3,5};	//false
		System.out.println(canPartition(nums2));
	}
	
	public static boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 1) return false;
        int total = 0;
        for(int a : nums){
            total += a;
        }
        if(total % 2 != 0) return false;
        return equalPartition(nums, 0, 0, total, new HashMap<String, Boolean>());
        
    }
    
    public static boolean equalPartition(int nums[], int index, int curSum, int total, HashMap<String, Boolean> cache){
        String key = index + "_" + curSum;
        if(cache.containsKey(key)){ 
            return cache.get(key);
        }
        if(curSum * 2 == total) return true;
        if(curSum > total / 2 || index >= nums.length) return false;
        boolean res = equalPartition(nums, index + 1, curSum + nums[index], total, cache) ||
               equalPartition(nums, index + 1, curSum, total, cache);
        cache.put(key, res);
        return res;
    }
}
