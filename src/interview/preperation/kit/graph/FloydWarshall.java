package interview.preperation.kit.graph;

/**
 * 
 * @author Manivannan
 *
 *Floyd Warshall Algorithm for finding all pair shortest path
 *Time Complexity: (V^3)
 *Space Complexity: (V^2)
 *
 *
 */

public class FloydWarshall {
	
	public static final int inf = Integer.MAX_VALUE;
	
	public void findAllPairShortestPath(int[][] adjMatrix) {
		int distanceMatrix[][] = new int[adjMatrix.length][adjMatrix.length];
		int pathMatrix[][] =  new int[adjMatrix.length][adjMatrix.length];
		int k = 0, i = 0, j = 0;
		
		//copying the adj matrix data to distance and path matrices
		for(i = 0; i < adjMatrix.length; ++i) {
			for(j = 0; j < adjMatrix.length; ++j) {
				distanceMatrix[i][j] = adjMatrix[i][j];
				
				//initially update the path only if there is direct edge between i and j
				if(adjMatrix[i][j] != inf && adjMatrix[i][j] != 0)
					pathMatrix[i][j] = i;
				else
					pathMatrix[i][j] = -1; 
			}
		}
		
		
		for(k = 0; k < adjMatrix.length; ++k) {
			for(i = 0; i < adjMatrix.length; ++i) {
				for(j = 0; j < adjMatrix.length; ++j) {
					
					//To avoid exceeding the integer limit
					if(distanceMatrix[i][k]== inf || distanceMatrix[k][j]== inf)
						continue;
					
					if(distanceMatrix[i][j] > distanceMatrix[i][k] + distanceMatrix[k][j]) {
						distanceMatrix[i][j] = distanceMatrix[i][k] + distanceMatrix[k][j];	
						pathMatrix[i][j] = pathMatrix[k][j]; //The shortest path is from i to j is via k
					}
				}
			}
		}
		
		
		//Printing the all pair shortest distance matrix
		System.out.println("\ndistance matrix");
		System.out.print(" \t");
		for(i = 0; i < adjMatrix.length; ++i) {
			System.out.print(i+"\t");
		}
		System.out.println();
		for(i = 0; i < adjMatrix.length; ++i) {
			System.out.print(i+"\t");
			for(j = 0; j < adjMatrix.length; ++j) {
				System.out.print(distanceMatrix[i][j]+"\t");
			}
			System.out.println();
		}
		
		//Printing the all pair shortest path matrix
		System.out.println("\npath matrix");
		System.out.print(" \t");
		for(i = 0; i < adjMatrix.length; ++i) {
			System.out.print(i+"\t");
		}
		System.out.println();
		for(i = 0; i < adjMatrix.length; ++i) {
			System.out.print(i+"\t");
			for(j = 0; j < adjMatrix.length; ++j) {
				System.out.print(pathMatrix[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
		int adjMatrix[][] = {
				{0, 3, inf, 7},
				{8, 0, 2, inf},
				{5, inf, 0, 1},
				{2, inf, inf, 0}
		};
		
		FloydWarshall floydWarshall = new FloydWarshall();
		floydWarshall.findAllPairShortestPath(adjMatrix);
		
	}
}
