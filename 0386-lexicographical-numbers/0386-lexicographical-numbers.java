class Solution {
    public List<Integer> lexicalOrder(int n) {
        ans=new ArrayList<>();
        for(int i=1;i<10;i++)dfs(n,i);
        return ans;
    }
    List<Integer>ans;
    private void dfs(int n,int k){
        if(k<=n){
            ans.add(k);
        }
        if(k>n)return;
        for(int i=0;i<=9;i++){
            k=k*10+i;
            dfs(n,k);
            k/=10;
        }
    }
}