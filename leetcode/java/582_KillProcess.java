class Solution {
  public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int n = pid.size();
    for (int i = 0; i < n; i++) {
      // Optimization: We won't kill the parent process anyway
      if (pid.get(i) == kill) {
        continue;
      }
      graph.putIfAbsent(ppid.get(i), new ArrayList<>());

      // Optimization: Explicit check if the key is in the graph during the DFS
      // graph.putIfAbsent(pid.get(i), new ArrayList<>());

      graph.get(ppid.get(i)).add(pid.get(i));
    }

    List<Integer> killedProcesses = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    visited.add(kill);
    killedProcesses.add(kill);
    dfs(graph, kill, visited, killedProcesses);
    return killedProcesses;
  }

  private void dfs(Map<Integer, List<Integer>> graph, int curr, Set<Integer> visited,
                   List<Integer> path) {

    for (int neighbor: graph.get(curr)) {
      if (visited.contains(neighbor)) {
        continue;
      }
      visited.add(neighbor);
      path.add(neighbor);

      if (graph.containsKey(neighbor)) {
        dfs(graph, neighbor, visited, path);
      }
    }
  }
}

class SolutionAlt {
  public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int n = pid.size();
    for (int i = 0; i < n; i++) {
      // Optimization: We won't kill the parent process anyway
      if (pid.get(i) == kill) {
        continue;
      }
      graph.putIfAbsent(ppid.get(i), new ArrayList<>());

      // Optimization: Explicit check if the key is in the graph during the DFS
      // graph.putIfAbsent(pid.get(i), new ArrayList<>());

      graph.get(ppid.get(i)).add(pid.get(i));
    }

    List<Integer> killedProcesses = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    visited.add(kill);

    Deque<Integer> q = new ArrayDeque<>();
    q.addLast(kill);

    while (!q.isEmpty()) {
      int next = q.removeFirst();
      killedProcesses.add(next);
      if (graph.containsKey(next)) {
        for (int neighbor: graph.get(next)) {
          if (!visited.contains(neighbor)) {
            q.addLast(neighbor);
          }
        }
      }
    }

    return killedProcesses;
  }
}