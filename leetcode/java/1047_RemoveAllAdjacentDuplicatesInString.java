class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty() || stack.getFirst() != ch) {
                stack.addFirst(ch);
            } else if (!stack.isEmpty() && stack.getFirst() == ch) {
                stack.removeFirst();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.removeFirst());
        }
        return sb.toString();
    }

    public String removeDuplicatesAlt(String s) {
        char[] chars = s.toCharArray();
        int j = 0;
        for (int i = 1; i < chars.length; i++) {
            if (j != -1 && chars[i] == chars[j]) {
                j -= 1;
            } else {
                chars[++j] = chars[i];
            }
        }

        return new String(chars, 0, j + 1);
    }
}