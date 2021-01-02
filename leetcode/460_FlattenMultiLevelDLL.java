class Solution {
    public Node flatten(Node head) {
        Node iter = head;
        while (iter != null) {
            Node following = iter.next;
            if (iter.child != null) {
                iter.next = flatten(iter.child);
                iter.next.prev = iter;
                iter.child = null;

                while (iter.next != null) {
                    iter = iter.next;
                }
            }
            if (following != null) {
                iter.next = following;
                following.prev = iter;
            }
            iter = iter.next;
        }

        return head;
    }
}