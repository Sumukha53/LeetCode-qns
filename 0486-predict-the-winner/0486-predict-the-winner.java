class Solution {
    public boolean predictTheWinner(int[] nums) {
        int[][] dp=new int[nums.length][nums.length];
        for(int[] i:dp)Arrays.fill(i,Integer.MIN_VALUE);

        int ans=pred(nums,0,nums.length-1,dp);
        return ans>=0;
    }
    private int pred(int[] nums,int i,int j,int[][] dp){
        if(i>j)return 0;
        if(dp[i][j]!=Integer.MIN_VALUE)return dp[i][j];
        int p1=nums[i]-pred(nums,i+1,j,dp);
        int p2=nums[j]-pred(nums,i,j-1,dp);
        return dp[i][j]=Math.max(p1,p2);
    }
}