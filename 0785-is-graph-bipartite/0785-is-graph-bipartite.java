class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                dfs(graph,i,1,color);
            }
            if(!ans)return false;
        }
        return ans;
    }
    boolean ans=true;
    private void dfs(int[][] graph,int node,int col,int[] color){
        if(!ans)return;
        if(color[node]!=-1){
            if(col!=color[node])ans=false;
            return;
        }
        color[node]=col;
        for(int i:graph[node]){
            dfs(graph,i,1-col,color);
        }
        return;
    }
}