class Solution {
    int[][] dist;
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        dist=new int[n][m];
        int ans=0;
        dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dist[i][j]==0){
                    int d=dfs(matrix,i,j,n,m);
                    ans=Math.max(ans,d);
                }
            }
        }
        return ++ans;
    }
    int[][] dir;
    private int dfs(int[][] ma,int i,int j,int n,int m){
        if(dist[i][j]!=0)return dist[i][j];
        int len=0;
        for(int[] d:dir){
            int ni=i+d[0],nj=j+d[1];
            if(valid(ni,nj,n,m) && ma[ni][nj]>ma[i][j]){
                len=Math.max(len,1+dfs(ma,ni,nj,n,m));
            }
        }
        return dist[i][j]=len;
    }
    private boolean valid(int i,int j,int n,int m){
        return i>=0 && i<n && j>=0 && j<m;
    }
}