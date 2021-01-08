import java.util.*;

class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> explored = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        int level = 0;

        explored.addAll(Arrays.asList(deadends));
        queue.addLast("0000");

        StringBuilder sb;
        String curr;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                curr = queue.removeFirst();

                if (curr.equals(target)) {
                    return level;
                }

                if (explored.contains(curr)) {
                    continue;
                }

                explored.add(curr);

                sb = new StringBuilder(curr);

                for (int i = 0; i < 4; i++) {
                    int c = curr.charAt(i) - '0';
                    char c1 = (char) ((c + 1) % 10 + '0');
                    char c2 = (char) ((c + 9) % 10 + '0');
                    sb.setCharAt(i, c1);
                    queue.addLast(sb.toString());

                    sb.setCharAt(i, c2);
                    queue.addLast(sb.toString());
                }
            }

            level++;
        }

        return -1;
    }
}
