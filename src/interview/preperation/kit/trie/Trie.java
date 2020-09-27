package interview.preperation.kit.trie;

import java.util.HashMap;

public class Trie {
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public TrieNode getRoot() {
		return root;
	}
	
	public void insert(String str) {
		int level = 0;
		
		TrieNode currentNode = root;
		
		for(level = 0; level < str.length(); level++) {
			char ch = str.charAt(level);
			HashMap<Character, TrieNode> children = currentNode.getChildren();
			if(!children.containsKey(ch)) {
				children.put(ch, new TrieNode());
			}
			currentNode = children.get(ch);
		}		
		currentNode.setWord(true);
	}
	
	public boolean search(String str) {
		int level = 0;
		
		TrieNode currentNode = root;
		for(level = 0; level < str.length(); level++) {
			char ch = str.charAt(level);
			HashMap<Character, TrieNode> children = currentNode.getChildren();
			if(!children.containsKey(ch)) {
				return false;
			}
			currentNode = children.get(ch);
		}
		
		return currentNode.isWord();
	}
	
	public static void main(String args[]) {
		Trie trie = new Trie();
		String strs[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
		for(int i = 0; i < strs.length; i++) {
			trie.insert(strs[i]);
		}
		System.out.println(trie.search("there"));
	}
}
