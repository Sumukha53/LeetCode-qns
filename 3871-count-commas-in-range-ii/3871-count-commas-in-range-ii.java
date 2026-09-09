class Solution {
    public long countCommas(long n) {
        long ans=0;
        long cnt=0;
        long m=n;
        long i=999;
        for(;i<=n;i=i*1000L+999L){
            m/=1000L;
            cnt++;
            ans+=n-i;
        }
        return ans;
    }
}