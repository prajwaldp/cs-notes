#include <limits.h>

/*
Returns the value of m / n
*/
int divide(int m, int n) {
    int final_ans = 0;
    int sp_ans; // sp = sub-problem
    int ans_sign = -1 * ((m > 0) ^ (n > 0));
    int n_copy;
    
    if (m == INT_MIN && n == -1) {
        return INT_MAX;
    }
    
    if (m != INT_MIN) {
        m = abs(m);    
    }
    n = abs(n);
    

    while (m >= n) {
        sp_ans = 1;
        n_copy = n;
        
        while (m >= n_copy) {
            // Cannot left shift n_copy if it's > 2^30
            if (n_copy > INT_MAX >> 1) {
                break;
            }
            n_copy <<= 1;
            sp_ans <<= 1;
        }

        m -= n_copy >> 1;
        final_ans += sp_ans >> 1;
    }
    
    if (ans_sign == -1) {
        final_ans = ~final_ans + 1; // Or just sign * final_ans
    }

    return final_ans;
}
