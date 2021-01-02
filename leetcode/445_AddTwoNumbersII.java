class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();

        while (l1 != null) {
            s1.addLast(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.addLast(l2.val);
            l2 = l2.next;
        }

        ListNode ptr = null;
        int sum = 0;

        while (!s1.isEmpty() || !s2.isEmpty() || sum != 0) {
            if (!s1.isEmpty()) {
                sum += s1.removeLast();
            }
            if (!s2.isEmpty()) {
                sum += s2.removeLast();
            }

            Node n = new ListNode(sum % 10);
            n.next = ptr;
            ptr = n;
            sum /= 10;
        }

        return ptr;
    }
}