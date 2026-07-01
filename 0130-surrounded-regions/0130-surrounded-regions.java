class Solution {
    class Pair{
        int first,second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public void solve(char[][] board) {
        Queue<Pair>q=new LinkedList<>();
        int m=board.length,n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1)if(board[i][j]=='O'){q.offer(new Pair(i,j));board[i][j]='Z';}
            }
        }
        int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int sz=q.size();
            while(sz-->0){
                Pair temp=q.poll();
                int i=temp.first,j=temp.second;
                for(int d=0;d<4;d++){
                    int ni=i+dir[d][0],nj=j+dir[d][1];
                    if(ni>=0 && ni<m && nj>=0 && nj<n && board[ni][nj]=='O'){
                        q.offer(new Pair(ni,nj));
                        board[ni][nj]='Z';
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='Z')board[i][j]='O';
                else if(board[i][j]=='O')board[i][j]='X';
            }
        }
        return;
    }
}