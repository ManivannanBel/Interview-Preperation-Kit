package interview.preperation.kit.sorting;

public class QuickSort {
	public static void main(String[] args) {
//		int arr[] = {10, 80, 30, 90, 40, 50, 70};
		int arr[] = {6,5,8,9,3,10,15,12,16};
		quickSort(arr, 0, arr.length);
		for(int a : arr) {
			System.out.print(a+" ");
		}
	}
	
	public static int partition(int arr[], int low, int high) {
		int pivot = low;
		int i = low;
		int j = high;
		
		while(i < j) {
			do {
				i++;
			}while(i < arr.length && arr[i] <= arr[pivot]);
			do {
				j--;
			}while(arr[j] > arr[pivot]);
			if(i < j)
				swap(arr, i, j);
		}
		swap(arr, pivot, j);
		return j;
	}
	
	public static void quickSort(int arr[], int low, int high) {
		if(low < high) {
			int p = partition(arr, low, high);
			quickSort(arr, low, p);
			quickSort(arr, p + 1, high);
		}
	}
	
	public static void swap(int arr[], int pos1, int pos2) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
}
