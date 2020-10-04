package interview.preperation.kit.array;

/*
Given a non-empty array of integers nums, every element appears twice except 
for one. Find that single one.

Follow up: Could you implement a solution with a linear runtime complexity 
and without using extra memory?


Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
 */

public class SingleNumber {
	
	public static void main(String[] args) {
		int nums[] = new int[] {1,1,2,3,5,2,5,3,6}; //OUT = 6
		System.out.println(singleNumber(nums));
	}
	
	//Run time complexity O(n), Space complexity O(1)
	public static int singleNumber(int[] nums) {
        int singleNumber = nums[0];
        for(int i = 1; i < nums.length; i++){
            singleNumber ^= nums[i];
        }
        return singleNumber;
    }
}
