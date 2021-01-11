/*
This is an NP-Complete problem (multi-knapsack) and can be solved for
the given constraints (k <= 12) using candidate solution enumeration.
To avoid TLE, certain optimizations can be applied for early prunning.
 */

class SolutionNaiveBacktracking {
  int minimumMaxTime;

  public int minimumTimeRequired(int[] jobs, int k) {
    minimumMaxTime = Integer.MAX_VALUE;
    int[] workers = new int[k];
    backtrack(0, 0, workers, jobs);
    return minimumMaxTime;
  }

  void backtrack(int job, int currMaxTime, int[] workers, int[] jobs) {
    if (job == jobs.length) {
      minimumMaxTime = Math.min(minimumMaxTime, currMaxTime);
      return;
    }

    for (int i = 0; i < workers.length; i++) {
      workers[i] += jobs[job];
      backtrack(job + 1, Math.max(currMaxTime, workers[i]), workers, jobs);
      workers[i] -= jobs[job];
    }
  }
}

class Solution {
  int minimumMaxTime;

  public int minimumTimeRequired(int[] jobs, int k) {
    minimumMaxTime = Integer.MAX_VALUE;
    int[] workers = new int[k];
    backtrack(0, 0, workers, jobs);
    return minimumMaxTime;
  }

  void backtrack(int job, int currMaxTime, int[] workers, int[] jobs) {
    // Optimization 1
    if (currMaxTime > minimumMaxTime) {
      return;
    }

    if (job == jobs.length) {
      minimumMaxTime = Math.min(minimumMaxTime, currMaxTime);
      return;
    }
    
    Set<Integer> currWorkLoad = new HashSet<>();
    for (int i = 0; i < workers.length; i++) {
      // Optimization 2
      if (currWorkLoad.contains(workers[i])) {
        continue;
      }
      currWorkLoad.add(workers[i]);
      
      workers[i] += jobs[job];
      backtrack(job + 1, Math.max(currMaxTime, workers[i]), workers, jobs);
      workers[i] -= jobs[job];
    }
  }
}
