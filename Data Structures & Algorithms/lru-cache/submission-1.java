class Node{
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val){
        this.key = key;
        this.val = val;       
    }
}

class LRUCache {

    Node head;
    Node tail;
    int capacity;
    Map<Integer,Node>mp;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        mp = new HashMap<>();
    }

    void addNodeToHead(Node node){
        Node currNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = currNode;
        currNode.prev = node;
    }

    void deleteNodeToTail(Node node){
        Node nextNode = node.next;
        Node prevNode = node.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }

    
    
    public int get(int key) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            deleteNodeToTail(node);
            addNodeToHead(node);
            return node.val;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            deleteNodeToTail(node);
            addNodeToHead(node);
            node.val = value;
            mp.put(key,node);
        }
        else{
            Node node = new Node(key,value);
            if(mp.size()>=capacity){
                mp.remove(tail.prev.key);
                deleteNodeToTail(tail.prev);
                addNodeToHead(node);
            }
            else{
                addNodeToHead(node);
            }
            mp.put(key,node);
        }
    }
}
