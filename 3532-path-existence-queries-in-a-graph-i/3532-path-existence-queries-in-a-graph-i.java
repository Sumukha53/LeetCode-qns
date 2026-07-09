class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int grp_num=0;
        int i=0;
        HashMap<Integer,Integer>m=new HashMap<>();
        for(;i<n-1;i++){
            m.put(i,grp_num);
            if(Math.abs(nums[i]-nums[i+1])>maxDiff)grp_num++;
        }
        m.put(n-1,grp_num);
        boolean[] ans=new boolean[queries.length];
        int ind=0;
        for(int[] q:queries){
            ans[ind++]=(m.get(q[0]).equals(m.get(q[1])));
        }
        return ans;
    }
}