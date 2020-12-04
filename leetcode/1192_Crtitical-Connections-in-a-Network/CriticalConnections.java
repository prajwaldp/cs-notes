import java.util.*;

class Solution {
    int timestamp;
    List<List<Integer>> ans;
    List<List<Integer>> graph;
    boolean[] visited;
    int[] dfsNum;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ans = new ArrayList<>();
        graph = new ArrayList<>();
        visited = new boolean[n];
        dfsNum = new int[n];
        timestamp = 0;
        
        // Build the adjacency graph
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (List<Integer> c: connections) {
            int u = c.get(0), v = c.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(0, -1);
        return ans;
    }

    void dfs(int node, int parent) {
        dfsNum[node] = timestamp++;
        visited[node] = true;
        int currentTimestamp = dfsNum[node];
        
        for (int neighbor: graph.get(node)) {
            if (neighbor == parent) continue;
            if (!visited[neighbor]) dfs(neighbor, node);
            dfsNum[node] = Math.min(dfsNum[node], dfsNum[neighbor]);
            if (dfsNum[neighbor] > currentTimestamp) {
                ans.add(Arrays.asList(node, neighbor));
            }
        }
    }
}
