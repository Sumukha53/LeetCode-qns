class Solution {
    public int minimumPushes(String word) {
        int[] map=new int[26];
        for(char i:word.toCharArray())map[i-'a']++;
        for(int i=25;i>=0;i--){
            System.out.println((char)(i+'a')+" "+map[i]);
        }
        Arrays.sort(map);
        int cnt=0,mul=1,ans=0;
        for(int i=25;i>=0;i--){
            ans+=map[i]*mul;
            cnt++;
            if(cnt%8==0)mul++;
        }
        return ans;
    }
}