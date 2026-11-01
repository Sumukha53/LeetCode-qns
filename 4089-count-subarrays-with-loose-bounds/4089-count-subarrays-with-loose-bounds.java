class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n=nums.length;
        long cnt=0,ans=0;
        for(int i=0;i<n;i++){
            if(nums[i]<minK || nums[i]>maxK){
                ans+=(cnt*(cnt+1))>>1;
                cnt=0L;
            }
            else cnt++;
        }
        ans+=(cnt*(cnt+1))>>1;
        return ans;
    }
}