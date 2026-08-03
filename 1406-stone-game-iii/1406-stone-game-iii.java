class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        int[] dp=new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int ans=helper(stoneValue,0,n,dp);
        return ans>0?"Alice":(ans==0?"Tie":"Bob");
    }
    private int helper(int[] s,int i,int n,int[] dp){
        if(i>=n)return 0;
        if(dp[i]!=Integer.MIN_VALUE)return dp[i];
        int mx_diff=Integer.MIN_VALUE;
        int sm=0;
        for(int j=i;j<i+3 && j<n;j++){
            sm+=s[j];
            mx_diff=Math.max(sm-helper(s,j+1,n,dp),mx_diff);
        }
        return dp[i]=mx_diff;
    }
}