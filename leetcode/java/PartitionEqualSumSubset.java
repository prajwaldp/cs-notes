import java.math.BigInteger;
import java.util.BitSet;

class SolutionTopDown {
    Map<Integer, Map<Integer, Boolean>> cache = new HashMap<>();
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }
        
        int target = sum / 2;
        return canPartition(nums, 0, n, target);
    }

    boolean canPartition(int[] nums, int startpos, int size, int target) {
        if (inCache(startpos, target)) {
            return cache.get(startpos).get(target);
        }

        if (target == 0) {
            setCache(startpos, target, true);
            return true;
        }

        if (target < 0 || startpos == size) {
            setCache(startpos, target, false);
            return false;
        }

        boolean ans = canPartition(nums, startpos + 1, size, target - nums[startpos]) ||
            canPartition(nums, startpos + 1, size, target);

        setCache(startpos, target, ans);
        return ans;
    }

    private boolean inCache(int startpos, int target) {
        if (cache.containsKey(startpos)) {
            if (cache.get(startpos).containsKey(target)) {
                return true;
            }
        }

        return false;
    }

    private void setCache(int startpos, int target, boolean val) {
        cache.putIfAbsent(startpos, new HashMap<>());
        cache.get(startpos).put(target, val);
    }
}

class SolutionBottomUp {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int item: nums) {
            sum += item;
        }
        int target = sum / 2;
        if (target % 2 != 0) {
            return false;
        }
        
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                // if (dp[i - 1][j] || j - nums[i - 1] >= 0 && dp[i - 1][j - nums[i - 1]]) {
                //     dp[i][j] = true;
                // }

                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
            
            if (dp[i][target]) {
                return true;
            }
        }

        return false;
    }

}

class SolutionBottomUp1D {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        for (int item: nums) {
            sum += item;
        }
        
        if (sum % 2 != 0) {
            return false;
        }
        
        int target = sum / 2;
        
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num: nums) {
            // Why go from high to low instead of low to high
            // If we go from high to low, dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
            // If we go from low to high, dp[i][j] = dp[i][j] || dp[i][j - nums[i - 1]];
            for (int j = target; j > 0; j--) {
                if (j - num >= 0) {
                    dp[j] = dp[j] || dp[j - num];
                }
            }
        }

        return dp[target];
    }
}

class SolutionBitSet {
    public boolean canPartition(int[] nums) {
        BigInteger bits = new BigInteger("1");
        int sum = 0;

        for (int num: nums) {
            sum += num;
            bits = bits.or(bits.shiftLeft(num));
        }

        return !(sum % 2 == 1) && bits.testBit(sum / 2);
    }
}
