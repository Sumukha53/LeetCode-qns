class Solution {
    public String[] largestString(int[] nums) {
        int n=nums.length;
        String[] ans=new String[n];
        for(int i=0;i<n;i++){
            int num=nums[i];
            StringBuilder temp=new StringBuilder();
            int cnt=0;
            while(num>0){
                if(num%2==1){
                    if(cnt<26){
                        char c=(char)(cnt+'a');
                        temp.append(c);
                    }
                    else{
                        temp.append("zz");
                    }
                }
                cnt++;
                num>>=1;
            }
            temp.reverse();
            ans[i]=temp.toString();
        }
        return ans;
    }
}