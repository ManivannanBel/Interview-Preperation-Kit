package interview.preperation.kit.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {
	
	public void topologicalOrder(Graph g) {
		Stack<Integer> order = new Stack<>();	//Stack contains the topological order 
		Set<Integer> settled = new HashSet<>();	//Contains the visited vertices
		
		for(Vertex vertex : g.allVertex) {
			if(settled.contains(vertex.data)) {	//If already visited, we just skip the vertex
				continue;
			}
			TopSortUtil(vertex, order, settled);
		}
		
		//Printing the result
		System.out.print("\nTopological order: [");
		while(!order.isEmpty()) {
			System.out.print(order.pop()+" ");
		}
		System.out.println("]");
	}
	
	public void TopSortUtil(Vertex vertex, Stack<Integer> order, Set<Integer> settled) {
		
		settled.add(vertex.data);	//Vertex is being visited
		
		for(Edge edge : vertex.adj) {	//Iterating through all the adjacent vertices of current Vertex
			Vertex v = edge.v;
			if(!settled.contains(v.data)) {	//If the vertex is not visited the visit it
				TopSortUtil(v, order, settled);
			}
		}
		
		order.push(vertex.data);	//Add the visited vertex to the stack
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(true, false);  //Directed and Unweighted
		
		g.addVertex(0);
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);
		
		g.addEdge(0, 4, 1);
		g.addEdge(1, 0, 1);
		g.addEdge(1, 4, 1);
		g.addEdge(2, 0, 1);
		g.addEdge(3, 6, 1);
		g.addEdge(5, 0, 1);
		g.addEdge(5, 2, 1);
		g.addEdge(5, 1, 1);
		
		//Printing Vertices and its Adjecent Vertices
		for(Vertex v : g.allVertex) {
			v.print();
		}

		TopologicalSort topologicalSort = new TopologicalSort();
		topologicalSort.topologicalOrder(g);
		
	}
	
}
