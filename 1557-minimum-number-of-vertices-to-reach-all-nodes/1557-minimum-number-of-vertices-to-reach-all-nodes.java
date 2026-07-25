class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        HashSet<Integer>s1=new HashSet<>();
        HashSet<Integer>s2=new HashSet<>();
        for(List<Integer>e:edges){
            if(!s2.contains(e.get(0)))s1.add(e.get(0));
            s2.add(e.get(1));
            if(s2.contains(e.get(1)) && s1.contains(e.get(1)))s1.remove(e.get(1));
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(s1.contains(i))ans.add(i);
        }
        return ans;
    }
}