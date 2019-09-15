package interview.preperation.kit.graph;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Kruskals {

	DisjointSet disjointSet = new DisjointSet();	//Create disjoint set
	List<Node> edges = new LinkedList<Node>();	//store all the edges in the graph
	
	class Node{	//This node represents an edge between two vertex i.e, source and destination.
		int source;
		int destination;
		int cost;
		public Node(int source, int destination, int cost) {
			this.source = source;
			this.destination = destination;
			this.cost = cost;
		}
	}
	
	public void kruskalsMST(Graph g, int start){
		
		List<Node> resultantEdges = new LinkedList<Node>();	//To store the resultant edges
 		
		for(Vertex vertex : g.allVertex) {
			
			disjointSet.makeSet(vertex.data);	//Create sets for all the vertex
			
			for(Edge edge : vertex.adj) {	//Add all the edges present in the graph
				edges.add(new Node(vertex.data, edge.v.data, edge.cost));
			}
		}
		
		//Sort the edges in ascending order
		Collections.sort(edges, new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				if(a.cost < b.cost) return -1;
				else if(a.cost > b.cost) return 1;
				else return 0;
			}
		});
		
		
		for(Node node : edges) {
			//Check if the two vertices are from different sets, then union them and add the edge to resultant list
			if(disjointSet.union(node.source, node.destination)) {
				resultantEdges.add(node);
			}
		}
		
		//Printing the result
		int minimumCost = 0;
		System.out.println("\nEdge   |   distance");
		for(Node n : resultantEdges) {
			System.out.println(n.source +"  |  "+ n.destination +"    |    "+n.cost);
			minimumCost += n.cost;
		}
		System.out.print("minimum cost: "+minimumCost);
		
	}
	
	public static void  main(String[] args) {
		Graph graph = new Graph(false, true);
		graph.addVertex(0);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		
		graph.addEdge(0, 1, 3);
		graph.addEdge(0, 3, 1);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 3);
		graph.addEdge(2, 3, 1);
		graph.addEdge(2, 4, 5);
		graph.addEdge(2, 5, 4);
		graph.addEdge(3, 4, 6);
		graph.addEdge(4, 5, 2);
		
		//Printing Vertices and its Adjecent Vertices
		for(Vertex v : graph.allVertex) {
			v.print();
		}
		
		Kruskals kruskals = new Kruskals();
		kruskals.kruskalsMST(graph, 0);
		
	}
	
}
