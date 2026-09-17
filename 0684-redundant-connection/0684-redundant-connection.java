class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        for(int i=1;i<=n;i++)parent[i]=i;
        for(int[] e:edges){
            if(find(e[0])==find(e[1]))return e;
            union(e[0],e[1]);
        }
        return new int[2];
    }
    int[] parent;
    private int find(int n){
        return parent[n]==n?n:(parent[n]=find(parent[n]));
    }
    private void union(int n1,int n2){
        int n1p=find(n1);
        int n2p=find(n2);
        parent[n2p]=n1p;
    }
}