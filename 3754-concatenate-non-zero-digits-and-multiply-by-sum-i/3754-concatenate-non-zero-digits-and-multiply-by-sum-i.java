class Solution {
    public long sumAndMultiply(int n) {
        int sum=0;
        int num=0;
        int p=1;
        while(n>0){
            if(n%10!=0){num+=(n%10)*p;p*=10;}
            sum+=n%10;
            n/=10;
        }
        return (long)num*sum;
    }
}