class Solution {
public:
    bool checkDivisibility(int n) {
        int m=n,l=n;
        int sum=0;
        int p=1;
        while(m!=0){sum+=m%10;p*=(m%10);m/=10;}
        return n%(sum+p)==0;
    }
};