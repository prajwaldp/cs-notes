/*
Every connected component will have one node remaining if the removal is done optimally
Hence, maximum number of nodes that can be removed
= number of nodes - number of nodes remaining
= number of nodes - number of islands

[[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]

union(0, 1) root[0] = 1, size[1] = 1
union(0, 2) root[2] = 1, size[1] = 2
union(0, 4) root[4] = 1, size[1] = 3

*/
class Solution {
      static class DSU {
          public int[] root;
          public int[] size; // for the union-by-rank optimization
          public int count; // number of connected components
          
          public DSU(int n) {
              count = n;
              root = new int[n];
              size = new int[n];
              
              for (int i = 0; i < n; i++) {
                  root[i] = i;
              }
          }
          
          public int find(int i) {
              if (root[i] != i) {
                  root[i] = find(root[i]);
              }
              return root[i];
          }
          
          public void union(int i, int j) {
              int rooti = find(i);
              int rootj = find(j);
              
              if (rooti == rootj) {
                  return;
              }
              
              count--;
              // System.out.printf("union(%d, %d) ", i, j);
              
              if (size[rooti] < size[rootj]) {
                  root[rooti] = rootj;
                  // System.out.printf("root[%d] = %d\n", i, rootj);
              } else if (size[rootj] < size[rooti]) {
                  root[rootj] = rooti;
                  // System.out.printf("root[%d] = %d\n", j, rooti);
              } else {
                  root[rooti] = rootj;
                  size[rootj]++;
                  // System.out.printf("root[%d] = %d, size[%d] = %d\n", i, rootj, j, size[j]);
              }
          }
          
      }
      
      public int removeStones(int[][] stones) {
          int n = stones.length;
          DSU dsu = new DSU(n);
          for (int i = 0; i < n; i++) {
              for (int j = i + 1; j < n; j++) {
                  if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                      dsu.union(i, j);
                  }
              }
          }
          
          return n - dsu.count;
      }
  }