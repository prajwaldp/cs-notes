import java.util.*;

class Solution {
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] g = new String[n];

        for (int i = 0; i < n; i++) {
            g[i] = sc.nextLine();
        }

        sc.close();

        List<Integer> revReachable = new ArrayList<>();
        boolean[] vis = new boolean[n];

        for (int v = 0; v < n; v++) {
            
            revReachable.clear();
            revReachable.add(v);
            
            Arrays.fill(vis, false);
            vis[v] = true;
            
            for (int i = 0; i < revReachable.size(); i++) {
                // todo
            }
        }
    }
}
