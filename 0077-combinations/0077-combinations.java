class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ans=new ArrayList<>();
        helper(1,n,k,new ArrayList<>());
        return ans;
    }
    List<List<Integer>>ans;
    private void helper(int i,int n,int k,List<Integer>t){
        if(t.size()==k){
            ans.add(new ArrayList<>(t));
            return;
        }
        for(int j=i;j<=n;j++){
            t.add(j);
            helper(j+1,n,k,t);
            t.remove(t.size()-1);
        }
        return;
    }
}