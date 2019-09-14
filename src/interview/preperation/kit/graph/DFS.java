package interview.preperation.kit.graph;

public class DFS {

	static void DFSTraversal(Vertex start, Graph g) {
		System.out.print("\nDFS: [");
		DFSUtil(start);
		System.out.print("]");
	}
	
	static void DFSUtil(Vertex start) {
		
		System.out.print(start.data+" ");
		start.visited = true;
		for(Edge e : start.adj) {
			if(!e.v.visited)
				DFSUtil(e.v);
		}
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
		
		DFSTraversal(g.allVertex.get(0), g);
		
	}
	
}
