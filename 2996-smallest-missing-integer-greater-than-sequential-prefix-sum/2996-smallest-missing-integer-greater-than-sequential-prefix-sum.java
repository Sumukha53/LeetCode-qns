class Solution {
    public int missingInteger(int[] nums) {
        int n=nums.length;
        int start=nums[0];
        HashSet<Integer>s=new HashSet<>();
        for(int num:nums)s.add(num);
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]+1)start+=nums[i];
            else break;
        }
        while(s.contains(start)){
            start++;
        }
        return start;
    }
}