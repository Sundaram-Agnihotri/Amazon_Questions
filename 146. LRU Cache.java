qUESTION IN LEETCODE ->> 146. LRU Cache

  class LRUCache {
    class Node{
        int key; 
        int val;
        Node next;
        Node prev;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    // 
    int capacity;
    Map<Integer,Node> mp;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        this.mp = new HashMap<>();
    }
    private void addToFront(Node node){
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }
    public int get(int key) {
        if(mp.containsKey(key)){
            Node temp = mp.get(key);
            int ans = temp.val;
            remove(temp);
            addToFront(temp);
            //printCache();
            return ans;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node temp = mp.get(key);
            remove(temp);
            mp.remove(temp.key);
        }
        else if(mp.size() == capacity){
            Node temp = tail.prev;
            remove(temp);
            mp.remove(temp.key);
        }
        
        Node newNode = new Node(key, value);
        addToFront(newNode);
        mp.put(key, newNode);
        //printCache();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
