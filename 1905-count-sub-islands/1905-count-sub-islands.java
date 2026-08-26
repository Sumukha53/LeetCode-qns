class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n=grid1.length,m=grid1[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j]==1 && grid1[i][j]==0){
                    dfs(grid2,i,j);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j]==1){
                    ans++;
                    dfs(grid2,i,j);
                }
            }
        }
        return ans;
    }
    int[][] dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    private boolean isValid(int[][] g1,int i,int j){
        return i>=0 && i<g1.length && j>=0 && j<g1[0].length;
    }
    private void dfs(int[][] g2,int i,int j){
        if(!isValid(g2,i,j) || g2[i][j]==0)return;
        g2[i][j]=0;
        for(int d=0;d<4;d++){
            int ni=i+dir[d][0],nj=j+dir[d][1];
            if(isValid(g2,ni,nj))
            dfs(g2,ni,nj);
        }
    }
    
}