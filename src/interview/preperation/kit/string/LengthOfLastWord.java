package interview.preperation.kit.string;

public class LengthOfLastWord {
	public static void main(String args[]) {
		System.out.println(lengthOfLastWord("hello world "));
	}
	
	public static int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int index = s.length() - 1;
        while(index >= 0 && s.charAt(index) == ' ') index--;
        int wordSize = 0;
        while(index >= 0 && s.charAt(index) != ' ') {
            wordSize++;
            index--;
        }
        return wordSize;
    }
}
