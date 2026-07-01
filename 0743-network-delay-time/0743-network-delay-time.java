class Solution {
    class Pair{
        int n,w;
        Pair(int w,int n){
            this.n=n;
            this.w=w;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i:times){
            adj.get(i[0]).add(new Pair(i[2],i[1]));
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<Pair>pq=new PriorityQueue<>(
            (a,b)->Integer.compare(a.w,b.w)
        );
        pq.offer(new Pair(0,k));
        int ans=-1;
        while(!pq.isEmpty()){
            Pair top=pq.poll();
            int node=top.n,wei=top.w;
            if(wei>dist[node])continue;
            ans=Math.max(ans,wei);
            for(Pair i:adj.get(node)){
                if(wei+i.w<dist[i.n]){
                    pq.offer(new Pair(wei+i.w,i.n));
                    dist[i.n]=wei+i.w;
                }
            }
        }
        for(int i=1;i<=n;i++)if(dist[i]==Integer.MAX_VALUE)return -1;
        return ans;
    }
}