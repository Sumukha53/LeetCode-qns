class Solution {
    class Tri{
        int enq,pro,ind;
        Tri(int enq,int pro,int ind){
            this.enq=enq;
            this.pro=pro;
            this.ind=ind;
        }
    }
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Tri>pq=new PriorityQueue<>(
            (a,b)->{
                if(a.pro==b.pro){
                    return Integer.compare(a.ind,b.ind);
                }
                return Integer.compare(a.pro,b.pro);
            }
        );
        Tri[] task=new Tri[tasks.length];
        for(int i=0;i<tasks.length;i++){
            task[i]=new Tri(tasks[i][0],tasks[i][1],i);
        }
        Arrays.sort(task,
        (a,b)->{
            if(a.enq==b.enq)return Integer.compare(a.pro,b.pro);
            return Integer.compare(a.enq,b.enq);
        });

        int[] ans=new int[tasks.length];
        int i=0;
        long time=1L;
        int ind=0;
        while(ind<tasks.length){
            while(i<tasks.length && task[i].enq<=time){
                pq.offer(task[i]);
                i++;
            }
            if(!pq.isEmpty()){
                time+=pq.peek().pro;
                ans[ind++]=pq.poll().ind;
            }
            else{
                time=task[i].enq;
            }
        }
        return ans;
    }
}