package interview.preperation.kit.dynamicprogramming;


/**
 * 
 * @author Manivannan
 *
 *Kadane's Algorithm is dynamic programming approach to find largest sum in contiguous sub-array  
 *
 */
public class KadanesAlgorithm {

	public int findMaximumSumSubarray(int arr[]) {
		
		int globalMax = arr[0];
		int currentMax = arr[0];
		
		for(int i=1; i<arr.length; ++i) {
			if(arr[i] > arr[i] + currentMax) {	//Check if the current element is greater than the sum of current element and the previous sub-array sum 
				currentMax = arr[i];	//start the addition from current element
			}else {
				currentMax = arr[i] + currentMax; 	//extend the maximum sum sub-array 
			}
			
			if(currentMax > globalMax) {
				globalMax = currentMax;
			}
		}
		
		return globalMax;
		
	}
	
	public static void main(String[] args) {
		
		KadanesAlgorithm kadanesAlgorithm = new KadanesAlgorithm();
		
		int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3}; //ans=7
		//int arr[] = {-2, 3, 2, -1}; //ans=5
		System.out.println(kadanesAlgorithm.findMaximumSumSubarray(arr));
	}
	
}
