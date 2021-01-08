class Solution {
    /*
    Returns the value of m / n
    */
    int divide(int m, int n) {
        int finalAns = 0;
        int spAns; // sp = sub-problem
        int ansSign = -1 * ((m > 0 ? 1 : 0) ^ (n > 0 ? 1 : 0));
        int nCopy;
        
        if (m == Integer.MIN_VALUE && n == -1) {
            return Integer.MAX_VALUE;
        }
        
        m = Math.abs(m);
        n = Math.abs(n);
        
        while (m >= n) {
            spAns = 1;
            nCopy = n;
            
            while (m >= nCopy) {
                // Cannot left shift n_copy if it's > 2^30
                if (nCopy > Integer.MAX_VALUE >> 1) {
                    break;
                }
                nCopy <<= 1;
                spAns <<= 1;
            }

            m -= nCopy >> 1;
            finalAns += spAns >> 1;
        }
        
        if (ansSign == -1) {
            finalAns = ~finalAns + 1; // Or just sign * final_ans
        }

        return finalAns;
    }
}