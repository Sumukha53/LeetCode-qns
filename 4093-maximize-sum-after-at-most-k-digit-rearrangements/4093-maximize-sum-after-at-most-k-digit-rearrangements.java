public class Pair{
    int first;
    long second;
    Pair(int first,long second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public long maximizeSum(int[] nums, int k) {
        int n=nums.length;
        Pair[] pairs=new Pair[n];
        for(int i=0;i<n;i++){
            pairs[i]=new Pair(nums[i],rearrange(nums[i]));
        }
        Arrays.sort(pairs,
        (a,b)->Long.compare(a.second-a.first,b.second-b.first)
        );
        long ans=0;
        for(int i=n-1;i>=0;i--){
            if(k>0){
                k--;
                ans+=pairs[i].second;
            }
            else ans+=pairs[i].first;
        }
        return ans;
    }
    private long rearrange(int n){
        int[] arr=new int[10];
        while(n>0){
            arr[n%10]++;
            n/=10;
        }
        long ans=0;
        for(int i=9;i>=0;i--){
            for(int j=arr[i];j>0;j--){
                ans=ans*10L+(long)i;
            }
        }
        return ans;
    }
}