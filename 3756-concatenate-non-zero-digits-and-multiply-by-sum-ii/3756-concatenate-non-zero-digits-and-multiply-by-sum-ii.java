class Solution {
    int mod=(int)1e9+7;
    class Tri{
        long num;
        long sum;
        int cnt;
        Tri(long num,long sum,int cnt){
            this.num=num;
            this.sum=sum;
            this.cnt=cnt;
        }
    }
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n=s.length();
        Tri[] compute=new Tri[n+1];
        compute[0]=new Tri(0L,0L,0);
        long nm=0,sm=0;
        int cnt=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)!='0')cnt++;
            if(s.charAt(i)!='0')nm=(nm*10L+(s.charAt(i)-'0'))%mod;
            sm+=(s.charAt(i)-'0');
            compute[i+1]=new Tri(nm,sm,cnt);
        }
        int[] ans=new int[queries.length];
        int ind=0;
        for(int[] q:queries){
            int l=q[0],r=q[1];
            if(l==r){ans[ind++]=(s.charAt(l)-'0')*(s.charAt(l)-'0');continue;}
            int cnt1=compute[r+1].cnt;
            int cnt2=compute[l].cnt;
            long q_sum=compute[r+1].sum-compute[l].sum;
            q_sum%=mod;
            long q_num=compute[r+1].num-(compute[l].num*mod_mul(cnt1-cnt2))%mod;

            q_num=(q_num+mod)%mod;
            long tem=(q_sum*q_num)%mod;
            ans[ind++]=(int)tem;
        }
        return ans;

    }
    private int mod_mul(int r){
        long ans=1;
        long b=10;
        while(r>0){
            if(r%2==1){
                ans=((ans%mod)*(b%mod))%mod;
            }
            b=(b%mod)*(b%mod);
            b%=mod;
            r>>=1;
        }
        return (int)ans;
    }
}