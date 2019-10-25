package interview.preperation.kit.dynamicprogramming;

public class EggDroppingProblem {

	public static void main(String[] args) {
		System.out.println(calculate(2, 6));
		System.out.println(calculate(2, 10));
		System.out.println(calculate(2, 36));
	}
	
	public static int calculate(int eggs, int floors) {
		int T[][] = new int[eggs + 1][floors + 1];
		
		for(int i=0; i < floors + 1 ; i++) {
			T[1][i] = i; 
		}
		
		for(int e = 2; e < eggs + 1; e++) {
			for(int f = 1; f < floors + 1; f++) {
				T[e][f] = Integer.MAX_VALUE; 
				for(int k = 1; k <= f; k++) {
					int c = 1 + Math.max(T[e - 1][k - 1], T[e][f - k]);
					if(c < T[e][f]) {
						T[e][f] = c; 
					}
				}	
			}
		}
		
		return T[eggs][floors];
	}
	
	public static int recursion(int egg, int floors) {
		if(egg == 1) 
			return floors;
		if(floors == 0)
			return 0;
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= floors; i++) {
			int c = 1 + Math.max(recursion(egg - 1, i -1), recursion(egg, floors - i));
			if(c < min) {
				min = c;
			}
		}
		return min;
	}
	
}
