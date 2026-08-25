class Solution {
    public List<String> readBinaryWatch(int on) {
        List<String>ans=new ArrayList<>();
        for(int hr=0;hr<12;hr++){
            for(int mn=0;mn<60;mn++){
                int cnt=count(hr)+count(mn);
                if(cnt==on)ans.add(hr+":"+(mn>9?mn:"0"+mn));
            }
        }
        return ans;

    }
    private int count(int n){
        int ans=0;
        while(n>0){
            n=n&(n-1);
            ans++;
        }
        return ans;
    }
}