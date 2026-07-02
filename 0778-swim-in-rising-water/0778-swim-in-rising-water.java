class Solution {
    class Pair{
        int first,second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int swimInWater(int[][] grid) {
        int l=grid[0][0];
        int r=0;
        for(int[] i:grid)for(int j:i)r=Math.max(r,j);
        while(l<=r){
            int mid=(l+r)/2;
            if(bfs(grid,mid)){
                r=mid-1;
            }
            else l=mid+1;
        }
        return l;
    }
    private boolean bfs(int[][] grid,int lim){
        Queue<Pair>q=new LinkedList<>();
        int m=grid.length,n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        q.offer(new Pair(0,0));
        int[][] dir=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            Pair front=q.poll();
            int i=front.first,j=front.second;
            if(i==m-1 && j==n-1)return true;
            for(int[] d:dir){
                int ni=i+d[0],nj=j+d[1];
                if(ni>=0 && ni<m && nj>=0 && nj<n && !vis[ni][nj]){
                    vis[ni][nj]=true;
                    if(grid[ni][nj]<=lim)q.offer(new Pair(ni,nj));
                }
            }
        }
        return false;
    }
}