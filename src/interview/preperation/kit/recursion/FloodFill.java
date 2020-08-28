package interview.preperation.kit.recursion;

public class FloodFill {
	int mat[][];
	void floodFill(int row, int col, int target, int value) {
		if(row < 0 || row > mat.length || col < 0 || col > mat[0].length) return;
		
		if(mat[row][col] == target) {
			mat[row][col] = value;
			floodFill(row - 1, col, target, value);
			floodFill(row + 1, col, target, value);
			floodFill(row, col - 1, target, value);
			floodFill(row, col + 1, target, value);
		}
	}
	
	public static void main(String args[]) {
		FloodFill ff = new FloodFill();
		ff.mat = new int[][] {{1,1,1,1,1,1},
					   {1,0,0,1,0,1},
					   {1,1,0,0,0,1},
					   {1,1,0,1,1,1},
					   {1,0,0,0,1,1},
					   {1,1,1,1,1,1}};
		
		ff.floodFill(1, 2, 0, 2);
		for(int i = 0; i < ff.mat.length; i++) {
			for(int j = 0; j < ff.mat[0].length; j++) {
				System.out.print(ff.mat[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
