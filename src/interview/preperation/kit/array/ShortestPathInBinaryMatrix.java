package interview.preperation.kit.array;

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


