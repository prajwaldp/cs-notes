import java.util.*;

class Solution {
    public int nextGreaterElement(int n) {
        return Solution.nextPermutation(n);
    }
    
    public static int nextPermutation(int num) {
        String nstr = Integer.toString(num);
        char[] nchars = nstr.toCharArray();
        int n = nchars.length;

        int inversionPt = n - 2;
        while (inversionPt >= 0 && nchars[inversionPt] > nchars[inversionPt + 1]) {
            inversionPt--;
        }

        if (inversionPt == -1) {
            return -1;
        }

        int firstGreater = n - 1;
        while (nchars[firstGreater] < nchars[inversionPt]) {
            firstGreater--;
        }

        char tmp = nchars[firstGreater];
        nchars[firstGreater] = nchars[inversionPt];
        nchars[inversionPt] = tmp;

        Arrays.sort(nchars, inversionPt + 1, n);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans * 10 + (nchars[i] - '0');
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int[][] testcases = {
            {12345, 12354},
            {12543, 13245},
            {15432, 21345},
            {21543, 23145},
            {38975, 39578},
            {54321, -1},
            {230241, 230412}
        };
        
        for (int[] tc: testcases) {
            System.out.printf("IP = %d, Want = %d, Got = %d\n", tc[0], tc[1], nextPermutation(tc[0]));
        }
    }
}
