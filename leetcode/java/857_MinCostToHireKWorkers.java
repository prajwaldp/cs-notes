/**
wage    = 50 70 40 30
quality =  2 10 20  5
ratio   = 25  7  2  6

ratios arranged in increasing order =
2 6 7 25
i j

If the employer can meet the condition for the jth worker, the employer can meet the condition of any ith worker as the ratio for the jth worker is more.

Why not just use a sliding window of size k now?
Suppose we have the following form (after sorting)
0 .... i - 1, i, i + 1 .... n - 1

If the ith ratio is good (the employer can satisfy k minimum wages upto the ith worker),
choosing k among sorted[0 .. i] is based on the quality.
A lower quality is a better result (the employer has to pay lesser).

And why do we have to process the rest of the array too?
Because we may be lucky to find very small quality numbers towards the end (offsetting the increase in ratio).
 */

class Solution {
    public double minCost(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        double cost = Double.MAX_VALUE;
        int totalQuality = 0;
        for (Worker w: workers) {
            totalQuality += worker.getQuality();
            maxHeap.offer(worker.getQuality());
            if (maxHeap.size() > k) totalQuality -= maxHeap.poll();
            if (maxHeap.size() == k) cost = Math.min(cost, w.getRatio() * totalQuality);
        }

        return cost;
    }
}

class Worker implements Comparator<Worker> {
    private int quality;
    private int wage;

    public Worker(int quality, int wage) {
        this.quality = quality;
        this.wage = wage;
    }

    public int getQuality() {
        return quality;
    }

    public double getRatio() {
        return (double) wage / quality;
    }

    public int compareTo(Worker other) {
        double ratio = this.getRatio();
        double otherRatio = other.getRatio();

        if (ratio < otherRatio) {
            return -1;
        } else if (ratio > otherRatio) {
            return 1;
        }
        return 0;
    }
}
