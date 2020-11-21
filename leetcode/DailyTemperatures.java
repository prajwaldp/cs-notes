public class DailyTemperatures {
    public int[] dailyTemperatures(int[] data) {
        int n = data.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // 1 2 3 2 1
        // 

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && data[stack.getFirst()] <= data[i]) {
                stack.removeFirst();
            }
            
            if (!stack.isEmpty()) {
                res[i] = stack.getFirst() - i;
            }
            
            stack.addFirst(i);
        }
        
        return res;
    }
}
