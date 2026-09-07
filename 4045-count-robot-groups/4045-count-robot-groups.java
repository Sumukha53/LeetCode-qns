class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int n=speed.length;
        if(n==1)return n;
        int i=n-2;
        int right_min=speed[n-1];
        int ans=0;
        while(i>=0){
            while(i>=0 && (speed[i]>right_min || position[i+1]-position[i]<=distance)){
                i--;
            }
            if(i>0)right_min=speed[i];
            ans++;
            i--;
        }
        if(speed[0]<=right_min && position[1]-position[0]>distance)++ans;
        return ans;
    }
}