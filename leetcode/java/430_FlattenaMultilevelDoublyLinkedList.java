class Solution {
  public Node flatten(Node head) {
    Node iter = head;
    Deque<Node> stack = new ArrayDeque<>();
    while (iter != null) {
      if (iter.child == null) {
        if (iter.next == null) {
          break;
        }
        iter = iter.next;
        continue;
      }

      if (iter.next != null) {
        stack.addFirst(iter.next);
      }

      iter.next = iter.child;
      iter.child.prev = iter;
      iter.child = null;

      iter = iter.next;
    }

    while (!stack.isEmpty()) {
      iter.next = stack.removeFirst();
      iter.next.prev = iter;
      while (iter.next != null) {
        iter = iter.next;
      }
    }

    return head;
  }
}