class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length,m=board[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0) && exist(board,word,i,j,0,vis))return true;
            }
        }
        return false;
    }
    private boolean isValid(char[][] board,int i,int j){
        return !(i<0 || j<0 || j==board[0].length || i==board.length);
    }
    private boolean exist(char[][] board,String w,int i,int j,int k,boolean[][] vis){
        if(k==w.length()-1 && isValid(board,i,j) && w.charAt(k)==board[i][j] && !vis[i][j])return true;
        if(!isValid(board,i,j) || vis[i][j] || board[i][j]!=w.charAt(k))return false;
        vis[i][j]=true;
        boolean ans=exist(board,w,i+1,j,k+1,vis)||exist(board,w,i-1,j,k+1,vis)||exist(board,w,i,j+1,k+1,vis)||exist(board,w,i,j-1,k+1,vis);
        vis[i][j]=false;
        return ans;
    }
}