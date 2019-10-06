package interview.preperation.kit.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author Manivannan
 *
 * Generate all permutations of a string
 */

public class StringPermutation {
	
	public List<String> GeneratePErmutation(String str){
		Map<Character, Integer> countMap = new TreeMap<Character, Integer>();
		for(int i=0; i < str.length(); ++i) {
			countMap.compute(str.charAt(i), (key, value) -> {
				if(value==null)
					return 1;
				return value + 1;
			});
		}
		
		char[] st = new char[str.length()];
		int[] count = new int[str.length()];
		int index = 0;
		for(Map.Entry entry : countMap.entrySet()) {
			st[index] = (char)entry.getKey();
			count[index] = (int)entry.getValue();
			index++;
		}
		List<String> resultList = new ArrayList<String>();
		char[] result = new char[str.length()];
		permutateUtil(st, result, count, 0, resultList);
		return resultList;
	}
	
	public void permutateUtil(char[] str, char result[], int[] count, int index, List<String> resultList) {
		
		if(index == str.length) {
			resultList.add(String.valueOf(result));
		}else {
			for (int i = 0; i < str.length; i++) {
				if(count[i] != 0) {
					count[i]--;
					result[index] = str[i];
					permutateUtil(str, result, count, index+1, resultList);
					count[i]++;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		String string = "aabc";
		new StringPermutation().GeneratePErmutation(string).forEach(s -> System.out.println(s));
	}
	
}
