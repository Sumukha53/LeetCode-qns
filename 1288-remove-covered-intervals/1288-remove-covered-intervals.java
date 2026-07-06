class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
        if(a[0]==b[0])return Integer.compare(a[1],b[1]);
        return Integer.compare(a[0],b[0]);});
        int n=intervals.length;
        int[] last=intervals[0];
        int ans=n;
        for(int i=1;i<n;i++){
            if(intervals[i][0]==last[0]){
                last=intervals[i];
                --ans;
            }
            else if(last[1]>=intervals[i][1]){
                --ans;
            }
            else{
                last=intervals[i];
            }
        }
        return ans;
    }
}