/*
 * Articulation point finding algorithm using Tarjan's Algorithm:
 * Time Complexity: O(V+E) since it is depth first search
 * Space Complexity: O(V)
 */
package interview.preperation.kit.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArticulationPoint {

	static int time;
	
	public void findArticulationPoints(Graph g, int source) {
			Map<Integer, Integer> parent = new HashMap<Integer, Integer>();
			Map<Integer, Integer> visitedTime = new HashMap<Integer, Integer>();
			Map<Integer, Integer> lowTime = new HashMap<Integer,Integer>();
			ArrayList<Integer> articulationPoint = new ArrayList<Integer>();
			Set<Integer> visited = new HashSet<>();
			time = 0;
			//This algorithm uses Depth First Search
			DFS(g.vertexMap.get(source), parent, visitedTime, lowTime, articulationPoint, visited);
			
			System.out.println("\nArticulation points:");
			for(int ap : articulationPoint) {
				System.out.print(ap+" ");
			}
	}
	
	public void DFS(Vertex vertex, 
			Map<Integer, Integer> parent, 
			Map<Integer, Integer> visitedTime,
			Map<Integer, Integer> lowTime, 
			ArrayList<Integer> articulationPoint,
			Set<Integer> visited) {
		
		visited.add(vertex.data);
		visitedTime.put(vertex.data, time);
		lowTime.put(vertex.data, time);
		time++;
		int childCount = 0;
		boolean isArticulationPoint = false;
		
		for(Edge edge : vertex.adj) {
			
			if(parent.containsKey(vertex.data) && edge.v.data == parent.get(vertex.data)) continue;
			
			if(!visited.contains(edge.v.data)) {
				childCount++;
				parent.put(edge.v.data, vertex.data);
				DFS(edge.v, parent, visitedTime, lowTime, articulationPoint, visited);
				
				if(visitedTime.get(vertex.data) <= lowTime.get(edge.v.data)) {
					isArticulationPoint = true;
				}else {
					lowTime.put(vertex.data ,Math.min(lowTime.get(vertex.data), lowTime.get(edge.v.data)));
				}
				
			}else {
				lowTime.put(vertex.data ,Math.min(lowTime.get(vertex.data), visitedTime.get(edge.v.data)));
			}
		}
		
		if(parent.get(vertex.data) == null && childCount >= 2 ||
				parent.get(vertex.data) != null && isArticulationPoint){
			
			articulationPoint.add(vertex.data);
		}
	}
	
	public static void main(String[] arg) {
		Graph graph = new Graph(false, false);
		
		graph.addVertex(0);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addVertex(6);
		graph.addVertex(7);
		
		graph.addEdge(0, 1, 0);
		graph.addEdge(0, 2, 0);
		graph.addEdge(1, 2, 0);
		graph.addEdge(2, 3, 0);
		graph.addEdge(3, 4, 0);
		graph.addEdge(4, 5, 0);
		graph.addEdge(4, 6, 0);
		graph.addEdge(5, 6, 0);
		graph.addEdge(5, 7, 0);
		
		//System.out.println("\nGraph 2");
		for(Vertex v : graph.allVertex) {
			v.print();
		}
		
		ArticulationPoint articulationPoint = new ArticulationPoint();
		articulationPoint.findArticulationPoints(graph, 0);
		
	}
	
}
