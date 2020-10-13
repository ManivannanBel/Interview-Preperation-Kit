package interview.preperation.kit.array;

/*
In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and 
only if it is composed of cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they 
are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right. 
If such a path does not exist, return -1.

Example 1:
Input: [[0,1],[1,0]]
Output: 2

Example 2:
Input: [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class QueueItem{
    public int row, col, dist;
    public QueueItem(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

public class ShortestPathInBinaryMatrix {
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	public static void main(String args[]) {
//		int grid[][] = {{0,0,1,0,0,0,0},
//					    {0,1,0,0,0,0,1},
//					    {0,0,1,0,1,0,0},
//					    {0,0,0,1,1,1,0},
//					    {1,0,0,1,1,0,0},
//					    {1,1,1,1,1,0,1},
//					    {0,0,1,0,0,0,0}};
		int grid[][] = {{0,1,0,0,1,1,0},
						{1,0,0,0,0,0,0},
						{1,0,0,1,1,1,1},
						{0,1,0,0,0,0,0},
						{1,0,0,0,0,0,1},
						{1,0,0,1,0,0,0},
						{1,0,1,0,0,1,0}};
		
		System.out.println(shortestPathBinaryMatrix(grid));
		}
	
	public static int shortestPathBinaryMatrix(int[][] grid) {
		if(grid == null) return 0;
        if(grid[0][0] == 1) return -1;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        Queue<QueueItem> queue = new LinkedList<QueueItem>();
        queue.add(new QueueItem(0,0,1));
        while(!queue.isEmpty()){
            QueueItem q = queue.poll();
            int row = q.row, col = q.col, dist = q.dist;
            if(visited[row][col]) continue;
            visited[row][col] = true;
            if(row == grid.length -1 && col == grid[0].length - 1){
                return dist;
            }
            for(int i = 0; i < 8; i++){
                int newRow = row + directions[i][0], newCol = col + directions[i][1];
                if(isValid(newRow, newCol, grid)){
                    queue.add(new QueueItem(newRow, newCol, dist + 1));
                }
            }
        }
        return -1;
    }
    
    public static boolean isValid(int row, int col, int[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid.length || grid[row][col] == 1) return false;
        return true;
    }

}


