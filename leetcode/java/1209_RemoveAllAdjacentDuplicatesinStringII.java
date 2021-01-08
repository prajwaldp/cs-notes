class StackElem {
    public char ch;
    public int count;

    public StackElem(char ch) {
        this.ch = ch;
        this.count = 1;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<StackElem> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty() || stack.getFirst().ch != ch) {
                stack.addFirst(new StackElem(ch));
            } else if (!stack.isEmpty() && stack.getFirst().ch == ch) {
                if (stack.getFirst().count == k - 1) {
                    stack.removeFirst();
                } else {
                    stack.getFirst().count++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            StackElem top = stack.removeFirst();
            while (top.count-- > 0) {
                sb.insert(0, top.ch);
            }
        }
        return sb.toString();
    }
}