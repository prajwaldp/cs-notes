import java.io.*;
import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> canReachWith = new HashMap<>();
        for (int p: stones) canReachWith.put(p, new HashSet<>());
        canReachWith.get(0).add(0);

        for (int p: stones) {
            Set<Integer> ks = canReachWith.get(p);
            // System.out.printf("%d => %s\n", p, ks);
            for (int k: ks) {
                if (k - 1 != 0 && canReachWith.containsKey(p + k - 1)) {
                    canReachWith.get(p + k - 1).add(k - 1);
                }

                if (k != 0 && canReachWith.containsKey(p + k)) {
                    canReachWith.get(p + k).add(k);
                }

                if (k + 1 != 0 && canReachWith.containsKey(p + k + 1)) {
                    canReachWith.get(p + k + 1).add(k + 1);
                }
            }
        }

        return canReachWith.get(stones[stones.length - 1]).size() > 0;
    }
    
    public static void main(String[] args) throws IOException, FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String line;
        Solution s = new Solution();
        while ((line = br.readLine()) != null) {
            String[] ip = line.split(",");
            int[] stones = new int[ip.length];
            for (int i = 0; i < ip.length; i++) stones[i] = Integer.parseInt(ip[i]);
            boolean res = s.canCross(stones);
            System.out.println(res);
        }
    }
}
