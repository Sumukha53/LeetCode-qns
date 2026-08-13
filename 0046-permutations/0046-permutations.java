class Solution {
    private void perms(int[] nums,int i,int n){
        if(i==n){
            List<Integer>tem=new ArrayList<>();
            for(int num:nums)tem.add(num);
            ans.add(tem);
            return;
        }
        
        for(int j=i;j<nums.length;j++){
            swap(nums,i,j);
            perms(nums,i+1,n);
            swap(nums,i,j);
        }
    }
    private void swap(int[] nums,int i,int j){
        if(i==j)return;
        nums[i]=nums[j]^nums[i];
        nums[j]=nums[i]^nums[j];
        nums[i]=nums[j]^nums[i];
    }
    List<List<Integer>>ans;
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        ans=new ArrayList<>();
        perms(nums,0,nums.length);
        return ans;
    }
}