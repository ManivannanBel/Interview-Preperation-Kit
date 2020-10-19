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
        
        //Count Xs and Os
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
        
        //The no. of Xs should same as no. of Os or Xs should be one greater than Os.
        if(xCount == oCount || xCount - 1 == oCount){
        	//Check if any winning combination of Os exists.
            if(checkValid(board, 'O')){
            	//check if any winning combination of Xs exists, if then return false.
                if(checkValid(board, 'X')){
                    return false;
                }
                
                //in case of O winning, the no. of Xs and Ox should be same.
                return xCount == oCount;
            }
            
          //Check if any winning combination of Os exists.
          //in case of X winning, no. of Xs should be greater than no. of Os.  
          if(checkValid(board, 'X') && xCount == oCount) return false;
          
          //inCase X winning combination found or no. Xs greater than no. of Os
          return true;
        }
        return false;
	        
	}
    
    public static boolean checkValid(String[] board, char c){
        
    	//Check row wise
        for(int i = 0; i < 3; i++){
            if(board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) return true;
        }
        
        //Check column wise
        for(int i = 0; i < 3; i++){
            if(board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c ) return true;
        }
        
        //check diagonals
        if(board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c ) return true;
        if(board[2].charAt(0) == c && board[1].charAt(1) == c && board[0].charAt(2) == c ) return true;
        
        return false;
    }
}
