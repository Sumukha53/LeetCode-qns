class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp=new int[prices.length][2*k+1];
        for(int[] i:dp)Arrays.fill(i,-1);
        return helper(prices,0,2*k,dp);
    }
    private int helper(int[] prices,int i,int trans,int[][] dp){
        if(i==prices.length || trans==0)return 0;
        if(dp[i][trans]!=-1)return dp[i][trans];
        if(trans%2==0){
            int pick=helper(prices,i+1,trans-1,dp)-prices[i];
            int skip=helper(prices,i+1,trans,dp);
            return dp[i][trans]=Math.max(pick,skip);
        }
        else{
            int pick=helper(prices,i+1,trans-1,dp)+prices[i];
            int skip=helper(prices,i+1,trans,dp);
            return dp[i][trans]=Math.max(pick,skip);
        }
    }
}