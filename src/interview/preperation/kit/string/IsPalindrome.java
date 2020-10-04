package interview.preperation.kit.string;

public class IsPalindrome {
	public static void main(String[] args) {
		String string = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(string));
	}
	public static boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1) return true;
        int low = 0, high = s.length() - 1;
        while(low <= high){
            char leftCh = ignoreCase(s.charAt(low));
            char rightCh = ignoreCase(s.charAt(high));
            if(isAlphaNum(leftCh) && isAlphaNum(rightCh)){
                if(leftCh == rightCh){
                    low++;
                    high--;
                }else{
                    return false;
                }
            }else{
                if(!isAlphaNum(leftCh)){
                    low++;    
                }
                if(!isAlphaNum(rightCh)){
                    high--;
                }
            } 
        }
        return true;
        
    }
    
    public static boolean isAlphaNum(char ch){
        if((ch >= 97 && ch <= 122) || (ch >= 48 && ch <= 57))
            return true;
        return false;
    }
    
    public static char ignoreCase(char ch){
        if(ch >= 65 && ch <= 90){
            ch = (char)(ch + 32);
        }
        return ch;
    }	
}
