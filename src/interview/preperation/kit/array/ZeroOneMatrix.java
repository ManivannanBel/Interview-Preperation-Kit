package interview.preperation.kit.array;

public class ZeroOneMatrix {
	
	public static void main(String args[]) {
		int matrix[][] = {{0,1,1},
						  };
//		int matrix[][] = {{1,0,1,1,0,0,1,0,0,1},
//						  {0,1,1,0,1,0,1,0,1,1},
//						  {0,0,1,0,1,0,0,1,0,0},
//						  {1,0,1,0,1,1,1,1,1,1},
//						  {0,1,0,1,1,0,0,0,0,1},
//						  {0,0,1,0,1,1,1,0,1,0},
//						  {0,1,0,1,0,1,0,0,1,1},
//						  {1,0,0,0,1,1,1,1,0,1},
//						  {1,1,1,1,1,1,1,0,1,0},
//						  {1,1,1,1,0,1,0,0,1,1}};
//		int matrix[][] = {{1,1,0,0,1,0,0,1,1,0},
//		                  {1,0,0,1,0,1,1,1,1,1},
//		                  {1,1,1,0,0,1,1,1,1,0},
//		                  {0,1,1,1,0,1,1,1,1,1},
//		                  {0,0,1,1,1,1,1,1,1,0},
//		                  {1,1,1,1,1,1,0,1,1,1},
//		                  {0,1,1,1,1,1,1,0,0,1},
//		                  {1,1,1,1,1,0,0,1,1,1},
//		                  {0,1,0,1,1,0,1,1,1,1},
//		                  {1,1,1,0,1,0,1,1,1,1}};


		int[][] res = updateMatrixBFS(matrix);
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
		
		res = updateMatrixDP(matrix);
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//We are doing BFS for every cell with value 1
	//Time complexity O((m * n) * (m * n)), m is no of rows, n is no of cols
	public static int[][] updateMatrixBFS(int[][] matrix) {
        if(matrix.length == 0) return matrix;
        int row = matrix.length, col = matrix[0].length;
        int res[][] = new int[row][col];
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
            	if(matrix[r][c] != 0) {
            		res[r][c] = findNearestZeroBFS(matrix, r, c, 0);
            	}
            }
        }
        return res;
    }
    
    public static int findNearestZeroBFS(int[][] matrix, int r, int c, int dist){
        if(r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length) {
        	return Integer.MAX_VALUE;
        }
        if(matrix[r][c] == -1) return Integer.MAX_VALUE;
        
        if(matrix[r][c] == 0){
        	return dist;    
        }
        int prev = matrix[r][c];
        matrix[r][c] = -1; 
        int top = findNearestZeroBFS(matrix, r - 1, c, dist + 1);
        int right = findNearestZeroBFS(matrix, r , c + 1, dist + 1);
        int bottom = findNearestZeroBFS(matrix, r + 1, c, dist + 1);
        int left = findNearestZeroBFS(matrix, r , c - 1, dist + 1);
        matrix[r][c] = prev;
        return Math.min(Math.min(top, right), Math.min(bottom, left));
    }
    
    
    //We are using Dynamic programming
  	//Time complexity O((m * n) * 2), m is no of rows, n is no of cols
    public static int[][] updateMatrixDP(int[][] matrix) {
        if(matrix.length == 0) return matrix;
        int rows = matrix.length, cols = matrix[0].length;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(matrix[r][c] == 1){
                    matrix[r][c] = Integer.MAX_VALUE;
                }    
            }
        }
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(matrix[r][c] != Integer.MAX_VALUE){
                    int curDist = matrix[r][c];
                    findAdjecentDistance(matrix, r - 1, c, curDist);
                    findAdjecentDistance(matrix, r, c + 1, curDist);
                    findAdjecentDistance(matrix, r + 1, c, curDist);
                    findAdjecentDistance(matrix, r, c - 1, curDist);   
                }
            }
        }
        
        for(int r = rows - 1; r >= 0; r--){
            for(int c = cols - 1; c >= 0; c--){
                if(matrix[r][c] != Integer.MAX_VALUE){
                    int curDist = matrix[r][c];
                    findAdjecentDistance(matrix, r - 1, c, curDist);
                    findAdjecentDistance(matrix, r, c + 1, curDist);
                    findAdjecentDistance(matrix, r + 1, c, curDist);
                    findAdjecentDistance(matrix, r, c - 1, curDist);   
                }
            }
        }
        return matrix;
    }
    
    public static void findAdjecentDistance(int[][] matrix, int r, int c, int curDist){
        if(r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length) return;
        if(matrix[r][c] == 0) return;
        int distanceFromCur = curDist + 1;
        if(distanceFromCur < matrix[r][c]){
            matrix[r][c] = distanceFromCur;
        }
    }
	
}
