package interview.preperation.kit.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class dijkstrasShortestPathAlgorithm {

	class Node{
		int data;
		int cost;
		public Node(int data, int cost) {
			super();
			this.data = data;
			this.cost = cost;
		}
	}
	
	void dijkstras(Graph g, int source) {
		int noOfVertices = g.getNoOfVertices();
		int[] distance = new int[noOfVertices];
		Map<Integer,Integer> parentMap = new HashMap<>();
		Set<Integer> settled = new HashSet<>();
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				if(a.cost < b.cost) {
					return -1;
				}else if(a.cost > b.cost) {
					return 1;
				}else {
					return 0;
				}
			}
		});
		
		for(int i=0; i<noOfVertices; ++i) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		distance[source] = 0;
		minHeap.add(new Node(source, 0));
		
		while(settled.size() != noOfVertices) {
			Node u = minHeap.remove();
			settled.add(u.data);
			
			int newDistance = -1;
			
			for(Edge e : g.vertexMap.get(u.data).adj) {
				Vertex v = e.v;
				int UtoVDistance = e.cost;
				newDistance = UtoVDistance + u.cost;
				
				if(newDistance < distance[v.data]) {
					distance[v.data] = newDistance;
					parentMap.put(v.data, u.data);
					minHeap.add(new Node(v.data, newDistance));
				}
				
			}
			
		}
		
		for(int i=0; i < noOfVertices; i++) {
			System.out.println(source + " to " + i + " is " + distance[i] + " with " + parentMap.get(i) + " as parent");
		}
				
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(false, true);
		g.addVertex(0);
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);
		g.addVertex(7);
		g.addVertex(8);
		
		g.addEdge(0, 1, 4);
		g.addEdge(0, 7, 8);
		g.addEdge(1, 7, 11);
		g.addEdge(1, 2, 8);
		g.addEdge(2, 8, 2);
		g.addEdge(2, 5, 4);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 5, 14);
		g.addEdge(3, 4, 9);
		g.addEdge(4, 5, 10);
		g.addEdge(5, 6, 2);
		g.addEdge(7, 8, 7);
		g.addEdge(7, 6, 1);
		g.addEdge(6, 8, 6);
		
		for(Vertex v : g.allVertex) {
			v.print();
		}
		
		dijkstrasShortestPathAlgorithm dijks = new dijkstrasShortestPathAlgorithm();
		dijks.dijkstras(g, 0);
		
	}
	
}
