class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][3];
        for(int[] i:dp)Arrays.fill(i,-1);
        return helper(prices,0,0,dp);
    }
    private int helper(int[] prices,int i,int k,int[][] dp){
        if(i==prices.length)return 0;
        if(dp[i][k]!=-1)return dp[i][k];
        if(k==1 || k==0){
            int take=helper(prices,i+1,2,dp)-prices[i];
            int skip=helper(prices,i+1,k,dp);
            return dp[i][k]=Math.max(take,skip);
        }
        else{
            int take=helper(prices,i+1,1,dp)+prices[i];
            int skip=helper(prices,i+1,k,dp);
            return dp[i][k]=Math.max(take,skip);
        }
    }
}