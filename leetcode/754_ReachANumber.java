/**
 *
 * target = 14
 * 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28
 * flip 7 and you get 14
 *
 * target = 8
 * 1 + 2 + 3 + 4 = 10
 * flip 1 and you get 8
 *
 * Observation: Flipping just one number in the sequence gives the minimum number of moves
 */

class Solution {
    public int reachNumber(int target) {
        int step = 0, dis = 0;
        while (dis < target || (dis - target) % 2 != 0) {
            step++;
            dis += step;
        }
        return step;
    }
}
