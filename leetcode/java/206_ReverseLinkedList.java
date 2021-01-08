class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode iter = head, prev = null, following;
        while (iter != null) {
            following = iter.next;
            iter.next = prev;

            prev = iter;
            iter = following;
        }
        return prev;
    }
}