import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) return res;
        int n = buildings.length;
        return findSkyline(buildings, 0, n - 1);
    }
    
    private List<List<Integer>> findSkyline(int[][] buildings, int lo, int hi) {
        List<List<Integer>> res = new LinkedList<>();
        
        if (lo > hi) return res;
        
        if (lo == hi) {
            res.add(List.of(buildings[lo][0], buildings[lo][2]));
            res.add(List.of(buildings[lo][1], 0));
            return res;
        }
        
        int mid = lo + (hi - lo) / 2;
        
        List<List<Integer>> left = findSkyline(buildings, lo, mid);
        List<List<Integer>> right = findSkyline(buildings, mid + 1, hi);
        
        int leftH = 0;
        int rightH = 0;

        int leftIdx = 0;
        int rightIdx = 0;
        
        while (leftIdx < left.size() && rightIdx < right.size()) {
            int x1 = left.get(leftIdx).get(0);
            int x2 = right.get(rightIdx).get(0);
            
            int x = Math.min(x1, x2);
            
            if (x1 < x2) {
                leftH = left.get(leftIdx++).get(1);
            } else if (x1 > x2) {
                rightH = right.get(rightIdx++).get(1);
            } else {
                leftH = left.get(leftIdx++).get(1);
                rightH = right.get(rightIdx++).get(1);
            }
            int h = Math.max(leftH, rightH); //important...
            
            if (res.isEmpty() || h != res.get(res.size() - 1).get(1)) {
                res.add(List.of(x, h));
            }
        }

        for (int i = leftIdx; i < left.size(); i++) {
            res.add(left.get(i));
        }

        for (int i = rightIdx; i < right.size(); i++) {
            res.add(right.get(i));
        }
        
        return res;
    }
}

// class Solution {
//     public List<List<Integer>> getSkyline(int[][] buildings) {
//         List<List<Integer>> res = new ArrayList<>(); // the answer to return

//         // why int[], because two buildings can have the same x value
//         Map<Integer, List<int[]>> map = new TreeMap<>();
//         for (int[] b: buildings) {
//             map.putIfAbsent(b[0], new ArrayList<>());
//             map.putIfAbsent(b[1], new ArrayList<>());
//             map.get(b[0]).add(b);
//             map.get(b[1]).add(b);
//         }

//         // a maxheap with comparator key = height
//         PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[2] - x[2]);
        
//         for (int x: map.keySet()) {
//             List<int[]> bx = map.get(x);
//             for (int[] b: bx) {
//                 // if left index
//                 if (b[0] == x) {
//                     pq.offer(b);
//                 } else {
//                     // b[1] should be x, i.e. the right index
//                     pq.remove(b);
//                 }

//                 // if last index
//                 if (pq.size() == 0) {
//                     res.add(List.of(x, 0));
//                 } else {
//                     int maxHeight = pq.peek()[2];
                    
//                     // if there is nothing before this
//                     // or if the max height changes
//                     if (res.size() == 0 || res.get(res.size() - 1).get(1) != maxHeight) {
//                         res.add(List.of(x, maxHeight));
//                     }
//                 }
//             }
//         }

//         return res;
//     }
// }