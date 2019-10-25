package interview.preperation.kit.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

class Job{
	int startTime;
	int finishTime;
	int weight;
	public Job(int startTime, int finishTime, int weight) {
		super();
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.weight = weight;
	}
}

public class WeightedJobSchedulingMaximumProfit {

	public static void main(String[] args) {
		//System.out.println(maximumProfit(new int[] {}, new int[] {}, new int[] {}));
		System.out.println(maximumProfit(new int[] {1, 2, 4, 6, 5, 7}, new int[] {3, 5, 6, 7, 8, 9}, new int[] {5, 6, 5, 4, 11, 2}));
	}
	
	public static int maximumProfit(int[] startTime, int[] endTime, int weight[]) {
		Job jobs[] = new Job[startTime.length];
		
		for(int i = 0; i < startTime.length; i++) {
			jobs[i] = new Job(startTime[i], endTime[i], weight[i]); 
		}
		
		Arrays.sort(jobs, new Comparator<Job>() {
			public int compare(Job a, Job b) {
				if(a.finishTime < b.finishTime) {
					return -1;
				}else {
					return 1;
				}
			}
		});
		
		/*for(Job job : jobs) {
			System.out.println(job.finishTime);
		}*/
		
		int res[] = new int[startTime.length];
		
		for(int i = 0; i < startTime.length; i++) {
			res[i] = jobs[i].weight; 
		}
		
		for(int i = 1; i < jobs.length; i++) {
			for(int j = 0; j < i; j++) {
				if(jobs[j].finishTime <= jobs[i].startTime) {
					if(res[i] < res[j] + jobs[i].weight) {
						res[i] = res[j] + jobs[i].weight;
					}
				}
			}
		}
		
		int max = 0;
		
		for(int i = 0; i < res.length; i++) {
			//System.out.print(" "+res[i]+" ");
			if(max < res[i]) {
				max = res[i];
			}
		}
		return max;
	}
	
}
