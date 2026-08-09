class Solution {
    class Tri{
        int node,w,d;
        Tri(int node,int w,int d){
            this.node=node;
            this.w=w;
            this.d=d;
        }
    }
    public long weightedSum(int[] parent, int[] nums) {
        int n=parent.length;
        List<List<Tri>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=1;i<n;i++){
            adj.get(parent[i]).add(new Tri(i,nums[i],0));
        }
        height=dfs(adj,0,1)+1;
        dfs(adj,0);
        ans+=(long)(nums[0])*(long)(height);
        return ans;

    }
    int height;
    private int dfs(List<List<Tri>>adj,int node,int d){
        int ans=0;
        for(Tri t:adj.get(node)){
            t.d=d+1;
            ans=Math.max(ans,1+dfs(adj,t.node,d+1));
        }
        return ans;
    }
    long ans=0;
    private void dfs(List<List<Tri>>adj,int node){
        for(Tri t:adj.get(node)){
            ans+=(long)(t.w)*(long)(height-t.d+1);
            dfs(adj,t.node);
        }
    }
}