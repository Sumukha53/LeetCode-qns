class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][3];
        int n=prices.length;
        for(int i=prices.length-1;i>=0;i--){
            for(int k=0;k<=2;k++){
                if(k==1 || k==0){
            int take=(i==n-1?0:dp[i+1][2])-prices[i];
            int skip=(i==n-1?0:dp[i+1][k]);
            dp[i][k]=Math.max(take,skip);
            }
            else{
            int take=(i==n-1?0:dp[i+1][1])+prices[i];
            int skip=(i==n-1?0:dp[i+1][k]);
            dp[i][k]=Math.max(take,skip);
        }
            }
        }
        return dp[0][0];
    }
}