class Solution {
    public int largestInteger(int n, int s) {
        if(s==0)return 0;
        int ans=0;
        int cnt=0;
        int sum=0;
        int t=s;
        while(cnt<n){
            ans=ans*10+Math.min(9,s);
            sum+=Math.min(9,s);
            cnt++;
            s-=Math.min(9,s);
        }
        return t==sum?ans:-1;
    }
}