class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length,m=heights[0].length;
        vis=new boolean[n][m];
        count=new int[n][m];
        for(int i=0;i<n;i++)dfs(heights,i,m-1);
        for(int j=0;j<m;j++)dfs(heights,n-1,j);
        for(boolean[] b:vis)Arrays.fill(b,false);
        for(int i=0;i<n;i++)dfs(heights,i,0);
        for(int j=0;j<m;j++)dfs(heights,0,j);

        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(count[i][j]==2){
                    List<Integer>temp=new ArrayList<>();
                    temp.add(i);temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
    boolean[][] vis;
    int[][] count;
    int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private boolean isValid(int[][] h,int i,int j){
        return i>=0 && j>=0 && i<h.length && j<h[0].length;
    }
    private void dfs(int[][] h,int i,int j){
        if(!isValid(h,i,j) || vis[i][j])return;
        vis[i][j]=true;
        count[i][j]++;
        for(int d=0;d<4;d++){
            int ni=dir[d][0]+i,nj=dir[d][1]+j;
            if(isValid(h,ni,nj) && h[i][j]<=h[ni][nj] && !vis[ni][nj]){
                dfs(h,ni,nj);
            }
        }
    }
}