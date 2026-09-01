class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        if(m==1 && n==1)return false;
        vis=new boolean[m][n];
        boolean t=dfs(grid,0,1)||dfs(grid,1,0);
        return !(dfs(grid,0,1)||dfs(grid,1,0));
    }
    boolean[][] vis;
    int[][] dir=new int[][]{{0,1},{1,0}};
    private boolean isValid(int[][] g,int i,int j){
        return i>=0&& j>=0 && i<g.length && j<g[0].length;
    }
    private boolean dfs(int[][] g,int i,int j){
        if(!isValid(g,i,j))return false;
        if(g[i][j]==0 || vis[i][j])return false;
        if(i==g.length-1 && j==g[0].length-1)return true;
        g[i][j]=0;
        vis[i][j]=true;
        for(int d=0;d<2;d++){
            int ni=i+dir[d][0],nj=j+dir[d][1];
            if(isValid(g,ni,nj) && g[ni][nj]==1 && dfs(g,ni,nj)){
                return true;
            }
        }
        g[i][j]=1;
        return false;
    }
}