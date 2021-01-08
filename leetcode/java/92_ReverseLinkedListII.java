class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummyHead = new ListNode(-1, head);
    ListNode sublistHead = dummyHead;

    for (int i = 1; i < m; i++) {
      sublistHead = sublistHead.next;
    }

    ListNode iter = sublistHead.next;

    for (int i = m ; i < n; i++) {
      ListNode tmp = iter.next;
      iter.next = iter.next.next;
      tmp.next = sublistHead.next;
      sublistHead.next = tmp;
    }

    return dummyHead.next;
  }
}