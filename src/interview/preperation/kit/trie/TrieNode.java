package interview.preperation.kit.trie;

import java.util.HashMap;

public class TrieNode {
	private HashMap<Character, TrieNode> children;
	private boolean isWord;
	
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		isWord = false;
	}

	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(HashMap<Character, TrieNode> children) {
		this.children = children;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}
	
}
