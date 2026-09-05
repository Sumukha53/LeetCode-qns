class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        valid=new int[n];
        ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(dfs(graph,i))ans.add(i);
        }
        return ans;
    }
    int[] valid;
    List<Integer>ans;
    private boolean dfs(int[][] g,int n){
        if(valid[n]==1)return false;
        if(valid[n]==2)return true;
        valid[n]=1;
        for(int nd:g[n]){
            if(!dfs(g,nd))return false;
        }
        valid[n]=2;
        return true;
    }
}