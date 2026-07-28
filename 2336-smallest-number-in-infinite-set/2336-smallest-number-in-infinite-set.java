class SmallestInfiniteSet {
    PriorityQueue<Integer>pq=new PriorityQueue<>();
    HashSet<Integer>s=new HashSet<>();
    public SmallestInfiniteSet() {
        for(int i=1;i<=2000;i++){pq.offer(i);s.add(i);}

    }
    
    public int popSmallest() {
        int ans=pq.poll();
        while(!pq.isEmpty() && pq.peek()==ans)pq.poll();
        s.remove(ans);
        return ans;
    }
    
    public void addBack(int num) {
        if(!s.contains(num))pq.offer(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */