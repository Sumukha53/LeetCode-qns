class Solution {
    private int func(int[] nums1,int[] nums2,int i,int j,int[][]dp){
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(nums1[i]!=nums2[j]) return dp[i][j]=0;
        else return dp[i][j]=1+func(nums1,nums2,i-1,j-1,dp);
    }
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length][nums2.length];
        for(int[] i:dp)Arrays.fill(i,-1);
        int ans=0;
        for(int i=0;i<nums1.length;i++)for(int j=0;j<nums2.length;j++)ans=Math.max(ans,func(nums1,nums2,i,j,dp));
        return ans;
    }
}