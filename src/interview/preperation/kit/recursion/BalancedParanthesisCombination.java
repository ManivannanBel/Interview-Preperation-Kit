package interview.preperation.kit.recursion;

import java.util.ArrayList;

public class BalancedParanthesisCombination {

	void findBalancedParanthesisCombination(int n, int opened, int closed, int index, char[] result, ArrayList<String> results){
		if(index == 2 * n) {
			results.add(String.valueOf(result));
		}else {
			if(opened < n) {
				result[index] = '(';
				findBalancedParanthesisCombination(n, opened + 1, closed, index + 1, result, results);
			}
			if(opened > closed) {
				result[index] = ')';
				findBalancedParanthesisCombination(n, opened, closed + 1, index + 1, result, results);
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> results = new ArrayList<String>();
		BalancedParanthesisCombination bc = new BalancedParanthesisCombination();
		bc.findBalancedParanthesisCombination(3, 0, 0, 0, new char[3*2], results);
		results.forEach(value -> System.out.println(value));
	}
	
}
