class Solution {
    public int maxNumberOfFamilies(int n, int[][] reserved) {
        int m=reserved.length;
        Arrays.sort(reserved,(a,b)->{
            if(a[0]==b[0])return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });
        long max_ans=2L*n;
        int i=0;
        while(i<m){
            int row=reserved[i][0];
            int mask=0b1111111111;
            while(i<m && reserved[i][0]==row){
                mask^=(1<<(reserved[i][1]-1));
                i++;
            }
            System.out.println(mask);
            boolean enterleft=false,enterright=false;
            if((mask&(1<<1))==0 || (mask&(1<<2))==0 || (mask&(1<<3))==0
            || (mask&(1<<4))==0){max_ans--;enterleft=true;}
            if((mask&(1<<5))==0 || (mask&(1<<6))==0 || (mask&(1<<7))==0
            || (mask&(1<<8))==0){max_ans--;enterright=true;}
            if((mask&0b0001111000)==0b0001111000 && enterleft && enterright)max_ans++;
            

        }
        return (int)max_ans;
        
    }
}