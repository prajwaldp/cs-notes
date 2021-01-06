class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummyHead = new ListNode(-1, head);
    ListNode curr = head;
    ListNode prev = dummyHead;

    while (curr != null) {
      while (curr.next != null && curr.val == curr.next.val) {
        curr = curr.next;
      }

      if (prev.next == curr) {
        prev = prev.next;
      } else {
        prev.next = curr.next;
      }

      curr = curr.next;
    }
    return dummyHead.next;
  }
}