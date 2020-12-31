class DLLNode {
    private int val;
    private final int key;
    private DLLNode prev;
    private DLLNode next;

    public DLLNode(int key, int val) {
        this.val = val;
        this.key = key;
        this.next = null;
        this.prev = null;
    }

    public int getKey() {
        return this.key;
    }

    public int getVal() {
        return this.val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public DLLNode getPrev() {
        return this.prev;
    }

    public void setPrev(DLLNode node) {
        this.prev = node;
    }

    public DLLNode getNext() {
        return this.next;
    }

    public void setNext(DLLNode node) {
        this.next = node;
    }
}

class LRUCache {
    private int capacity;
    private DLLNode dummyHead;
    private DLLNode dummyTail;
    private Map<Integer, DLLNode> keyToNode;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        dummyHead = new DLLNode(-1, -1);
        dummyTail = new DLLNode(-1, -1);
        dummyHead.setNext(dummyTail);
        dummyTail.setPrev(dummyHead);

        keyToNode = new HashMap<>();
    }

    void put(int key, int val) {
        if (keyToNode.containsKey(key)) {
            DLLNode node = keyToNode.get(key);
            node.setVal(val);
            moveToTail(node);
            return;
        }
        
        if (capacity == 0) {
            removeFromHead();
            capacity++;
        }
        
        DLLNode newNode = new DLLNode(key, val);
        keyToNode.put(key, newNode);
        addToTail(newNode);
        capacity--;
    }

    int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }

        DLLNode node = keyToNode.get(key);
        moveToTail(node);
        return node.getVal();
    }

    private void moveToTail(DLLNode node) {
        DLLNode next = node.getNext();
        DLLNode prev = node.getPrev();

        prev.setNext(next);
        next.setPrev(prev);

        addToTail(node);
    }

    private void addToTail(DLLNode node) {
        DLLNode lastAccessedNode = dummyTail.getPrev();
        node.setPrev(lastAccessedNode);
        lastAccessedNode.setNext(node);
        node.setNext(dummyTail);
        dummyTail.setPrev(node);
    }

    private void removeFromHead() {
        DLLNode leastRecentlyAccessed = dummyHead.getNext();
        int key = leastRecentlyAccessed.getKey();
        keyToNode.remove(key);
        dummyHead.setNext(leastRecentlyAccessed.getNext());
        leastRecentlyAccessed.getNext().setPrev(dummyHead);
    }
}
