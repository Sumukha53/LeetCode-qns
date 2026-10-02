class Solution {
    List<String>lst=new ArrayList<>();
    private void generate(int l,int r,StringBuilder s){
        if(l==0 && r==0){
            lst.add(s.toString());
            return;
        }
        if(l>0){
            s.append('(');
            generate(l-1,r,s);
            s.deleteCharAt(s.length()-1);
        }
        if(r>l){
            s.append(')');
            generate(l,r-1,s);
            s.deleteCharAt(s.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        StringBuilder s=new StringBuilder();
        generate(n,n,s);
        return lst;
    }
}