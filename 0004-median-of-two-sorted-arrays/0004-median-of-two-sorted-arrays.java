class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length,m=nums2.length;
        int[] large=n>m?nums1:nums2;
        int[] small=n>m?nums2:nums1;
        n=small.length;m=large.length;
        int l=0,r=n;
        int tot=m+n;
        while(l<=r){
            int small_part=l+((r-l)>>1);
            int large_part=(tot+1)/2-small_part;
            double l1=small_part==0?Integer.MIN_VALUE:small[small_part-1];
            double r1=small_part==n?Integer.MAX_VALUE:small[small_part];

            double l2=large_part==0?Integer.MIN_VALUE:large[large_part-1];
            double r2=large_part==m?Integer.MAX_VALUE:large[large_part];

            if(r1<l2)l=small_part+1;
            else if(l1>r2)r=small_part-1;
            else if(r1>=l2 && l1<=r2){
                if(tot%2==0)return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                else return Math.max(l1,l2);
            }

        }
        return 0;
    }
}