class Solution {
    class Triplet{
        int w,i,j;
        Triplet(int w,int i,int j){
            this.w=w;
            this.i=i;
            this.j=j;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length,m=heights[0].length;
        PriorityQueue<Triplet>pq=new PriorityQueue<>(
            (a,b)->Integer.compare(a.w,b.w)
        );
        int[][] dist=new int[n][m];
        for(int[] i:dist)Arrays.fill(i,Integer.MAX_VALUE);
        dist[0][0]=0;
        pq.offer(new Triplet(0,0,0));
        int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty()){
            Triplet top=pq.poll();
            int wei=top.w,i=top.i,j=top.j;
            for(int[] d:dir){
                int x=i+d[0],y=j+d[1];
                if(x>=0 && x<n && y>=0 && y<m){
                    if(wei>dist[x][y])continue;
                    int mx=Math.max(wei,Math.abs(heights[x][y]-heights[i][j]));
                    if(mx<dist[x][y]){
                        dist[x][y]=mx;
                        pq.offer(new Triplet(dist[x][y],x,y));
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}