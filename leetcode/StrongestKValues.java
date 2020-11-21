import java.util.*;

public class StrongestKValues {
    public int[] getStrongest(int[] arr, int k) {
        /**
         * A value arr[i] is stronger than arr[j] if
         * 1. abs(arr[i] - m) > abs(arr[j] - m)
         * 2. arr[i] > arr[j] if abs(arr[i] - m) == abs(arr[j] - m)
         * [-7,22,17,3]
         * [-7,3,17,22] median = 3
         * 10, 0, 14, 19
         */

        int n = arr.length;
        int lo = 0;
        int hi = n - 1;
        int median;
        
        Arrays.sort(arr);

        median = arr[hi / 2];
        int[] res = new int[k];

        while (k > 0) {
            int a = Math.abs(arr[lo] - median);
            int b = Math.abs(arr[hi] - median);

            if (a <= b) {
                res[k--] = arr[hi--];
            } else {
                res[k--] = arr[lo++];
            }
        }

        return res;
    }
}
