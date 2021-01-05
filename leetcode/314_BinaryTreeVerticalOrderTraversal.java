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
      if (this.x == other.x) {
        return this.y - other.y;
      }
      return this.x - other.x;
    }
  }

  public List<List<Integer>> verticalOrder(TreeNode root) {
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


class Solution {
  private int leftLimit;
  private int rightLimit;
  public List<List<Integer>> verticalOrder(TreeNode root) {
    leftLimit = Integer.MAX_VALUE;
    rightLimit = Integer.MIN_VALUE;
    Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
    dfs(root, 0, 0, map);

    List<List<Integer>> ans = new ArrayList<>();
    for (int i = leftLimit; i <= rightLimit; i++) {
      List<Integer> colData = new ArrayList<>();
      for (List<Integer> values: map.get(i).values()) {
        colData.addAll(values);
      }
      ans.add(colData);
    }

    return ans;
  }

  private void dfs(TreeNode root, int x, int y,
                   Map<Integer, Map<Integer, List<Integer>>> map) {
    if (root == null) {
      return;
    }

    leftLimit = Math.min(leftLimit, x);
    rightLimit = Math.max(rightLimit, x);

    if (!map.containsKey(x)) {
      map.put(x, new TreeMap<Integer, List<Integer>>());
    }

    if (!(map.get(x).containsKey(y))) {
      map.get(x).put(y, new ArrayList<Integer>());
    }

    map.get(x).get(y).add(root.val);
    dfs(root.left, x - 1, y + 1, map);
    dfs(root.right, x + 1, y + 1, map);
  }
}