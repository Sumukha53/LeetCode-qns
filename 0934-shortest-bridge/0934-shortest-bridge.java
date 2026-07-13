class Solution {
    class Triplet{
        int i,j,d;
        Triplet(int i,int j,int d){
            this.i=i;
            this.j=j;
            this.d=d;
        }
    }
    public int shortestBridge(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Triplet>q=new LinkedList<>();
        boolean[][] vis=new boolean[n][m];
        int di=0,dj=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    di=i;dj=j;i=n;j=m;
                }
            }
        }
        q.offer(new Triplet(di,dj,0));
        while(!q.isEmpty()){
            int sz=q.size();
            while(sz-->0){
                Triplet top=q.poll();
                int i=top.i,j=top.j;
                vis[i][j]=true;
                    if(valid(i+1,j,n,m) && grid[i+1][j]==1 && !vis[i+1][j]){q.offer(new Triplet(i+1,j,1));vis[i+1][j]=true;}
                    if(valid(i-1,j,n,m) && grid[i-1][j]==1 && !vis[i-1][j]){q.offer(new Triplet(i-1,j,1));vis[i-1][j]=true;}
                    if(valid(i,j+1,n,m)&& grid[i][j+1]==1 && !vis[i][j+1]){q.offer(new Triplet(i,j+1,1));vis[i][j+1]=true;}
                    if(valid(i,j-1,n,m) && grid[i][j-1]==1 && !vis[i][j-1]){q.offer(new Triplet(i,j-1,1));vis[i][j-1]=true;}
            }
        }
        q.clear();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]){
                    if(valid(i+1,j,n,m) && grid[i+1][j]==0)q.offer(new Triplet(i+1,j,1));
                    if(valid(i-1,j,n,m) && grid[i-1][j]==0)q.offer(new Triplet(i-1,j,1));
                    if(valid(i,j+1,n,m)&& grid[i][j+1]==0)q.offer(new Triplet(i,j+1,1));
                    if(valid(i,j-1,n,m) && grid[i][j-1]==0)q.offer(new Triplet(i,j-1,1));
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int sz=q.size();
            while(sz-->0){
                Triplet top=q.poll();
                int i=top.i,j=top.j,d=top.d;
                vis[i][j]=true;
                if(((valid(i+1,j,n,m) && grid[i+1][j]==1 && !vis[i+1][j]) || (valid(i-1,j,n,m) && grid[i-1][j]==1 && !vis[i-1][j]) || (valid(i,j+1,n,m) && grid[i][j+1]==1 && !vis[i][j+1]) || (valid(i,j-1,n,m) && grid[i][j-1]==1 && !vis[i][j-1]))){
                    ans=Math.min(ans,d);
                }
                    if(valid(i+1,j,n,m) && grid[i+1][j]==0 && !vis[i+1][j]){q.offer(new Triplet(i+1,j,1+d));vis[i+1][j]=true;}
                    if(valid(i-1,j,n,m) && grid[i-1][j]==0 && !vis[i-1][j]){q.offer(new Triplet(i-1,j,1+d));vis[i-1][j]=true;}
                    if(valid(i,j+1,n,m)&& grid[i][j+1]==0 && !vis[i][j+1]){q.offer(new Triplet(i,j+1,1+d));vis[i][j+1]=true;}
                    if(valid(i,j-1,n,m) && grid[i][j-1]==0 && !vis[i][j-1]){q.offer(new Triplet(i,j-1,1+d));vis[i][j-1]=true;}
            }
        }
        return ans;
    }
    private boolean valid(int i,int j,int n,int m){
        return i<n && i>=0 && j<m && j>=0;
    }
}