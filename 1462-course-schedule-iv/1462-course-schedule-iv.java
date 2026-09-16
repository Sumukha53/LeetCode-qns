class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        HashSet<Integer>[] all=new HashSet[n];
        int[] indegree=new int[n];
        Queue<Integer>q=new LinkedList<>();
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
        all[i]=new HashSet<>();
        }
        for(int[] p:prerequisites){
            indegree[p[1]]++;
            adj.get(p[0]).add(p[1]);
            all[p[1]].add(p[0]);
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==0)q.offer(i);
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int node:adj.get(curr)){
                for(int j:all[curr]){
                    all[node].add(j);
                }
                indegree[node]--;
                if(indegree[node]==0)q.offer(node);
            }
        }
        List<Boolean>ans=new ArrayList<>();
        for(int[] qr:queries){
            ans.add(all[qr[1]].contains(qr[0]));
        }
        return ans;
    }
}