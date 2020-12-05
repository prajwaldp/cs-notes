import java.util.*;

/**
 * 
 * [[0,1],
 *  [1,0]]
 * 
 * [[0,1,0],
 *  [0,0,0],
 *  [0,0,1]]
 * 
 * [[1,1,1,1,1],
 *  [1,0,0,0,1],
 *  [1,0,1,0,1],
 *  [1,0,0,0,1]
 *  [1,1,1,1,1]],
 */

class Solution {
    public int shortestBridge(int[][] map) {
        int n = map.length;
        outerloop:
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] == 1) {
                    mark(map, r, c);
                    break outerloop;
                }
            }
        }

        Deque<int[]> q = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] == 1) {
                    q.addLast(new int[] {r, c});
                }
            }
        }

        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] next = q.removeFirst();
                int r = next[0];
                int c = next[1];

                if (r < 0 || c < 0 || r >= n || c >= n || map[r][c] == -2) continue;

                if (map[r][c] == -1) return dist - 1;

                map[r][c] = -2;
                q.addLast(new int[]{r + 1, c});
                q.addLast(new int[]{r - 1, c});
                q.addLast(new int[]{r, c + 1});
                q.addLast(new int[]{r, c - 1});
            }
        }

        return -1;
    }

    private void mark(int[][] map, int r, int c) {
        int n = map.length;
        if (r < 0 || c < 0 || r >= n || c >= n || map[r][c] == 0 || map[r][c] == -1) return;
        
        map[r][c] = -1;
        
        mark(map, r + 1, c);
        mark(map, r - 1, c);
        mark(map, r, c + 1);
        mark(map, r, c - 1);
    }
}
