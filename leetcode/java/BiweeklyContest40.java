import java.nio.ReadOnlyBufferException;
import java.util.Deque;

class Solution {
    public int maxRepeating(String seq, String word) {
        int count = 0;
        while (word.length() <= seq.length()) {
            if (seq.indexOf(word) == -1) {
                return count;
            }

            word += word;
            count++;
        }

        return count;
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummyHead = new ListNode(-1, list1);
        ListNode ptr1 = list1, ptr2 = list2;
        ListNode breakpoint1, breakpoint2;

        for (int i = 0; i < a - 1; i++) {
            ptr1 = ptr1.next;
        }
        breakpoint1 = ptr1;

        for (int i = a; i <= b; i++) {
            ptr1 = ptr1.next;
        }
        breakpoint2 = ptr1;

        breakpoint1.next = ptr2;
        while (ptr2.next != null) {
            ptr2 = ptr2.next;
        }
        ptr2.next = breakpoint2;

        return dummyHead.next;
    }
}

class FrontMiddleBackQueue {

    Deque<Integer> left;
    Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }
    
    public void pushFront(int val) {
        left.addFirst(val);
        rebalance();
    }
    
    public void pushMiddle(int val) {
        if (left.size() < right.size()) {
            left.addLast(val);
        } else {
            right.addFirst(val);
        }
    }
    
    public void pushBack(int val) {
        right.addLast(val);
        rebalance();
    }
    
    public int popFront() {
        int popped = left.removeFirst();
        rebalance();
        return popped;
    }
    
    public int popMiddle() {
        return left.size() == right.size() ? left.removeLast() : right.removeFirst();
    }
    
    public int popBack() {
        int popped = right.removeLast();
        rebalance();
        return popped;
    }

    private void rebalance() {
        int l = left.size(), r = right.size();
        if (r - l > 1) {
            left.addLast(right.removeFirst());
        }
    }
}