class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        HashSet<Integer>s=new HashSet<>();
        for(int i:nums)s.add(i);
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        for(int i=lower;i<=upper;i++){
            if(!s.contains(i)){
            if(temp.isEmpty()){
                temp.add(i);
                temp.add(i);
            }
            else{
                temp.set(1,i);
            }
        }
        else{
            if(!temp.isEmpty()){
            ans.add(new ArrayList<>(temp));
            s.add(temp.get(0));
            s.add(temp.get(1));
            temp.remove(1);
            temp.remove(0);
            }
        }
    }
    if(!temp.isEmpty() && !s.contains(temp.get(1)))ans.add(temp);
    return ans;
    
}
}