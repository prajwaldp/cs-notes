import java.io.*;
import java.util.*;

class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        final int MAX_FORWARD = 6000;
        
        Set<Integer> explored = new HashSet<>();
        for (int f: forbidden) explored.add(f);

        Deque<int[]> q = new ArrayDeque<>();
        // qi[0] is the position
        // qi[1] is the number of jumps with which that position was reached
        q.addLast(new int[] { 0, 0 });
        
        explored.add(0);

        while (!q.isEmpty()) {
            int[] next = q.removeFirst();
            int pos = next[0];
            int jumps = next[1];
            
            System.out.printf("%d(%d)\n", pos, jumps);

            if (pos == x) return jumps;
            if (pos - b == x) return jumps + 1;

            int nextPos;
            
            // jump forward
            nextPos = pos + a;
            if (!explored.contains(nextPos) && nextPos > 0 && nextPos <= MAX_FORWARD) {
                explored.add(nextPos);
                q.addLast(new int[] {nextPos, jumps + 1});
            }

            // jump backward
            int intermediatePos = pos - b;
            nextPos = pos - b + a;
            
            if (!explored.contains(nextPos) &&
                !explored.contains(intermediatePos) &&
                nextPos > 0 && nextPos <= MAX_FORWARD &&
                intermediatePos > 0) {
                
                explored.add(nextPos);
                // Do I add intermediate pos to explored?
                q.addLast(new int[] {nextPos, jumps + 2});
            }
        }
        
        return -1;
    }

    public static void main(String[] args) throws IOException, FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
        String[] f = br.readLine().split(",");
        int[] forbidden = new int[f.length];
        for (int i = 0; i < f.length; i++) forbidden[i] = Integer.parseInt(f[i]);
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int x = Integer.parseInt(br.readLine());

        int res = new Solution().minimumJumps(forbidden, a, b, x);
        System.out.println("\n" + res);
    }
}