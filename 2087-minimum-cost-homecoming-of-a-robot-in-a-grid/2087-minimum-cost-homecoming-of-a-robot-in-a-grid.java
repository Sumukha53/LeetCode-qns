class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int ans=0;
        for(int i=Math.min(startPos[0],homePos[0]);i<=Math.max(startPos[0],homePos[0]);i++)ans+=rowCosts[i];

        for(int i=Math.min(startPos[1],homePos[1]);i<=Math.max(startPos[1],homePos[1]);i++)ans+=colCosts[i];ans-=rowCosts[startPos[0]];
        ans-=colCosts[startPos[1]];
        return ans;
    }
}