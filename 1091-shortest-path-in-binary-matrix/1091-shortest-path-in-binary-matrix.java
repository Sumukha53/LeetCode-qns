class Solution {
    int[][] dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
    class Tri{
        int i,j,d;
        Tri(int i,int j,int d){
            this.i=i;
            this.j=j;
            this.d=d;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        if(grid[0][0]==1 || grid[n-1][m-1]==1)return -1;
        Queue<Tri>q=new LinkedList<>();
        boolean[][] vis=new boolean[n][m];
        q.offer(new Tri(0,0,0));
        while(!q.isEmpty()){
            int sz=q.size();
            while(sz-->0){
                Tri top=q.poll();
                int i=top.i,j=top.j,d=top.d;
                if(i==n-1 && j==m-1)return ++d;
                for(int di=0;di<8;di++){
                    int ni=i+dir[di][0],nj=j+dir[di][1];
                    if(ni>=0 && ni<n && nj>=0 && nj<m && grid[ni][nj]==0 && !vis[ni][nj]){
                        vis[ni][nj]=true;
                        q.offer(new Tri(ni,nj,d+1));
                    }
                }
            }
        }
        return -1;

    }
}