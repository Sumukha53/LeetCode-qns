class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer>m=new HashMap<>();
        int ans=0;
        for(int i:nums)m.put(i,m.getOrDefault(i,0)+1);
        for(int i:nums){ans+=m.get(i)*(m.get(i)-1)/2;m.put(i,0);}
        return ans;
    }
}