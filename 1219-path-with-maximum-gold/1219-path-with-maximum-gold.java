class Solution {
    public int getMaximumGold(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        vis=new boolean[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(boolean[] b:vis)Arrays.fill(b,false);
                if(grid[i][j]!=0){
                    ans=Math.max(ans,dfs(grid,i,j));
                }
            }
        }
        return ans;
    }
    boolean[][] vis;
    private int dfs(int[][] g,int i,int j){
        if(i<0 ||j<0 ||i==g.length||j==g[0].length || vis[i][j] || g[i][j]==0)return 0;
        vis[i][j]=true;
        int ans=g[i][j]+Math.max(dfs(g,i+1,j),Math.max(dfs(g,i-1,j),Math.max(dfs(g,i,j+1),dfs(g,i,j-1))));
        vis[i][j]=false;
        return ans;

    }
}