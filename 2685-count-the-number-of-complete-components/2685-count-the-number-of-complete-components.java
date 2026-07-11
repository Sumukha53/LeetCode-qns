class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] i:edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        boolean[] vis=new boolean[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                edg_c=0;
                node_c=0;
                dfs(adj,i,vis);
                if(node_c*(node_c-1)==edg_c)ans++;
                
            }
        }
        return ans;
    }
    int edg_c=0,node_c=0;
    private void dfs(List<List<Integer>>adj,int node,boolean[] vis){
        if(vis[node])return;
        vis[node]=true;
        node_c++;
        edg_c+=adj.get(node).size();
        for(Integer nod:adj.get(node)){
            dfs(adj,nod,vis);
        }
        return;
    }
}