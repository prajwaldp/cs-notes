interface DSU {
  int find(int x);
  boolean union(int x, int y);
}

class NaiveDSU implements DSU {
  int[] parent;

  NaiveDSU(int n) {
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  @Override
  public int find(int x) {
    while (parent[x] != x) {
      x = parent[x];
    }
    return x;
  }

  @Override
  public boolean union(int x, int y) {
    if (find(x) == find(y)) {
      return false;
    }
    
    parent[find(x)] = find(y);
    return true;
  }
}


class OptimizedDSU implements DSU {
  int[] parent;
  int[] rank;
 
  OptimizedDSU(int n) {
    parent = new int[n];
    rank = new int[n];
    
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  @Override
  public int find(int x) {
    // Interesting: Path compression
    if (parent[x] != x) {
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }

  @Override
  public boolean union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);

    // If already in the same set
    if (rootX == rootY) {
      return false;
    }
    
    // Interesting: Union by rank
    // Keep the element with the higher rank as the identifier
    if (rank[rootX] < rank[rootY]) {
      parent[rootX] = rootY;
    } else if (rank[rootX] > rank[rootY]) {
      parent[rootY] = rootX;
    } else {
      parent[rootX] = rootY;
      rank[rootY]++;
    }
    
    return true;
  }
}

class Solution {
  
  public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length + 1;
    DSU dsu = new OptimizedDSU(n);
    
    for (int[] edge: edges) {
      if (!dsu.union(edge[0], edge[1])) {
        return edge;
      }
    }
    
    return new int[]{ };
  }
}
