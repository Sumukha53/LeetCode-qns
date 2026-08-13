class Solution {
    List<List<Integer>>l;
    private void comb(int[] c,int i,int n,int t,List<Integer>tem){
        if(t==0){
            l.add(new ArrayList<>(tem));
            return;
        }
        if(i==n)return;
        for(int j=i;j<n;j++){
            if(j>i && c[j]==c[j-1])continue;
            if(c[j]>t)return;
            tem.add(c[j]);
            comb(c,j+1,n,t-c[j],tem);
            tem.remove(tem.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n=candidates.length;
        l=new ArrayList<>();
        List<Integer>tem=new ArrayList<>();
        comb(candidates,0,n,target,tem);
        return l;
    }
}