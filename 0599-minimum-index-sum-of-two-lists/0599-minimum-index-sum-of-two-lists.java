class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer>m1=new HashMap<>();
        for(int i=0;i<list1.length;i++)m1.put(list1[i],i);
        int minsum=Integer.MAX_VALUE;
        int ans_len=0;
        for(int i=0;i<list2.length;i++){
            if(m1.containsKey(list2[i])){
                minsum=Math.min(minsum,m1.get(list2[i])+i);
            }
        }
        for(int i=0;i<list2.length;i++){
            if(m1.containsKey(list2[i])){
                if(m1.get(list2[i])+i==minsum)ans_len++;
            }
        }
        String[] ans=new String[ans_len];
        int ind=0;
        for(int i=0;i<list2.length;i++){
            if(m1.containsKey(list2[i])){
                if(m1.get(list2[i])+i==minsum)ans[ind++]=list2[i];
            }
        }
        return ans;
    }
}