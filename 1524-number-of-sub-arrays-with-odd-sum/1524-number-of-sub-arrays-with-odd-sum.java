class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        int sm=0;
        long ans=0L;
        int odd=0,even=1;
        int mod=(int)1e9+7;
        for(int i=0;i<n;i++){
            sm+=arr[i];
            if(sm%2==0){
                ans+=odd;
                even++;
            }
            else{
                ans+=even;
                odd++;
            }
            ans%=mod;
        }
        return (int)ans;
    }
}