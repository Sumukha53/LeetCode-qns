class Solution {
    public int closedIsland(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==0)dfs(grid,i,j);
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    ans++;
                    dfs(grid,i,j);
                }
            }
        }
        return ans;
    }
    int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    private boolean isValid(int[][] g,int i,int j){
        return i>=0 && j>=0 && i<g.length && j<g[0].length;
    }
    private void dfs(int[][] g,int i,int j){
        if(!isValid(g,i,j) || g[i][j]==1)return;
        g[i][j]=1;
        for(int d=0;d<4;d++){
            int ni=dir[d][0]+i,nj=dir[d][1]+j;
            dfs(g,ni,nj);
        }
    }
}