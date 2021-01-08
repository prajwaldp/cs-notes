class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {
      return Integer.compare(a.val, b.val);
    });
    for (ListNode l: lists) {
      if (l != null) {
        pq.offer(l);
      }
    }

    ListNode dummyHead = new ListNode(-1);
    ListNode curr = dummyHead;

    while (!pq.isEmpty()) {
      ListNode nextSmallest = pq.poll();
      if (nextSmallest.next != null) {
        pq.offer(nextSmallest.next);
        nextSmallest.next = null;
      }
      curr.next = nextSmallest;
      curr = curr.next;
    }

    return dummyHead.next;
  }
}