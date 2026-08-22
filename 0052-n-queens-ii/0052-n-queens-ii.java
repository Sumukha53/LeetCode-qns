class Solution {
    public int totalNQueens(int n) {
        cols=new boolean[2*n];
        d1=new boolean[2*n];
        d2=new boolean[2*n];
        helper(n,0);
        return ans;
    }
    int ans=0;
    boolean[] cols,d1,d2; 
    private void helper(int n,int row){
        if(row==n)ans++;
        for(int c=0;c<n;c++){
            if(!cols[c] && !d1[c-row+n] && !d2[c+row]){
                cols[c]=true;d1[c-row+n]=true;d2[c+row]=true;
                helper(n,row+1);
                cols[c]=false;d1[c-row+n]=false;d2[c+row]=false;
            }
        }
        return;
    }
}