package interview.preperation.kit.string;

import java.util.Arrays;

public class StringPermutationApproach2 {

	void findPermutationWithoutDuplicates(char[] st, int left, int right) {
		if(left == right) {
			System.out.println(String.valueOf(st));
		}else {
			for(int i = left; i <= right; i++) {
				st = swap(st, i, left);
				findPermutationWithoutDuplicates(st, left+1, right);
				st = swap(st, i, left);
			}
		}
	}
	
	void findPermutationWithDuplicates(char[] st, int left, int right) {
		if(left == right) {
			System.out.println(String.valueOf(st));
		}else {
			for(int i = left; i <= right; i++) {
				st = swap(st, i, left);
				findPermutationWithoutDuplicates(st, left+1, right);
				st = swap(st, i, left);
				while(st[i] == st[i + 1]) {
					i++;
					if(i + 1 >= right) {
						break;
					}
				}
			}
		}
	}
	
	char[] swap(char[] st, int a, int b) {
		char temp = st[a];
			st[a] = st[b];
			st[b] = temp;
			return st;
	}
	
	public static void main(String args[]) {
		StringPermutationApproach2 sp = new StringPermutationApproach2();
		String string1 = "abc";
		System.out.println("Permutation without duplicate");
		sp.findPermutationWithoutDuplicates(string1.toCharArray(), 0, string1.length()-1);
		String string2 = "aab";
		System.out.println("\nPermutation with duplicate");
		char[] str = string2.toCharArray();
		Arrays.sort(str);
		sp.findPermutationWithDuplicates(str, 0, string2.length()-1);
	}
}
