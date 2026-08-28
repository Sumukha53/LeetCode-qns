class Solution {
    public int countIslands(int[][] grid, int k) {
        int n=grid.length,m=grid[0].length;
        int ans=0;
        k_=k;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0){
                    sum=0;
                    dfs(grid,i,j);
                    if(sum%k==0)ans++;
                }
            }
        }
        return ans;
    }
    int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private boolean isValid(int[][] grid,int i,int j){
        return i>=0 && j>=0 && i<grid.length && j<grid[0].length;
    }
    int sum=0;
    int k_=0;
    private void dfs(int[][] grid,int i,int j){
        if(!isValid(grid,i,j) || grid[i][j]<=0)return;
        sum=(grid[i][j]+sum)%k_;
        grid[i][j]*=-1;
        for(int d=0;d<4;d++){
            int ni=i+dir[d][0],nj=j+dir[d][1];
            dfs(grid,ni,nj);
        }
    }
}