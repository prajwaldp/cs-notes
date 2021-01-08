public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }

    int lenA = calcLen(headA);
    int lenB = calcLen(headB);

    if (lenA > lenB) {
      ListNode tmp = headA;
      headA = headB;
      headB = tmp;
    }

    int lenDiff = Math.abs(lenA - lenB);

    while (lenDiff != 0) {
      headB = headB.next;
      lenDiff--;
    }

    while (headA != null) {
      if (headA == headB) {
        return headA;
      }

      headA = headA.next;
      headB = headB.next;
    }

    return null;
  }

  private int calcLen(ListNode head) {
    int len = 0;
    while (head != null) {
      head = head.next;
      len++;
    }
    return len;
  }
}