class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>>ans=new ArrayList<>();
        int n=series1.length+series2.length;
        int i=0,j=0,k=0;
        while(i<series1.length && j<series2.length){
            if(series1[i][0]<series2[j][0]){
                ans.add(new ArrayList<>());
                ans.get(k).add(series1[i][0]);
                ans.get(k).add(series1[i][1]+series2[j][1]);
                i++;
            }
            else if(series1[i][0]>series2[j][0]){
                ans.add(new ArrayList<>());
                ans.get(k).add(series2[j][0]);
                ans.get(k).add(series1[i][1]+series2[j][1]);
                j++;
            }
            else{
                ans.add(new ArrayList<>());
                ans.get(k).add(series2[j][0]);
                ans.get(k).add(series1[i][1]+series2[j][1]);
                j++;
                i++;
            }
            k++;
        }
        while(i<series1.length){
                ans.add(new ArrayList<>());
                ans.get(k).add(series1[i][0]);
                ans.get(k).add(series1[i][1]);
                i++;
            
            k++;
        }
        while(j<series2.length){
                ans.add(new ArrayList<>());
                ans.get(k).add(series2[j][0]);
                ans.get(k).add(series2[j][1]);
                j++;
            
            k++;
        }
        return ans;
    }
}