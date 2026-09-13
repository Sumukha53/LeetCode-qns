class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n=nums.length;
        HashMap<Integer,List<Integer>>m=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!m.containsKey(nums[i])){
                m.put(nums[i],new ArrayList<>());
            }
            m.get(nums[i]).add(i);
        }
        int ans=0;
        for(int i:nums){
            if(m.containsKey(i)){
                List<Integer>curr=m.get(i);
                int sz=curr.size();
                if(sz<3){m.remove(i);continue;}
                int diff=curr.get(1)-curr.get(0);
                int j=0;
                
                for(j=2;j<sz;j++){
                    if(diff!=curr.get(j)-curr.get(j-1))break;
                    diff=curr.get(j)-curr.get(j-1);
                }
                if(j==sz){ans++;}
                m.remove(i);
            }
        }
        return ans;
        
    }
}