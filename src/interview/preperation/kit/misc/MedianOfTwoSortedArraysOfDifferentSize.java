package interview.preperation.kit.misc;


public class MedianOfTwoSortedArraysOfDifferentSize {
	//if arr1 length is greater, then swith their positions
	public double findMedian(int arr1[], int arr2[]) {
		
		if(arr1.length > arr2.length) {
			return findMedian(arr2, arr1);
		}
		
		int x = arr1.length;
		int y = arr2.length;
		
		int low = 0;
		int high = x;
		
		while(low <= high) {
			int partitionX = (low + high)/2;
			int partitionY = (x + y + 1)/2 - partitionX;
			
			//if partitionX is 0 then there is no more element left on the left side, so assign -INFINITY to maxLeftX
			int maxLeftX = (partitionX == 0)? Integer.MIN_VALUE : arr1[partitionX - 1];
			//if partitionX is x then there is no more element left on the right side, so assign INFINITY to minRightX
			int minRightX = (partitionX == x)? Integer.MAX_VALUE : arr1[partitionX];
			
			//if partitionY is 0 then there is no more element left on the left side, so assign -INFINITY to maxLeftY
			int maxLeftY = (partitionY == 0)? Integer.MIN_VALUE : arr2[partitionY - 1];
			//if partitionY is y then there is no more element left on the right side, so assign INFINITY to minRightY
			int minRightY = (partitionY == y)? Integer.MAX_VALUE : arr2[partitionY];
			
			if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
				
				if((x+y)%2 == 0) {
					return ((double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2);
				}else {
					return Math.max(maxLeftX, maxLeftY);
				}
			}else if(maxLeftX > minRightY) {
				high = partitionX - 1;
			}else {
				low = partitionX + 1;
			}
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		int arr1[] = new int[] {1, 3, 8, 9, 15};
		int arr2[] = new int[] {7, 11, 18, 19, 21, 25};
		
		System.out.print(new MedianOfTwoSortedArraysOfDifferentSize().findMedian(arr1, arr2));
	}
	
}
