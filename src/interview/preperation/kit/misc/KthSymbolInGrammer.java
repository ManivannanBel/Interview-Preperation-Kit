package interview.preperation.kit.misc;

public class KthSymbolInGrammer {
	public static void main(String args[]) {
		System.out.println(kthGrammar1(4,5));
		System.out.println(kthGrammar(4,5));
	}
	
	//Not Efficient
	public static int kthGrammar1(int N, int K) {
        StringBuffer prev = new StringBuffer("0");
        StringBuffer cur;
        for(int i = 1; i < N; i++){
            cur = new StringBuffer();
            for(int j = 0; j < prev.length(); j++){
                char ch = prev.charAt(j);
                if(ch == '0'){
                    cur.append("01");
                }else{
                    cur.append("10");
                }
            }
            prev = cur;
        }
        return prev.charAt(K - 1) - 48;        
    }
	
	//Efficient
	/*
	 * If you notice the pattern,
	 * Eg : N = 4, K = 5 => 01101001
	 * We can see that the second half is the inverse of the first half of the pattern
	 * 
	 * if K > half of the length of the pattern,
	 *  reduce K by half of the pattern size
	 * 	We reduce the pattern length to half, and count the flips
	 * or if K < half of the length of pattern,
	 *  We reduce the pattern length to half, and count the flips
	 * Do the above until K > 2
	 * decrement k to get to 1 or 0
	 * if flips are odd, then flip the k value
	 */ 
	public static int kthGrammar(int N, int K) {
        long noOfBits = (long)Math.pow(2, N - 1);
        int flips = 0;
        
        while(noOfBits > 2){
            if(K > noOfBits / 2){
                K -= noOfBits / 2;
                flips++;
            }
            noOfBits /= 2;
        }
        
        K--;
        
        if(flips % 2 == 1) K = 1 - K;
        
        return K;
    }
}
