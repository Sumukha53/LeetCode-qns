class Solution {
    class Tri{
        int i,j,val;
        Tri(int i,int j,int val){
            this.i=i;
            this.j=j;
            this.val=val;
        }
    }
    public int[][] highestPeak(int[][] isW) {
        int m=isW.length,n=isW[0].length;
        int[][] ans=new int[m][n];
        int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<Tri>q=new LinkedList<>();
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isW[i][j]==0 && ((i>0 && isW[i-1][j]==1)||(i<m-1 && isW[i+1][j]==1)||(j>0 && isW[i][j-1]==1)||(j<n-1 && isW[i][j+1]==1))){
                    vis[i][j]=true;
                    q.offer(new Tri(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            int qz=q.size();
            while(qz-->0){
                Tri peek=q.poll();
                int i=peek.i,j=peek.j,val=peek.val;
                ans[i][j]=val+1;
                for(int d=0;d<4;d++){
                    int ni=i+dir[d][0],nj=j+dir[d][1];
                    if(isValid(isW,ni,nj) && isW[ni][nj]==0 && !vis[ni][nj]){
                        q.offer(new Tri(ni,nj,val+1));
                        vis[ni][nj]=true;
                    }
                }
            }
        }
        return ans;
    }
    private boolean isValid(int[][] isW,int i,int j){
        return i>=0 && j>=0 && i<isW.length && j<isW[0].length;
    }
}