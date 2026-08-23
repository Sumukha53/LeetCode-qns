class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==1)return s;
        String ans="";
        int i=0,mxlen=0;
        while(i<n){
            int l=i,r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                l--;r++;
            }
            if(mxlen<r-l-1){
                ans=s.substring(l+1,r);
                mxlen=r-l-1;
            }
            i++;
        }
        i=0;
        while(i<n-1){
            int l=i,r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                l--;r++;
            }
            if(mxlen<r-l-1){
                ans=s.substring(l+1,r);
                mxlen=r-l-1;
            }
            i++;
        }
        return ans;
    }
}