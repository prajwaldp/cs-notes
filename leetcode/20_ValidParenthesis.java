class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.addFirst(ch);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char prev = stack.removeFirst();
            if (ch == ')' && prev != '(') {
                return false;
            }
            if (ch == '}' && prev != '{') {
                return false;
            }
            if (ch == ']' && prev != '[') {
                return false;
            }
        }

        return stack.isEmpty();
    }
}