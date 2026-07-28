class Solution {
    public String smallestPalindrome(String s) {
        int[] alpha=new int[26];
        for(char i:s.toCharArray()){
            alpha[i-97]++;
        }
        StringBuilder ans=new StringBuilder();
        int odd=-1;
        for(int i=0;i<26;i++){
            if(alpha[i]%2==1 && odd==-1)odd=i;
            for(int j=0;j<alpha[i]/2;j++){
                ans.append((char)(i+'a'));
            }
        }
        StringBuilder rev=new StringBuilder();
        for(int i=ans.length()-1;i>=0;i--)rev.append(ans.charAt(i));
        return odd==-1?ans.toString()+rev.toString():ans.toString()+(char)(odd+'a')+rev.toString();
    }
}