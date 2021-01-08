class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int a = A.length;
        int b = B.length;

        // Let A be the smaller array
        if (a > b) {
            return findMedianSortedArrays(B, A);
        }

        // partitonA + partitionB should be equal to (a + b + 1) / 2
        int lo = 0;
        int hi = a;

        while (lo <= hi) {
            int partitionA = lo + (hi - lo) / 2;
            int partitionB = (a + b + 1) / 2 - partitionA;

            int maxLeftA = partitionA == 0 ? Integer.MIN_VALUE : A[partitionA - 1];
            int minRightA = partitionA == a ? Integer.MAX_VALUE : A[partitionA];

            int maxLeftB = partitionB == 0 ? Integer.MIN_VALUE : B[partitionB - 1];
            int minRightB = partitionB == b ? Integer.MAX_VALUE : B[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((a + b) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                hi = partitionA - 1;
            } else {
                lo = partitionA + 1;
            }
        }

        return -1;
    }
}
