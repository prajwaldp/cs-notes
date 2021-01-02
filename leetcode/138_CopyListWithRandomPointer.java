class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> origToClone = new HashMap<>();
        if (head == null) {
            return null;
        }
        
        for (Node curr = head; curr != null; curr = curr.next) {
            Node copy = new Node(curr.val);
            origToClone.put(curr, copy);
        }
        
        for (Node curr = head; curr != null; curr = curr.next) {
            Node copy = origToClone.get(curr);
            if (curr.next != null) {
                copy.next = origToClone.get(curr.next);
            }
            copy.random = origToClone.get(curr.random);
        }
        
        return origToClone.get(head);
    }

    public Node copyRandomListAlt(Node head) {
        for (Node iter = head; iter != null; iter = iter.next.next) {
            Node following = iter.next;
            Node clone = new Node(iter.val);
            iter.next = clone;
            clone.next = following;
        }

        for (Node iter = head; iter != null; iter = iter.next.next) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
        }

        Node copyHead = new Node(-1);
        Node copyIter = copyHead;

        for (Node iter = head; iter != null; iter = iter.next) {
            copyIter.next = iter.next;
            copyIter = copyIter.next;
            iter.next = iter.next.next;
        }

        return copyHead.next;
    }
}
