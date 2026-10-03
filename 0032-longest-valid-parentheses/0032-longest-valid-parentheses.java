class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer>st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(!st.isEmpty() && s.charAt(st.peek())=='(' && s.charAt(i)==')')st.pop();
            else st.push(i);
        }
        if(st.isEmpty())return n;
        int ans=0;
        ans=n-st.peek()-1;
        int prev=st.pop();
        while(!st.isEmpty()){
            ans=Math.max(prev-st.peek()-1,ans);
            prev=st.pop();
        }
        ans=Math.max(ans,prev);
        return ans;
    }
}