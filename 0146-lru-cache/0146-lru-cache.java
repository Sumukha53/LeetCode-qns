class LRUCache {
    int capacity;
    HashMap<Integer,Node>m;
    Node head=null,tail=null;
    int sz=0;
    class Node{
        Node prev;
        Node next;
        int key;
        int value;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    public LRUCache(int capacity) {
        this.capacity=capacity;
        m=new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!m.containsKey(key))return -1;
        Node curr=m.get(key);
        delete(curr);
        add(curr);
        return curr.value;
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
            Node curr=m.get(key);
            curr.value=value;
            delete(curr);
            add(curr);
            return;
        }
        if(m.size()==capacity){
            m.remove(tail.prev.key);
            delete(tail.prev);
        }
        Node curr=new Node(key,value);
        m.put(key,curr);
        add(curr);
        return;


    }
    private void add(Node node){
        Node temp=head.next;
        node.next=temp;
        temp.prev=node;
        node.prev=head;
        head.next=node;
    }
    private void delete(Node node){
        Node pre=node.prev;
        Node nxt=node.next;
        nxt.prev=pre;
        pre.next=nxt;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */