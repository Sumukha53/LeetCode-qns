class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] vis=new boolean[n];
        dfs(adj,source,destination,vis);
        return ans;

    }
    boolean ans=false;
    private void dfs(List<List<Integer>>adj,int node,int dst,boolean vis[]){
        if(node==dst){ans=true;return;}
        if(vis[node])return;
        vis[node]=true;
        for(Integer nd:adj.get(node)){
            dfs(adj,nd,dst,vis);
        }
        return;
    }
}