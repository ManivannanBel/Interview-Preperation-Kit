package interview.preperation.kit.misc;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMediumOfStream {
	
	public static void main(String args[]) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		float medians[] = runningMedium(arr);
		for(float a : medians) {
			System.out.print(a+", ");
		}
	}
	
	public static float[] runningMedium(int arr[]) {
		PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(
				new Comparator<Integer>() {
					public int compare(Integer a, Integer b) {
						if(a < b) {
							return 1;
						}else {
							return -1;
						}
					}
				}
		);
		PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
		float[] medians = new float[arr.length];
		for(int i = 0; i < arr.length; i++) {
			addNumber(arr[i], lowers, highers);
			balance(lowers, highers);
			medians[i] = getMedain(lowers, highers);
		}
		return medians;
	}
	
	public static void addNumber(int a, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		if(lowers.size() == 0 || a <= lowers.peek()) {
			lowers.add(a);
		}else {
			highers.add(a);
		}
	}
	
	public static void balance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		if(lowers.size() > highers.size()) {
			highers.add(lowers.poll());
		}else if(highers.size() > lowers.size()) {
			lowers.add(highers.poll());
		}
	}
	
	public static float getMedain(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		if(lowers.size() > highers.size()) {
			return lowers.peek();
		}else if(highers.size() > lowers.size()) {
			return highers.peek();
		}
		return (float)(lowers.peek() + highers.peek()) / 2;
	}
}
