public class MinFibWithSumK {
    public int findMinFibonacciNumbers(int k) {
        int f1 = 1;
        int f2 = 2;
        int tmp;

        while (f1 + f2 <= k) {
            tmp = f1 + f2;
            f1 = f2;
            f2 = tmp;
        }

        int count = 1;
        while (k != 0) {
            if (k >= f2) {
                k -= f2;
                count++;
            } else {
                tmp = f2 - f1;
                f2 = f1;
                f1 = tmp;
            }
        }

        return count;
    }
}
