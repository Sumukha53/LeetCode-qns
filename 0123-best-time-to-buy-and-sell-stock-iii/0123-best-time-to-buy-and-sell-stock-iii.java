class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][5];
        for(int[] i:dp)Arrays.fill(i,-1);
        return helper(prices,prices.length,0,4,dp);
    }
    private int helper(int[] prices,int n,int i,int trans,int[][] dp){
        if(i==n || trans==0)return 0;
        if(dp[i][trans]!=-1)return dp[i][trans];
        if(trans%2==0){
            int take=helper(prices,n,i+1,trans-1,dp)-prices[i];
            int skip=helper(prices,n,i+1,trans,dp);
            return dp[i][trans]=Math.max(take,skip);
        }
        else{
            int take=helper(prices,n,i+1,trans-1,dp)+prices[i];
            int skip=helper(prices,n,i+1,trans,dp);
            return dp[i][trans]=Math.max(take,skip);
        }
    }
}