class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] min_=new int[nums.length];
        min_[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            min_[i]=Math.min(min_[i+1],nums[i]);
        }
        int mx=0;
        for(int i=0;i<nums.length;i++){
            mx=Math.max(mx,nums[i]);
            if(mx-min_[i]<=k)return i;
        }
        return -1;
    }
}