class Solution {
    public int sumDecoded(long[] nums) {
        long ans=0;
        long mod=1_000_000_007L;
        for(long i:nums){
            int w=(int)(i%10);
            long d=i/10;
            String num=d+"";
            long x=Long.parseLong(num.substring(0,w));
            long a=Long.parseLong(num.substring(w,num.length()));
            ans+=exp(x%mod,a);
            ans%=mod;
        }
        return (int)ans;
    }
    private long exp(long x,long a){
        long mod=1_000_000_007L;
        long ans=1;
        while(a>0){
            if(a%2==1){
                ans=(ans*x)%mod;
            }
            x=(x*x)%mod;
            a>>=1;
        }
        return ans%mod;
    }
}