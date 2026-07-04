class Solution {
    int ans=Integer.MAX_VALUE;
    class Pair{
        int first,second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int minScore(int n, int[][] roads) {
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
        for(int[] i:roads){
            adj.get(i[0]).add(new Pair(i[1],i[2]));
            adj.get(i[1]).add(new Pair(i[0],i[2]));
        }
        boolean[] vis=new boolean[n+1];
        dfs(adj,1,vis);
        return ans;
    }
    private void dfs(List<List<Pair>> adj,int node,boolean[] vis){
        if(vis[node])return;
        vis[node]=true;
        for(Pair p:adj.get(node)){
            ans=Math.min(ans,p.second);
            dfs(adj,p.first,vis);
        }
        return;
    }
}