class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        int n=s1.length();
        int prev=0;
        List<List<String>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(s1.charAt(i)==s2.charAt(i)){
                if(prev!=i){
                List<String>tem=new ArrayList<>();
                tem.add(s1.substring(prev,i));
                tem.add(s2.substring(prev,i));
                ans.add(tem);
                }
                prev=i+1;
            }
        }
        if(prev!=n){
            List<String>tem=new ArrayList<>();
            tem.add(s1.substring(prev,n));
            tem.add(s2.substring(prev,n));
            ans.add(tem);
        }
        return ans;
    }
}