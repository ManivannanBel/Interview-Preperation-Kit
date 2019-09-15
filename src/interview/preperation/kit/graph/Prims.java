package interview.preperation.kit.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Prims {
	
	class Node{
		int data;
		int cost;
		
		public Node(int data, int cost) {
			this.data = data;
			this.cost = cost;
		}
	}
	
	void primsMST(Graph g, int source) {
		Set<Integer> settled = new HashSet<>();	//Contains visited vertices
		Map<Integer, Integer> parentMap = new HashMap<Integer, Integer>();	//store the parent of vertices
		int distance[] = new int[g.getNoOfVertices()];	
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>(new Comparator<Node>() {		//implementing minheap
			@Override
			public int compare(Node a, Node b) {
				if(a.cost < b.cost) {
					return -1;
				}
				if(a.cost > b.cost) {
					return 1;
				}else {
					return 0;
				}
			}
		});
		
		for(int i=0; i<g.getNoOfVertices(); ++i) {	//Intially setting all distance to infinity
			distance[i] = Integer.MAX_VALUE; 
		}
		
		distance[source] = 0;
		
		minHeap.offer(new Node(source, 0));	
		
		while(!minHeap.isEmpty()) {
			
			Node vNode = minHeap.poll();
			if(!settled.contains(vNode.data)) {	//Check if vertice is visited already
				
				settled.add(vNode.data);	//add current vertex as visited
				
				int newDistance = -1;
				
				for(Edge edge : g.vertexMap.get(vNode.data).adj) {	//Explore current vertex's adjecent
					if(!settled.contains(edge.v.data)) {	//Check if vertice is visited already
						
						newDistance = edge.cost;
						
						if(newDistance < distance[edge.v.data]) {	//If new distance is < old distance, update distance table, set its parent, add it to minHeap
							distance[edge.v.data] = newDistance;
							parentMap.put(edge.v.data, vNode.data);
							minHeap.offer(new Node(edge.v.data, newDistance));
						}

					}
				}
			}
		}
		
		//Printing the result
		int minimumCost = 0;
		System.out.println("Vertex|Parent|distance");
		for(int i=0; i<g.getNoOfVertices(); ++i) {
			minimumCost += distance[i];
			System.out.println("   "+ i + "   |   " + parentMap.get(i)+ "   |   " + distance[i]);
		}
		System.out.println("Minimum cost = " + minimumCost);
		
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
		
		Prims prims = new Prims();
		prims.primsMST(graph, 0);
		
	}
	
}
