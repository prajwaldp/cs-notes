class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> codes = new ArrayList<>();
        Set<Integer> done = new HashSet<>();
        codes.add(0);
        done.add(0);
        for (int j = 1; j < Math.pow(2, n); j++) {
            int prev = codes.get(codes.size() - 1);
            for (int i = 0; i < n; i++) {
                int cand = prev ^ (1 << i);
                if (done.contains(cand)) continue;
                codes.add(cand);
                done.add(cand);
                break;
            }
        }
        return codes;
    }
}
