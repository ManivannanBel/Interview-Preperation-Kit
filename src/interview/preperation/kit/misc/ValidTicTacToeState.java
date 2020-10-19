package interview.preperation.kit.misc;

public class ValidTicTacToeState {
	public static void main(String args[]) {
		String board[] = {"XOX","O O","XOX"};
		System.out.println(validTicTacToe(board));
		String board2[] = {"XOX","X X","XOX"};
		System.out.println(validTicTacToe(board2));
	}
	
	public static boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i].charAt(j) == 'X'){
                    xCount++;
                }
                if(board[i].charAt(j) == 'O'){
                    oCount++;
                }
            }
        }
        
        if(xCount == oCount || xCount - 1 == oCount){
            if(checkValid(board, 'O')){
                if(checkValid(board, 'X')){
                    return false;
                }
                return xCount == oCount;
            }
            
            if(checkValid(board, 'X') && xCount == oCount) return false;
            
            return true;
        }
        return false;
	        
	}
    
    public static boolean checkValid(String[] board, char c){
        
        for(int i = 0; i < 3; i++){
            if(board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) return true;
        }
        
        for(int i = 0; i < 3; i++){
            if(board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c ) return true;
        }
        
        if(board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c ) return true;
        
        if(board[2].charAt(0) == c && board[1].charAt(1) == c && board[0].charAt(2) == c ) return true;
        
        return false;
    }
}
