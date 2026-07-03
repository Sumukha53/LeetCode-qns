class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[]=new boolean[rooms.size()];
        dfs(rooms,0,vis);
        for(boolean i:vis)if(!i)return i;
        return true; 
    }
    private void dfs(List<List<Integer>>adj,int node,boolean[] vis){
        if(vis[node])return;
        vis[node]=true;
        for(Integer i:adj.get(node)){
            dfs(adj,i,vis);
        }
        return;
    }
}