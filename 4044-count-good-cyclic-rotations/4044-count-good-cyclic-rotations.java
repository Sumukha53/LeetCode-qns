class Solution {
    public int countGoodRotations(int[] nums) {
        int n=nums.length;
        long left=0,right=0;
        for(int i=0;i<n;i++){
            if(2*i<n)left+=nums[i];
            else right+=nums[i];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            left+=nums[((n>>1)+i)%n]-nums[i];
            right+=-nums[((n>>1)+i)%n]+nums[i];
            if(left>right)ans++;
        }
        return ans;
    }
}