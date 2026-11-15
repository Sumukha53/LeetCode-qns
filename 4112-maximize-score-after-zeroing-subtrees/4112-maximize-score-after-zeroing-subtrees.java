class Solution {
    public int maxScore(int[] parent, int[] op, int[] score) {
        p=parent;
        sc=score;
        o=op;
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<parent.length;i++)adj.add(new ArrayList<>());
        for(int i=1;i<parent.length;i++){
            adj.get(parent[i]).add(i);
        }
        return dfs(adj,0);
    }
    int[] p,sc,o;
    private int dfs(List<List<Integer>>adj,int nd){
        if(adj.get(nd).size()==0)return sc[nd];
        int mn=Integer.MAX_VALUE;
        int sum=sc[nd];
        for(int n:adj.get(nd)){
            int val=dfs(adj,n);
            sum+=val;
            mn=Math.min(mn,val);
        }
        if(o[nd]==0 && mn<0)return sum-mn;
        else if(o[nd]==1)return sum-mn;
        return sum;
    }
}