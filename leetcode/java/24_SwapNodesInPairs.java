class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    
    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode node1 = head, node2 = null, sublistHead = dummyHead;

        while (sublistHead.next != null) {
            node1 = sublistHead.next;
            if (node1.next == null) {
                break;
            }
            node2 = node1.next;
            ListNode following = node2.next;

            sublistHead.next = node2;
            node2.next = node1;
            node1.next = following;
            sublistHead = node1;
        }


        return dummyHead.next;
    }
}

