class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp=new int[prices.length+1][2*k+2];
        for(int i=prices.length-1;i>=0;i--){
            for(int trans=2*k;trans>=0;trans--){
                if(trans%2==0){
                    int pick=dp[i+1][trans+1]-prices[i];
                    int skip=dp[i+1][trans];
                    dp[i][trans]=Math.max(pick,skip);
                }
                else{
                    int pick=dp[i+1][trans+1]+prices[i];
                    int skip=dp[i+1][trans];
                    dp[i][trans]=Math.max(pick,skip);
                }
            }
        }
        return dp[0][0];
    }
}