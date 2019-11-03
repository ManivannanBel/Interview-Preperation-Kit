package interview.preperation.kit.dynamicprogramming;

public class RegularExpression {

	public static void main(String args[]) {
		
		System.out.println(regexMatching("xaabyc", "xa*b.c"));
		System.out.println(regexMatching("xaaac", "xa*c"));
		System.out.println(regexMatching("xaaac", "xa*.c"));
		System.out.println(regexMatching("xbyc", "xa*b.c"));
		System.out.println(regexMatching("xaayc", "xa*b.c"));
		System.out.println(regexMatching("ably", "a*b.*y"));
		System.out.println(regexMatching("ablmy", "a*b.*y"));
		
	}
	
	public static boolean regexMatching(String st, String regex) {
		
		boolean T[][] = new boolean[st.length() + 1][regex.length() + 1];
		
		for(int i = 0 ; i < st.length() + 1 ; i++) {
			T[i][0] = false;
		}
		
		T[0][0] = true;
		
		for(int i = 1; i < regex.length() + 1; i++) {
			if(regex.charAt(i - 1)=='*') {
				T[0][i] = T[0][i - 2];
			}else {
				T[0][i] = false; 
			}
		}
		
		for(int i = 1; i < st.length() + 1; i++) {
			for(int j = 1; j < regex.length() + 1; j++) {
				
				if(st.charAt(i - 1) == regex.charAt(j - 1) || regex.charAt(j - 1) == '.') {
					T[i][j] = T[i - 1][j - 1]; 
				}else {
					if(regex.charAt(j - 1) == '*') {
						//zero occurance
						if(T[i][j - 2]) {
							T[i][j] = true;
							continue;
						}else {
							if(st.charAt(i - 1) == regex.charAt(j - 2) || regex.charAt(j - 2) == '.') {
								T[i][j] = T[i - 1][j]; 
							}else {
								T[i][j] = false; 
							}
						}
					}
				}
			}
		}
		
		/*for(int i = 0; i < st.length()+1; i++) {
			for(int j=0; j < regex.length()+1; j++) {
				System.out.print(T[i][j]+" ");
			}
			System.out.println();
		}*/
		
		return T[st.length()][regex.length()];
	}
	
}
