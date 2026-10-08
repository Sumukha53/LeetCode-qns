class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Integer>st=new Stack<>();
        int n=s.length();
        String ans="";
        for(int i=0;i<n;i++){
            if(!st.isEmpty() && s.charAt(st.peek())=='(' && s.charAt(i)==')'){
                if(st.size()==1){
                    ans+=s.substring(st.peek()+1,i);
                }
                st.pop();
            }
            else st.push(i);
        }
        return ans;
    }
}