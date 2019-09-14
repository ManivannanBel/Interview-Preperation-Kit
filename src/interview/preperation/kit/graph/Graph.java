package interview.preperation.kit.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Vertex{
	int data;
	List<Edge> adj;
	boolean visited = false;
	public Vertex(int data) {
		this.data = data;
		adj  = new LinkedList<>();
	}
	
	public void print() {
		System.out.print(data + " - [ ");
		for(Edge e : adj) {
			System.out.print(" ( node:"+e.v.data + ", cost:"+ e.cost +") ");
		}
		System.out.println("]");
	}
}

class Edge{
	Vertex v;
	int cost;
	
	Edge(Vertex v, int cost){
		this.v = v;
		this.cost = cost;
	}
}

public class Graph {
	private boolean directed;
	private boolean weighted;
	private int NoOfVertices;
	private int NoOfEdges;
	
	public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	public boolean isWeighted() {
		return weighted;
	}

	public void setWeighted(boolean weighted) {
		this.weighted = weighted;
	}

	public int getNoOfVertices() {
		return NoOfVertices;
	}

	public void setNoOfVertices(int noOfVertices) {
		NoOfVertices = noOfVertices;
	}

	public int getNoOfEdges() {
		return NoOfEdges;
	}

	public void setNoOfEdges(int noOfEdges) {
		NoOfEdges = noOfEdges;
	}

	List<Vertex> allVertex;
	Map<Integer, Vertex> vertexMap;
	
	Graph(boolean directed, boolean weighted){
		this.directed = directed;
		this.weighted = weighted;
		this.NoOfVertices = 0;
		this.NoOfEdges = 0;
		allVertex = new ArrayList<>();
		vertexMap = new HashMap<>();
	}
	
	void addVertex(int value) {
		if(!vertexMap.containsKey(value)) {
			Vertex v = new Vertex(value);
			allVertex.add(v);
			vertexMap.put(value, v);
			this.NoOfVertices++;
		}
	}
	
	void addEdge(int source, int destination, int cost) {
		if(!weighted) {
			cost = 1;
		}
		if(vertexMap.containsKey(source) && vertexMap.containsKey(destination)) {
			Vertex s = vertexMap.get(source);
			Vertex v = vertexMap.get(destination);
			Edge e = new Edge(v,cost);
			s.adj.add(e);
			this.NoOfEdges++;
			if(!directed) {
				this.NoOfEdges++;
				v.adj.add(new Edge(s, cost));
			}
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
		//g.addEdge(4, 6, 1);		
		for(Vertex v : g.allVertex) {
			v.print();
		}
		
		//g.DFS(g.allVertex.get(0));
		//g.BFS(g.allVertex.get(0));
		
	}
	
}





















