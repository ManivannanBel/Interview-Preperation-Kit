package interview.preperation.kit.string;

import java.util.HashMap;
import java.util.Map.Entry;

import interview.preperation.kit.trie.Trie;
import interview.preperation.kit.trie.TrieNode;

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
		String res1 = longestCommonPrefix1(strs);
		System.out.println(res1);
		String res2 = longestCommonPrefix2(strs);
		System.out.println(res2);
	}
	
	//O(N * M) N -> length of string array, M length if the shortest string present in the array
	public static String longestCommonPrefix1(String[] strs) {
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
	
	//O(N * M) for insertion of all the strings, O(M) for walk on trie to find LCP
	public static String longestCommonPrefix2(String[] strs) {
		Trie trie = new Trie();
		
		//O(N * M)
		for(String str : strs) {
			trie.insert(str);
		}
		
		StringBuffer sb = new StringBuffer();
		
		TrieNode currentNode = trie.getRoot();
		HashMap<Character, TrieNode> children = currentNode.getChildren();
		//O(M)
		while(children.size() > 0) {
			
			if(children.size() == 1) {
				for(Entry<Character, TrieNode> entry : children.entrySet()) {
					char ch = (char)entry.getKey();
					sb.append(ch);
					currentNode = (TrieNode)entry.getValue();
					children = currentNode.getChildren();
				}
			}else {
				return sb.toString();
			}
		}
		return sb.toString();
	}
}
