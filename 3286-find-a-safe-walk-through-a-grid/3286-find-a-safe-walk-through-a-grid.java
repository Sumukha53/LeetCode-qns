class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        n=grid.size();m=grid.get(0).size();
        dp=new int[n][m][health+1];
        curr_path=new boolean[n][m][health+1];
        for(int[][] i:dp)for(int[] j:i)Arrays.fill(j,-1);
        return helper(grid,0,0,health);
    }
    int m=0,n=0;
    int[][][] dp;
    boolean[][][] curr_path;
    private boolean helper(List<List<Integer>>g,int i,int j,int h){
        if(i==n || j==m || h==0 ||i<0 ||j<0)return false;
        if(i==n-1 && j==m-1){
            return h-g.get(i).get(j)>=1;
        }
        if(curr_path[i][j][h])return false;
        if(dp[i][j][h]!=-1)return dp[i][j][h]==1;
        curr_path[i][j][h]=true;
        if(g.get(i).get(j)==1){
            boolean p1=helper(g,i+1,j,h-1);
            boolean p2=helper(g,i-1,j,h-1);
            boolean p3=helper(g,i,j+1,h-1);
            boolean p4=helper(g,i,j-1,h-1);
            dp[i][j][h]=(p1||p2||p3||p4)?1:0;
            curr_path[i][j][h]=false;
            return p1||p2||p3||p4;
        }
        else{
            boolean p1=helper(g,i+1,j,h);
            boolean p2=helper(g,i-1,j,h);
            boolean p3=helper(g,i,j+1,h);
            boolean p4=helper(g,i,j-1,h);
            dp[i][j][h]=(p1||p2||p3||p4)?1:0;
            curr_path[i][j][h]=false;
            return p1||p2||p3||p4;
        }
        
    }
}