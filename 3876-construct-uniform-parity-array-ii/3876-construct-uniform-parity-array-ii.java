class Solution {
    public boolean uniformArray(int[] nums1) {
        int mne=Integer.MAX_VALUE;
        int mno=Integer.MAX_VALUE;
        for(int i:nums1)if(i%2==0)mne=Math.min(i,mne);
        else mno=Math.min(i,mno);
        if(mne==Integer.MAX_VALUE||mno==Integer.MAX_VALUE)return true;
        return mno<mne;
    }
}