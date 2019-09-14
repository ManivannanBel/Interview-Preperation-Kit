package interview.preperation.kit.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	static void BFSTraversal(Vertex start) {
		Queue<Vertex> q = new LinkedList<>();
		
		System.out.print("\nBFS : [");
		
		q.offer(start);
		while(!q.isEmpty()) {
			Vertex v = q.poll();
			if(v.visited) {
				continue;
			}
			System.out.print(v.data+" ");
			v.visited = true;
			for(Edge e : v.adj) {
				if(!e.v.visited)
					q.add(e.v);
			}
		}
		
		System.out.print("]");
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(false, false);
		
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);
		g.addVertex(7);
		
		g.addEdge(1, 2, 1);
		g.addEdge(1, 7, 1);
		g.addEdge(1, 4, 1);
		g.addEdge(2, 5, 1);
		g.addEdge(2, 6, 1);
		g.addEdge(3, 6, 1);
		g.addEdge(4, 6, 1);
		g.addEdge(5, 7, 1);
		
		for(Vertex v : g.allVertex) {
			v.print();
		}
		
		BFSTraversal(g.allVertex.get(0));
		
	}
	
}
