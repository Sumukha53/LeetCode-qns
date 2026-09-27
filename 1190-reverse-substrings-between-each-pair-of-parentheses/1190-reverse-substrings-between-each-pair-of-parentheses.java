class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer>st=new Stack<>();
        int n=s.length();
        int i=0;
        int[] pair=new int[n];
        for(;i<n;i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }
            else if(s.charAt(i)==')'){
                int top=st.pop();
                pair[i]=top;
                pair[top]=i;
            } 
        }
        String ans="";
        int dir=1;
        i=0;
        while(i<n){
            if(s.charAt(i)=='(' || s.charAt(i)==')'){
                i=pair[i];
                dir=-dir;
            }
            else{
                ans+=s.charAt(i);
            }
            i+=dir; 
        }
        return ans;
    }
}