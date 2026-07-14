class Solution {
    int mod=(int)1e9+7;
    public int subsequencePairCount(int[] nums) {
        long[][][] dp=new long[201][201][nums.length];
        for(long[][] i:dp)for(long[] j:i)Arrays.fill(j,-1L);
        return (int)func(nums,nums.length-1,0,0,dp)-1;
    }
    private long func(int[] nums,int n,int gc1,int gc2,long[][][] dp){
        if(n<0){
            if(gc1==gc2)return 1;
            return 0;
        }
        if(dp[gc1][gc2][n]!=-1L)return dp[gc1][gc2][n]%mod;
        long pick1=func(nums,n-1,gcd(gc1,nums[n]),gc2,dp);
        long pick2=func(nums,n-1,gc1,gcd(gc2,nums[n]),dp);
        long skip=func(nums,n-1,gc1,gc2,dp);
        long ans=(pick1+pick2+skip)%mod;
        return dp[gc1][gc2][n]=ans%mod;
    }
    private int gcd(int a,int b){
        while(a>0 && b>0){
            if(a>b){
                a%=b;
            }
            else b=b%a;
        }
        return a+b;
    }

}