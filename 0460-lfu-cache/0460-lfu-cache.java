class LFUCache {
    int capacity;
    HashMap<Integer, LRU> freq;
    int min_freq;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        freq = new HashMap<>();
        min_freq=0;
    }

    public int get(int key) {
        if(!m.containsKey(key))return -1;
        Node curr=m.get(key);
        updateFreq(curr);
        return curr.val;
    }

    public void put(int key, int value) {
        if(capacity==0)return;
        if(m.containsKey(key)){
            Node curr=m.get(key);
            updateFreq(curr);
            curr.val=value;
            return;
        }
        if(m.size()==capacity){
            m.remove(freq.get(min_freq).tail.prev.key);
            LRU lru=freq.get(min_freq);
            Node toDel=lru.tail.prev;
            lru.delete(toDel);
        }
        freq.putIfAbsent(1,new LRU());
        Node curr=new Node(key,value,1);
        freq.get(1).add(curr);
        m.put(key,curr);
        min_freq=1;
        return;

        
    }
    public void updateFreq(Node node){
        int fre=node.cnt;
        freq.get(fre).delete(node);
        fre++;
        node.cnt=fre;
        if(min_freq==fre-1 && freq.get(fre-1).size==0){
            min_freq++;
        }
        freq.putIfAbsent(fre,new LRU());
        freq.get(fre).add(node);
    }

    

    class Node {
        Node prev, next;
        int key, val,cnt;

        Node(int key, int val,int cnt) {
            this.key = key;
            this.val = val;
            this.cnt=cnt;
        }
    }

    HashMap<Integer, Node> m = new HashMap<>();

    class LRU {
        Node head, tail;
        int size=0;
        LRU() {
            head = new Node(-1, -1,-1);
            tail = new Node(-1, -1,-1);
            head.next = tail;
            tail.prev = head;
        }

        public void add(Node node) {
            Node top = head.next;
            head.next = node;
            node.prev = head;
            node.next = top;
            top.prev = node;
            size++;
            return;
        }

        public void delete(Node node) {
            Node prev = node.prev;
            Node nxt = node.next;
            prev.next = nxt;
            nxt.prev = prev;
            size--;
            return;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */