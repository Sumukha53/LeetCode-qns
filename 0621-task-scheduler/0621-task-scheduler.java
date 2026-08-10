class Solution {
    class Pair{
        int freq,time;
        Pair(int freq,int time){
            this.freq=freq;
            this.time=time;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char i:tasks)freq[i-65]++;
        PriorityQueue<Integer>pq=new PriorityQueue<>(
            (a,b)->Integer.compare(b,a)
        );
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<26;i++)if(freq[i]!=0)pq.offer(freq[i]);
        int time=0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int top=pq.poll();
                if(top-1>0)q.offer(new Pair(top-1,time));
            }
            if(!q.isEmpty() && time-q.peek().time>=n){
                pq.offer(q.poll().freq);
            }
        }
        return time;

    }
}