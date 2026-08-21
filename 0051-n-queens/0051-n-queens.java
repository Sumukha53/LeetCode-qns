class Solution {
    public List<List<String>> solveNQueens(int n) {
        ans=new ArrayList<>();
        cols=new HashSet<>();
        d1=new HashSet<>();
        d2=new HashSet<>();
        queens=new int[n];
        helper(n,0);
        return ans;
    }
    HashSet<Integer>cols,d1,d2;
    List<List<String>>ans;
    int queens[];
    private void helper(int n,int row){
        if(row==n){
            List<String>lst=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder temp=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(queens[i]==j){
                        temp.append('Q');
                    }
                    else temp.append('.');
                }
                lst.add(temp.toString());
            }
            ans.add(lst);
            return;
        }
        for(int c=0;c<n;c++){
            if(!cols.contains(c) && !d1.contains(row-c) && !d2.contains(row+c)){
                cols.add(c);d1.add(row-c);d2.add(row+c);
                queens[row]=c;
                helper(n,row+1);
                cols.remove(c);d1.remove(row-c);d2.remove(row+c);
            }
        }
    }
}