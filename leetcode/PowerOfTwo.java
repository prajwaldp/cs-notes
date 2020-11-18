public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        boolean seen = false;

        while (n != 0) {
            if ((n & 1) == 1) {
                if (seen) {
                    return false;
                }
                seen = true;
            }
            n >>= 1;
        }

        return true;
    }
}
