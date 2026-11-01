class Solution {
    public int arrayNesting(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int temp=0;
            for(int j=i;nums[j]!=-1;){
                temp++;
                int j_=j;
                j=nums[j];
                nums[j_]=-1;
            }
            ans=Math.max(ans,temp);
        }
        return ans;
    }
}