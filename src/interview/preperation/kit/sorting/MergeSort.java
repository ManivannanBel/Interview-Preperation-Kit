package interview.preperation.kit.sorting;

public class MergeSort {
	public static void main(String[] args) {
		int arr[] = {6,5,8,9,3,10,15,12,16};
		divide(arr, 0, arr.length - 1);
		for(int a : arr) {
			System.out.print(a+" ");
		}
	}
	
	public static void divide(int arr[], int low, int high) {
		if(low < high) {
			int mid = (low + high) / 2;
			divide(arr, low, mid);
			divide(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}
	
	public static void merge(int arr[], int low, int mid, int high) {
		int left = low;
		int rightStart = mid + 1;
		int temp[] = new int[high - low + 1];
		int k = 0;
		while(left <= mid && rightStart <= high) {
			if(arr[left] < arr[rightStart]) {
				temp[k++] = arr[left++];
			}else {
				temp[k++] = arr[rightStart++];
			}
		}
		
		while(left <= mid) {
			temp[k++] = arr[left++];
		}
		
		while(rightStart <= high) {
			temp[k++] = arr[rightStart++];
		}
		
		k = 0;
		while(k < temp.length) {
			arr[k + low] = temp[k++];
		}
	}
}
