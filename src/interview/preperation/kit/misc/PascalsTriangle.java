package interview.preperation.kit.misc;

import java.util.List;
import java.util.ArrayList;;

public class PascalsTriangle {
	public static void main(String args[]) {
		List<List<Integer>> triangle = pascalsTriangleDP(5);
		print(triangle);
	}
	
	public static List<List<Integer>> pascalsTriangleDP(int numRows){
		if(numRows == 0) return new ArrayList();
	       List<List<Integer>> Result = new ArrayList();
	       List<Integer> curRow = new ArrayList<Integer>();
	        curRow.add(1);
	        Result.add(curRow);
	        for(int i = 1; i < numRows; i++){
	            curRow = new ArrayList<Integer>();
	            for(int j = 0; j < i + 1; j++){
	                if(j == 0 || j == i){
	                    curRow.add(1);
	                }else{
	                    int val = Result.get(i - 1).get(j - 1) + Result.get(i - 1).get(j);
	                    curRow.add(val);
	                }
	            }
	            Result.add(curRow);
	        }
	        return Result;
	}
	
	public static void print(List<List<Integer>> triangle) {
		System.out.println("[");
		for(int i = 0; i < triangle.size(); i++) {
			System.out.print("[");
			for(int j = 0; j < triangle.get(i).size(); j++) {
				System.out.print(triangle.get(i).get(j)+" ");
			}
			System.out.println("]");
		}
		System.out.println("]");
	}
}
