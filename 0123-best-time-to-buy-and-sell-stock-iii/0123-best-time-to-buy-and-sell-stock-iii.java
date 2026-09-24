class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length+1][5];
        int n=prices.length;
        for(int i=n-1;i>=0;i--){
            for(int trans=4;trans>0;trans--){
                if(trans%2==0){
                    int take=dp[i+1][trans-1]-prices[i];
                    int skip=dp[i+1][trans];
                    dp[i][trans]=Math.max(take,skip);
            }
                else{
                    int take=dp[i+1][trans-1]+prices[i];
                    int skip=dp[i+1][trans];
                    dp[i][trans]=Math.max(take,skip);
            }
            }
        }
        return dp[0][4];
    }
    
}