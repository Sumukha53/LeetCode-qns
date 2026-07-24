class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int[] trip=new int[2049];
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                trip[nums[i]^nums[j]]++;
            }
        }
        HashSet<Integer>s=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<2049;j++){
                if(trip[j]>0){
                    s.add(j^nums[i]);
                }
            }
        }
        return s.size();
    }
}