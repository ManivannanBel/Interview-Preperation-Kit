package interview.preperation.kit.string;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 * */

public class LongestCommonPrefix {
	public static void main(String args[]) {
		String strs[] = {"flower","flow","flight"};
		String res1 = longestCommonPrefix(strs);
		System.out.println(res1);
	}
	
	public static String longestCommonPrefix(String[] strs) {
	       if(strs == null || strs.length == 0) return "" ;
	       if(strs.length == 1) return strs[0];
	       StringBuffer sb = new StringBuffer();
	       int minLen = Integer.MAX_VALUE;
	       for(int i = 0; i < strs.length; i++){
	           if(strs[i].length() < minLen){
	               minLen = strs[i].length();
	           }
	       } 
	       char ch;
	       for(int i = 0; i < minLen; i++){
	           ch = ' ';
	           for(int j = 0; j < strs.length; j++){
	              if(ch == ' '){
	                  ch = strs[j].charAt(i);
	              }else if(ch != strs[j].charAt(i)){
	                  return sb.toString();
	              }
	           }         
	           sb.append(ch);
	       } 
	       return sb.toString();
	    }
}
