class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        k%=(m*n);
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<m;i++)ans.add(new ArrayList<>());
        for(int x=0;x<m*n;x++){
            ans.get(x/n).add(grid[((m*n-k+x)%(m*n))/n][((m*n-k+x)%(m*n))%n]);
        }
        return ans;
    }
}