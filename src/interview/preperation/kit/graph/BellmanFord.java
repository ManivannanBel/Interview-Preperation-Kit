package interview.preperation.kit.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BellmanFord {

	List<Node> edgesList = new LinkedList<Node>();
	
	class Node{		//Node to store adge containing source, destination, weight
		int source;
		int destination;
		int cost;
		public Node(int source, int destination, int cost) {
			this.source = source;
			this.destination = destination;
			this.cost = cost;
		}
	}
	
	public void bellmanFordShortestPath(Graph g, int source) throws Exception {

		//Map is to store the vertex and its neighbour vertex through which the shortest path is attained from the source
		Map<Integer, Integer> parent = new HashMap<Integer, Integer>();	
		//To store the shortest distance from the source
		int distance[] = new int[g.getNoOfVertices()];
		
		//Set all the distace to infinity initially
		for(int i=0;i<g.getNoOfVertices();++i) {
			distance[i]= Integer.MAX_VALUE; 
		}
		
		//Set source distance to 0
		distance[source] = 0;
		
		//Store all the edges in the graph in a list
		for(Vertex vertex : g.allVertex) {
			for(Edge edge : vertex.adj) {
				edgesList.add(new Node(vertex.data, edge.v.data, edge.cost));
			}
		}
		
		//Iterate V-1 times
		for(int i=0; i<g.getNoOfVertices()-1; ++i) {
			
			for(Node e : edgesList) {
				int u = e.source;
				int v = e.destination;
				int costUtoV = e.cost;
				//If distance from source to V is less than [distance from source to U + distance between U to V]
				//then update the distance table and update its parent
				if(distance[v] > (distance[u] + costUtoV)) {
					distance[v] =  distance[u] + costUtoV;
					parent.put(v, u); 
				}
			}
		}
		
		//Perform one last iteration to check if there exists Negative weight cycle
		for(Node e : edgesList) {
			int u = e.source;
			int v = e.destination;
			int costUtoV = e.cost;
			//If cycle exists then throw Exception
			if(distance[v] > (distance[u] + costUtoV)) {
				throw new Exception("\nNegative weight cycle found");
			}
		}
		
		//Print the result if no negative weight cycle exists
		System.out.println("\nVertex | Distance | Parent");
		for(int i=0; i<g.getNoOfVertices(); ++i) {
			System.out.println("   "+i+"   |    "+distance[i]+"   |    "+ parent.get(i));
		}
		
	}
	
	public static void main(String[] args) {
	
		
		Graph graph = new Graph(true, true);
		
		graph.addVertex(0);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 5);
		graph.addEdge(0, 3, 8);
		graph.addEdge(1, 2, -3);
		graph.addEdge(2, 4, 4);
		graph.addEdge(3, 4, 2);
		graph.addEdge(4, 3, 1);
		
		
		//Print the graph
		System.out.println("Graph1");		
		for(Vertex v : graph.allVertex) {
			v.print();
		}
		
		BellmanFord bellmanFord = new BellmanFord();
		
		try {
			bellmanFord.bellmanFordShortestPath(graph, 0);
		} catch (Exception e) {
			System.out.print(e);
		}
		
		
		//Test case of graph with negative weight cycle
		Graph graph2 = new Graph(true, true);
		
		graph2.addVertex(0);
		graph2.addVertex(1);
		graph2.addVertex(2);
		graph2.addVertex(3);
		
		graph2.addEdge(0, 1, 1);
		graph2.addEdge(1, 2, 3);
		graph2.addEdge(2, 3, 2);
		graph2.addEdge(3, 1, -6);
		
		//Print the graph
		System.out.println("\nGraph 2");
		for(Vertex v : graph2.allVertex) {
			v.print();
		}
		
		BellmanFord bellmanFord1 = new BellmanFord();
		
		try {
			bellmanFord1.bellmanFordShortestPath(graph2, 0);
		} catch (Exception e) {
			System.out.print(e);
		}		
		
		
	}
	
}
