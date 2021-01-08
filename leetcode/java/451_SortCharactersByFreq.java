class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int currCount = freq.getOrDefault(ch, 0);
            freq.put(ch, currCount + 1);
        }

        Map<Integer, List<Character>> freqToCharMap = new TreeMap<>();
        for (Map.Entry<Character, Integer> entry: freq.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();

            freqToCharMap.putIfAbsent(count, new ArrayList<>());
            freqToCharMap.get(count).add(ch);
        }

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, List<Character>> entry: freqToCharMap.entrySet()) {
            int repeatCount = entry.getKey();
            List<Character> charsToRepeat = entry.getValue();

            for (char ch: charsToRepeat) {
                for (int i = 0; i < repeatCount; i++) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }

    public String frequencySortAlt(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        List<Character>[] bucket = new List[n + 1];
        for (Map.Entry<Character, Integer> entry: freq.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();

            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            if (bucket[i] != null) {
                for (char c: bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}