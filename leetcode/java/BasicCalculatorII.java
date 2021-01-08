import java.util.*;


class BasicCalculatorII {
    public int calculate(final String s) {
        // The trick is keep track of the sign before the current number
        // and not the one after
        int n = 0;
        char prevSign = '+';
        Deque<Integer> stack = new ArrayDeque<>();

        int j = s.length() - 1;
        while (j >= 0 && s.charAt(j) == ' ') {
            j--;
        }

        for (int i = 0; i <= j; i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                continue;
            }

            if (Character.isDigit(ch)) {
                n = n * 10 + ch - '0';

                if (i != j) {
                    continue;
                }
            }

            switch (prevSign) {
                case '+':
                    stack.addFirst(n);
                    break;

                case '-':
                    stack.addFirst(-1 * n);
                    break;

                case '*':
                    stack.addFirst(stack.removeFirst() * n);
                    break;

                case '/':
                    stack.addFirst(stack.removeFirst() / n);
                    break;
            }

            prevSign = ch;
            n = 0;
        }

        return stack.stream().mapToInt(i -> i).sum();
    }
}
