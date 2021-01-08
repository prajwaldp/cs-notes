// [1, 0, 0, 0, 0, 1]

// curr = 4, ans += (4 - 1) / 2
// curr = 3, ans += (3 - 1) / 2
// curr = 10, ans += 

// 0 1 2 3 4 5 6 7 8
// x x x x x x x x x
//   x   x   x   x

/**
 * Note: The greedy approach uses extra space or modifies the original array,
 * whereas this one does not.
 */

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int curr = 1, ans = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0) curr++;
            else {
                ans += (curr - 1) / 2;
                curr = 0;
                if (ans >= n) return true;
            }
        }

        curr += 1;
        ans += (curr - 1) / 2;
        return ans >= n;
    }
}
