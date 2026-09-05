class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] suffix=new int[n+1];
        suffix[n]=nums[n-1];
        for(int i=n-1;i>=0;i--){
            suffix[i]=Math.min(suffix[i+1],nums[i]);
        }
        int mx=0;
        for(int i=0;i<n;i++){
            mx=Math.max(mx,nums[i]);
            if(mx-suffix[i]<=k)return i;
        }
        return -1;
    }
}