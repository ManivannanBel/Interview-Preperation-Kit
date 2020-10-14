package interview.preperation.kit.array;

/*
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a 
rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell 
has a fresh orange.  If this is impossible, return -1 instead.
 

Example 1:
Input: [[2,1,1],
		[1,1,0],
		[0,1,1]]
Output: 4

Example 2:
Input: [[2,1,1],
		[0,1,1],
		[1,0,1]]
Output: -1

Explanation:  The orange in the bottom left corner (row 2, column 0) is 
never rotten, because rotting only happens 4-directionally.

Example 3:
Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, 
the answer is just 0.
 */

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	
	public static void main(String args[]) {
		int grid[][] = {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println(orangesRotting(grid));
	}
	
	public static int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 && grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<QueueItem> queue = new LinkedList<QueueItem>();
        
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 2){
                    grid[row][col] = -1;
                    queue.add(new QueueItem(row, col));
                }
            }
        }
        queue.add(null);
        
        int timer = 0;
        while(!queue.isEmpty()){
            QueueItem node = queue.poll();
            if(node != null){
                int row = node.row;
                int col = node.col;
                for(int i = 0; i < 4; i++){
                    int newRow = row + directions[i][0];
                    int newCol = col + directions[i][1];
                    if(isValid(newRow, newCol, grid) && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = -1;
                        queue.add(new QueueItem(newRow, newCol));
                    }
                }
            }else{
               
               if(!queue.isEmpty() && queue.peek() != null) {
                   queue.add(null);
                   timer++; 
               }
                
            }
        }
        
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 1) return -1;
            }
        }
        
        return timer;
    }
    
    public static boolean isValid(int row, int col, int[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return false;
        return true;
    }
}