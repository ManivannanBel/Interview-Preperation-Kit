package interview.preperation.kit.array;

/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0 
 */

//Time Complexity O(Log(n)) 
public class FindInsertPosition {

	public static void main(String args[]) {
		//Edge case 1: [1], target = 1
		//Edge case 2: [1, 3], target = 2
		int nums[] = {1,3,5,6};
		int insertPosition = searchInsert(nums, 2);
		System.out.println(insertPosition);
	}
	
	public static int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        
        int left = 0, right = nums.length - 1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            //Edge cases
            if(mid == 0 && target <= nums[mid]){
                return mid;
            //Edge cases
            }else if(mid == nums.length - 1 && target > nums[mid]){
                return mid + 1;
            }
            if(mid != 0 && nums[mid - 1] < target && target <= nums[mid]){
                return mid;
            }
            
            if(target < nums[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return 0;
    }
}
