import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        
        // Arrays.sort(intervals, (x, y) -> x[0] -y[0]);
        // Arrays.sort(intervals, (x, y) -> {
        //     return x[0] - y[0];
        // });

        Arrays.sort(intervals, new Comparator<int[]> () {
            @Override
            public int compare(int[] x, int[] y) {
                return x[0] - y[0];
            }
        });

        int s = intervals[0][0];
        int e = intervals[0][1];

        for (int i = 0; i < n; i++) {
            if (intervals[i][0] > e) {
                res.add(new int[] {s, e});
                s = intervals[i][0];
                e = intervals[i][1];
            } else {
                e = Math.max(e, intervals[i][1]);
            }

            if (i == n - 1) {
                res.add(new int[] {s, e});
            }
        }

        int[][] resArray = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }
}
