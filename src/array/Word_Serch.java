package array;

public class Word_Serch {
	
	
	public boolean exist(char[][] board, String word) {
	    char c0 = word.charAt(0);
	    boolean [][]flag = new boolean[board.length][board[0].length];
	    
	    for(int i=0;i<board.length;i++){
	    	for(int j=0;j<board[0].length;j++){
	    		char c = board[i][j];
	    		if(c==c0){
	    			if(has_next(board,flag,word,1,i,j))
	    				return true;
	    			flag[i][j]=false;
	    		}
	    	}
	    }
	    
		return false;
	}
	
	
	private boolean has_next(char[][] board,boolean [][]flag,String word,int word_index,int i,int j){
	
	    int hang = board.length; int lie = board[0].length;
		flag[i][j]=true;
		if(word_index>=word.length())
			return true;
		
		char c1 = word.charAt(word_index);
		if(i-1>=0&&c1==board[i-1][j]&&flag[i-1][j]!=true){//up
			if(has_next(board, flag, word,word_index+1, i-1, j))
				return true;
			flag[i-1][j]=false;
		}
		if(j-1>=0&&c1==board[i][j-1]&&flag[i][j-1]!=true){//left
			if(has_next(board, flag, word,word_index+1, i, j-1))
				return true;
			flag[i][j-1]=false;
		}
		if(i+1<hang&&c1==board[i+1][j]&&flag[i+1][j]!=true){//down
			if(has_next(board, flag, word,word_index+1, i+1, j))
				return true;
			flag[i+1][j]=false;
		}
		if(j+1<lie&&c1==board[i][j+1]&&flag[i][j+1]!=true){//right
			if(has_next(board, flag, word,word_index+1, i, j+1))
				return true;
			flag[i][j+1]=false;
		}
		
		return false;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char a = 'a';
		a^=256;
		a^=256;
		System.out.println(a);
//		char[][] c={{'c','a','a'},{'a','a','a'},{'b','c','d'}};
//		Word_Serch word_Serch = new Word_Serch();
//		System.out.println(word_Serch.exist(c, "aab"));
		
	}

}
