package org.pilgrim.leetcode.y2020.facebook;

public class SearchWord {
	
static int[][] d = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    
    public boolean exist(char[][] board, String word) {
        if(board == null){
            return false;
        }
        
        int n = board.length;
        int m = board[0].length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){                
                if(track(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean track(char[][] board, String word, int w, int r, int c){
        if(w >= word.length()){
            return true;
        }
        
        int n = board.length;
        int m = board[0].length;
        
        if(r < 0 || r >= n){
            return false;
        }
        
        if(c < 0 || c >= m){
            return false;
        }
        
        if(word.charAt(w) != board[r][c]){
            return false;
        }
        
        board[r][c] = '@';
        
        boolean res = false;
        
        for(int k=0; k<d.length; k++){
            res = track(board, word, w + 1, r + d[k][0], c + d[k][1]);
            if(res){
                break;
            }
        }
        
        board[r][c] = word.charAt(w);
        
        return res;
    }

	public static void main(String[] args) {
		char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		
		SearchWord searchWord = new SearchWord();
		System.out.println(searchWord.exist(board, word));

	}
}
