class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n<=2)return n;
        int len=(int)(Math.log10(n)/Math.log10(2));
        return 1<<(len+1);

    }
}