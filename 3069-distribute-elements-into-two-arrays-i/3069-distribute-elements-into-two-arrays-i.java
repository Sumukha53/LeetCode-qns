class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        if(n<3)return nums;
        int arr1=nums[0],arr2=nums[1];
        nums[1]*=-1;
        for(int i=2;i<n;i++){
            if(arr1<=arr2){arr2=nums[i];nums[i]*=-1;}
            else arr1=nums[i];
        }
        int[] ans=new int[n];
        int k=0;
        for(int i=0;i<n;i++){
            if(nums[i]>0)ans[k++]=nums[i];
        }
        for(int i=0;i<n;i++){
            if(nums[i]<0)ans[k++]=-nums[i];
        }
        return ans;
    }
}