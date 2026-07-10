class Solution {
    class Pair{
        int node,time;
        Pair(int node,int time){
            this.node=node;
            this.time=time;
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            if(manager[i]!=-1)adj.get(manager[i]).add(i);
        }
        Queue<Pair>q=new LinkedList<>();
        int ans=0;
        q.add(new Pair(headID,informTime[headID]));
        while(!q.isEmpty()){
            Pair top=q.poll();
            int node=top.node,time=top.time;
            ans=Math.max(ans,time);
            for(Integer nod:adj.get(node)){
                q.add(new Pair(nod,time+informTime[nod]));
            }
        }
        return ans;
    }
}