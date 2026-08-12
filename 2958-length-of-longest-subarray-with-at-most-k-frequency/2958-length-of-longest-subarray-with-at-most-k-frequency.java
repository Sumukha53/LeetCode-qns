class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer>m=new HashMap<>();
        int r=0,l=0;
        int n=nums.length;
        int ans=0;
        while(r<n){
            m.put(nums[r],m.getOrDefault(nums[r],0)+1);
            while(r<n && m.get(nums[r])>k){
                m.put(nums[l],m.get(nums[l])-1);
                l++;
            }
            ans=Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}