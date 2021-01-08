class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (x == 1 || n == 0) return 1;
        if (n == 1) return x;

        if (n < 0) {
            double partialAns = 1 / myPow(x, -(n / 2));
            if (n % 2 == 0) {
                return partialAns * partialAns;
            } else {
                return partialAns * partialAns * 1 / x;
            }
        }

        double partialAns = myPow(x, n / 2);
        return n % 2 == 0 ? partialAns * partialAns : partialAns * partialAns * x;
    }
}