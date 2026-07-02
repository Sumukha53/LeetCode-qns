class Solution {
    class Triplet{
        int w,i,j;
        Triplet(int w,int i,int j){
            this.w=w;
            this.i=i;
            this.j=j;
        }
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        PriorityQueue<Triplet>pq=new PriorityQueue<>(
            (a,b)->Integer.compare(a.w,b.w)
        );
        pq.offer(new Triplet(grid[0][0],0,0));
        int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int[][] dist=new int[n][m];
        for(int[] i:dist)Arrays.fill(i,Integer.MAX_VALUE);
        dist[0][0]=grid[0][0];
        while(!pq.isEmpty()){
            Triplet top=pq.poll();
            int wei=top.w,i=top.i,j=top.j;
            if(dist[i][j]<wei)continue;
            for(int[] d:dir){
                int ni=i+d[0],nj=j+d[1];
                if(ni>=0 && ni<n && nj>=0 && nj<m){
                    int mx=Math.max(dist[i][j],grid[ni][nj]);
                    System.out.println(mx);
                    if(dist[ni][nj]>mx){
                    pq.offer(new Triplet(mx,ni,nj));
                    dist[ni][nj]=mx;}
                }
            }
        }
        return dist[n-1][m-1];

    }
    
}