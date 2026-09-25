class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        ans=new ArrayList<>();
        for(int i=1;i<10;i++)dfs(n,1,k,i,i);
        int[] res=new int[ans.size()];
        int ind=0;
        for(int i:ans)res[ind++]=i;
        return res;
    }
    List<Integer>ans;
    private void dfs(int n,int cnt,int k,int num,int prev){
        if(cnt>n || prev<0 || prev>9)return;
        if(cnt==n){
            ans.add(num);
            return;
        }
        dfs(n,cnt+1,k,num*10+(prev+k),prev+k);
        if(k!=0)dfs(n,cnt+1,k,num*10+(prev-k),prev-k);
        
    }
}