package interview.preperation.kit.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DisjointSet {

	Map<Integer, Node> map = new HashMap<Integer, Node>();
	
	class Node{
		int data;
		int rank;
		Node parent;
	}
	
	public void makeSet(int v) {
		Node newSet = new Node();
		newSet.data = v;
		newSet.rank = 0;
		newSet.parent = newSet;
		map.put(v, newSet);
	}
	
	public Node findSet(int v) {
		return findSet(map.get(v));
	}
	
	public Node findSet(Node n) {
		Node parent = n.parent;
		if(parent == n) {
			return parent;
		}
		n.parent = findSet(parent.parent);
		return n.parent;
	}
	
	public boolean union(int v1, int v2) {
		Node n1 = map.get(v1);
		Node n2 = map.get(v2);
		
		Node parent1 = findSet(n1);
		Node parent2 = findSet(n2);
		
		if(parent1==parent2) {
			return false;
		}
		
		if(parent1.rank > parent2.rank) {
			parent2.parent = parent1;
		}else if(parent1.rank < parent2.rank) {
			parent1.parent = parent2;
		}else {
			parent2.parent = parent1;
			parent1.rank += 1;
		}
		return true;
		
	}
	
	public static void main(String[] arg) {
	
		DisjointSet disjointSet = new DisjointSet();
		
		disjointSet.makeSet(0);
		disjointSet.makeSet(1);
		disjointSet.makeSet(2);
		disjointSet.makeSet(3);
		disjointSet.makeSet(4);
		disjointSet.makeSet(5);
		disjointSet.makeSet(6);
		
		for(Entry entry : disjointSet.map.entrySet()) {
			System.out.println("node " +entry.getKey() + " parent: " + (disjointSet.findSet((int)entry.getKey()).data));
		}
		
		disjointSet.union(0, 5);
		disjointSet.union(1, 6);
		disjointSet.union(0, 6);
		disjointSet.union(2, 3);
		disjointSet.union(3, 4);
		disjointSet.union(1, 2);
		
		System.out.println();
		for(Entry entry : disjointSet.map.entrySet()) {
			System.out.println("node " +entry.getKey() + " parent: " + (disjointSet.findSet((int)entry.getKey()).data));
		}
		
	}
	
}
