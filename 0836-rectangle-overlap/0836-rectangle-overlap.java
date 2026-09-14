class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x11=rec1[0],x12=rec1[2],x21=rec2[0],x22=rec2[2];
        int y11=rec1[1],y12=rec1[3],y21=rec2[1],y22=rec2[3];
        return Math.max(x11,x21)<Math.min(x12,x22) && Math.max(y11,y21)<Math.min(y12,y22);
    }
}