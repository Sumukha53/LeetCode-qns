class Solution {
    class Pair{
        String s;
        int cnt;
        Pair(String s,int cnt){
            this.s=s;
            this.cnt=cnt;
        }
    }
    public int openLock(String[] deadends, String target) {
        HashSet<String>vis;
        vis=new HashSet<>();
        for(String s:deadends)vis.add(s);
        if(vis.contains("0000"))return -1;
        Queue<Pair>q=new LinkedList<>();
        q.offer(new Pair("0000",0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            String s=p.s;
            int cnt=p.cnt;
            if(s.equals(target))return cnt;
            for(String ss:next(s)){
                if(!vis.contains(ss))q.offer(new Pair(ss,cnt+1));
                vis.add(ss);
            }
        }
        return -1;
    }
    private List<String> next(String s){
        List<String>ans=new ArrayList<>();
        for(int i=0;i<4;i++){
            String t1=s.substring(0,i)+(char)((s.charAt(i)+11-'0')%10+'0')+(i==3?"":s.substring(i+1));
            String t2=s.substring(0,i)+(char)((s.charAt(i)+9-'0')%10+'0')+(i==3?"":s.substring(i+1));
            ans.add(t1);
            ans.add(t2);
        }
        return ans;
    }
}