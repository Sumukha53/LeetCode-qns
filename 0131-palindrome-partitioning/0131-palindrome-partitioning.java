class Solution {
    public List<List<String>> partition(String s) {
        helper(s,new ArrayList<>(),0);
        return ans;
    }
    List<List<String>>ans=new ArrayList<>();
    private boolean isPalindrome(String s,int l,int r){
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r))return false;
            l++;r--;
        }
        return true;
    }
    private void helper(String s,List<String>l,int i){
        if(i==s.length( )){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int j=i;j<s.length();j++){
            if(isPalindrome(s,i,j)){
                l.add(s.substring(i,j+1));
                helper(s,l,j+1);
                l.remove(l.size()-1);
            }
        }
    }
}