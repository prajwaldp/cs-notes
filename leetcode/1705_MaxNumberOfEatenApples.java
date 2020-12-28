import java.util.*;

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            return x[0] - y[0];
        });

        int ans = 0;
        int currDay = 0;
        int n = apples.length;
        
        while (!pq.isEmpty() || currDay < n) {
            if (currDay < n && apples[currDay] != 0) {
                pq.add(new int[] {currDay + days[currDay], apples[currDay]});
            }

            while (!pq.isEmpty() && pq.peek()[0] < currDay) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                int[] next = pq.peek();
                next[1]--;
                ans++;
                if (next[1] == 0) pq.poll();
            }

            currDay++;
        }
        return ans;
    }
}
