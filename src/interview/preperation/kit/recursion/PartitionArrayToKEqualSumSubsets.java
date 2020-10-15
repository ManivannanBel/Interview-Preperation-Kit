package interview.preperation.kit.recursion;

/*
Given an array of integers nums and a positive integer k, 
find whether it's possible to divide this array into k non-empty 
subsets whose sums are all equal.

Example 1:

Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) 
with equal sums.
*/

import java.util.Set;
import java.util.HashSet;;

public class PartitionArrayToKEqualSumSubsets {

	public static void main(String args[]) {
		int nums[] = {4, 3, 2, 3, 5, 2, 1};
		System.out.println(canPartitionKSubsets(nums, 4));
		int nums2[] = {10,10,10,7,7,7,7,7,7,6,6,6};
		System.out.println(canPartitionKSubsets(nums2, 3));
	}
	
	public static boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for(int i = 0; i < nums.length; i++){
            total += nums[i];
        }
        if(k == 0 || total % k != 0){
            return false;
        }
        if(k == 0 || total % k != 0){
            return false;   
        }
        int bucketTotal = total / k;
        return kPartitions(nums, 0, new HashSet<Integer>(), 0, bucketTotal, k);
    }
    
    public static boolean kPartitions(int nums[], int index, Set<Integer> selected, int curSum, int bucketTotal, int k){
        if(k == 1){
            return true;
        }
        if(curSum == bucketTotal){
            return kPartitions(nums, 0, selected, 0, bucketTotal, k - 1);
        }
        for(int i = index; i < nums.length; i++){
            if(selected.contains(i)) continue;
            selected.add(i);
            if(kPartitions(nums, i + 1, selected, curSum + nums[i], bucketTotal, k)){
                return true;
            }
            selected.remove(i);
        }
        return false;
    }
}
