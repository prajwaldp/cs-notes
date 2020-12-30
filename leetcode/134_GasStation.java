class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int startingStation = 0;
        
        // The total cost from i = 0 to i = n - 1, can be -ve
        // used for determining if the circuit is possible
        int totalCost = 0;

        // The cost since a starting station was chosen
        // Must be reset if it becomes -ve
        int startCost = 0;
        
        for (int i = 0; i < n; i++) {
            totalCost += gas[i] - cost[i];
            startCost += gas[i] - cost[i];
            
            if (startCost < 0) {
                // Start over from the next station
                startCost = 0;
                startingStation = i + 1;
            }
        }

        return totalCost >= 0 ? startingStation : -1;
    }
}
