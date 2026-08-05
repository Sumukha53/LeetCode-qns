class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] e:invocations)adj.get(e[0]).add(e[1]);
        int[] sus=new int[n];
        dfs(adj,k,sus);
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i] && sus[i]==0){
                dfs(adj,i,sus,vis);
            }
        }
        List<Integer>ans=new ArrayList<>();
        if(not_sus){
            for(int i=0;i<n;i++)ans.add(i);
            return ans;
        }
        for(int i=0;i<n;i++)if(sus[i]==0)ans.add(i);
        return ans;
    }
    boolean not_sus=false;
    private void dfs(List<List<Integer>>adj,int node,int[] sus,boolean[] vis){
        if(vis[node])return;
        if(sus[node]==1){not_sus=true;return;}
        vis[node]=true;
        for(Integer n:adj.get(node)){
            dfs(adj,n,sus,vis);
        }
        return;
    }
    private void dfs(List<List<Integer>>adj,int node,int[] sus){
        if(sus[node]==1)return;
        sus[node]=1;
        for(Integer n:adj.get(node)){
            dfs(adj,n,sus);
        }
        return;
    }
}