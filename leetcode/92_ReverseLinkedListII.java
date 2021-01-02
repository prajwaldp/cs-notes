class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode sublistHead = dummyHead;
        for (int i = 1; i < m; i++) {
            sublistHead = sublistHead.next;
        }

        ListNode iter = sublistHead.next;
        ListNode prev = null;
        ListNode tmp;

        for (int i = m; i <= n; i++) {
            following = iter.next;
            iter.next = prev;

            prev = iter;
            iter = following;
        }

        return dummyHead.next;
    }
}