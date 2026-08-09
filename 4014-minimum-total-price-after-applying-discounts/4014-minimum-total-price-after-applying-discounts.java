class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        double ans=0;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int n=prices.length,m=discounts.length;
        int i=n-1,j=m-1;
        while(i>=0 && j>=0){
            ans+=((double)prices[i])*((double)(100-discounts[j]))/100.0;
            i--;j--;
        }
        while(i>=0)ans+=prices[i--];
        return ans;
    }
}