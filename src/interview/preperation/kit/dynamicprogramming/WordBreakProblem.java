package interview.preperation.kit.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {

	public static void main(String[] arg) {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("i");
		dictionary.add("am");
		dictionary.add("a");
		dictionary.add("ace");
		dictionary.add("mobile");
		dictionary.add("samsung");
		dictionary.add("sam");
		dictionary.add("sung");
		dictionary.add("man");
		dictionary.add("mango");
		dictionary.add("icecream");
		dictionary.add("and");
		dictionary.add("go");
		dictionary.add("like");
		dictionary.add("ice");
		dictionary.add("cream");
		
		System.out.println(wordBreak("iamace", dictionary));
		System.out.println(wordBreak("ilikesamsung", dictionary));
		System.out.println(wordBreak("iiiiiiii", dictionary));
		System.out.println(wordBreak("", dictionary));
		System.out.println(wordBreak("ilikelikeimangoiii", dictionary));
		System.out.println(wordBreak("samsungandmango", dictionary));
		System.out.println(wordBreak("samsungandmangok", dictionary));
		
	}
	
	public static boolean wordBreak(String input, Set<String> dictionary) {
		
		if(input.length() == 0) return true;
		
		boolean T[][] = new boolean[input.length()][input.length()];
		int R[][] = new int[input.length()][input.length()]; 	//word track array
		
		for(int i = 0; i < input.length(); i++) {
			if(dictionary.contains(input.substring(i, i+1))) {
				T[i][i] = true; 
				// -1 for true
				R[i][i] = -1; 
			}else {
				// -2 for false
				R[i][i] = -2;
			}
		}
		
		for(int l = 2; l <= input.length(); l++) {
			for(int i = 0; i < input.length() - (l - 1); i++) {
				int j = i + l -1;
				
				if(dictionary.contains(input.substring(i, j + 1))){
					 T[i][j] = true;
					 R[i][j] = -1; 
					 continue;
				}
				for(int k = i; k < j; k++) {
					if((T[i][k] && T[k + 1][j])) {
						T[i][j] = true;
						// k to denote the exact partition
						R[i][j] = k; 
						break;
					}
				}
				if(!T[i][j]) {
					//if not present in dictionary
					R[i][j] = -2; 
				}
			}
		}
		
		/*for(int i = 0; i < input.length(); i++) {
			for(int j = 0; j < input.length(); j++) {
				System.out.print(R[i][j]+"    ");
			}
			System.out.println();
		}*/
		
		if(T[0][input.length() - 1]) {
			int low = 0, high = input.length() - 1;
			System.out.print("[");
			while(R[low][high] != -1) {
				System.out.print(input.substring(low, R[low][high] + 1)+", ");
				low = R[low][high] + 1;
			}
			System.out.print(input.substring(low, high+1)+"] "+input+" -> ");
		}else {
			System.out.print(input+" -> ");
		}
		
		return T[0][input.length() - 1];
		
	}
	
}
