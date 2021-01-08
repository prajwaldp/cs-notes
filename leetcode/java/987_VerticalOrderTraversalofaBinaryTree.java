/**
 * Using BFS, n elements (each with an insert to a priority queue) => n log n
 * n polls from a priority queue => n log n
 * Total complexity = n log n
 */
class SolutionAlt {
  static class Data implements Comparable<Data> {
    TreeNode node;
    int x;
    int y;

    public Data(TreeNode node, int x, int y) {
      this.node = node;
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Data other) {
      if (this.x == other.x && this.y == other.y) {
        return Integer.compare(this.node.val, other.node.val);
      }
      if (this.x == other.x) {
        return this.y - other.y;
      }
      return this.x - other.x;
    }
  }

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Deque<Data> q = new ArrayDeque<>();
    PriorityQueue<Data> pq = new PriorityQueue<>();
    q.addLast(new Data(root, 0, 0));
    while (!q.isEmpty()) {
      Data nextNode = q.removeFirst();
      pq.offer(nextNode);
      if (nextNode.node.left != null) {
        q.addLast(new Data(nextNode.node.left, nextNode.x - 1, nextNode.y + 1));
      }
      if (nextNode.node.right != null) {
        q.addLast(new Data(nextNode.node.right, nextNode.x + 1, nextNode.y + 1));
      }
    }

    while (!pq.isEmpty()) {
      List<Integer> colData = new ArrayList<>();
      int x = pq.peek().x;
      while (!pq.isEmpty() && pq.peek().x == x) {
        colData.add(pq.poll().node.val);
      }
      result.add(colData);
    }

    return result;
  }
}

/**
 * Using DFS:
 * Space: O(n)
 * Time: w * h log h * ?
 */
class Solution {
  private int xStart = Integer.MAX_VALUE;
  private int xEnd = Integer.MIN_VALUE;

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    Map<Integer, Map<Integer, PriorityQueue<int[]>>> map = new HashMap<>();
    traverse(root, 0, 0, map);

    List<List<Integer>> ans = new ArrayList<>();
    for (int i = xStart; i <= xEnd; i++) {
      List<Integer> column = new ArrayList<>();
      for (var rowData : map.get(i).values()) {
        while (!rowData.isEmpty()) {
          column.add(rowData.poll()[0]);
        }
      }
      ans.add(column);
    }

    return ans;
  }

  public void traverse(TreeNode root, int x, int y,
                       Map<Integer, Map<Integer, PriorityQueue<int[]>>> map) {
    if (root == null) {
      return;
    }

    xStart = Math.min(xStart, x);
    xEnd = Math.max(xEnd, x);

    if (!map.containsKey(x)) {
      map.put(x, new TreeMap<>());
    }

    if (!(map.get(x).containsKey(y))) {
      map.get(x).put(y, new PriorityQueue<>((a, b) -> {
        return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
      }
      ));
    }

    map.get(x).get(y).offer(new int[]{root.val, y});
    traverse(root.left, x - 1, y + 1, map);
    traverse(root.right, x + 1, y + 1, map);
  }
}