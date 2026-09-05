class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>st=new Stack<>();
        int[] left,right;
        int n=heights.length;
        left=new int[n];
        right=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            right[i]=!st.isEmpty()?st.peek():n;
            st.push(i);

        }
        st.clear();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            left[i]=!st.isEmpty()?st.peek():-1;
            st.push(i);

        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,(right[i]-left[i]-1)*heights[i]);
        }
        return ans;
    }
}