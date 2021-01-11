class Solution {
  static class DSU {
    int[] root;
    int[] rank;

    public DSU(int n) {
      this.root = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
      }
      this.rank = new int[n];
    }

    public int find(int x) {
      if (root[x] != x) {
        root[x] = find(root[x]);
      }
      return root[x];
    }

    public void union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);

      if (rootX == rootY) {
        return;
      }

      if (rank[rootX] < rank[rootY]) {
        root[rootX] = rootY;
      } else if (rank[rootX] > rank[rootY]) {
        root[rootY] = rootX;
      } else {
        root[rootX] = rootY;
        rank[rootY]++;
      }
    }
  }
  
  public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
    int n = source.length;
    DSU ds = new DSU(n);
    for (int[] swap: allowedSwaps) {
      ds.union(swap[0], swap[1]);
    }
    
    Map<Integer, List<Integer>> groups = new HashMap<>();
    for (int i = 0; i < n; i++) {
      groups.putIfAbsent(ds.find(i), new ArrayList<>());
      groups.get(ds.find(i)).add(i);
    }
    
    int swapsReq = 0;
    
    Map<Integer, Integer> count; 
    for (List<Integer> grouped: groups.values()) {
      count = new HashMap<>();
      for (int i: grouped) {
        count.put(source[i], count.getOrDefault(source[i], 0) + 1);
        count.put(target[i], count.getOrDefault(target[i], 0) - 1);
      }
      int groupSwapsReq = 0;
      for (int v: count.values()) {         
        groupSwapsReq += Math.abs(v);
      }
      swapsReq += groupSwapsReq / 2;
    }
    
    return swapsReq;
  }
}
