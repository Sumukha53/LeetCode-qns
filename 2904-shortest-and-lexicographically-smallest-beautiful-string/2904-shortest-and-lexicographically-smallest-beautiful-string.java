class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        int i=0;
        int ones=0;
        int j=0;
        int score=0;
        String ans="9";
        int mn_len=n;
        while(i<n){
            ones+=s.charAt(i)-'0';
            while(j<n && (ones>k || s.charAt(j)=='0')){
                ones-=s.charAt(j)-'0';
                j++;
            }
            if(ones==k){
                if(mn_len>i-j+1){
                    mn_len=i-j+1;
                    ans=s.substring(j,i+1);
                }
                else if(mn_len==i-j+1 && s.substring(j,i+1).compareTo(ans)<0){
                    ans=s.substring(j,i+1);
                }
                }
            i++;
        }
        System.out.println(mn_len);
        return ans.equals("9")?"":ans;
    }
}