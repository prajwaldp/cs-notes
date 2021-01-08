class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] count = new int[26];
        
        char mostCommon = '\0';
        int maxCount = 0;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count[c - '0']++;

            if (count[c - '0'] > maxCount) {
                maxCount = count[c - '0'];
                mostCommon = c;
            }
        }

        if (maxCount > (n + 1) / 2) {
            return "";
        }

        int j = 0;
        
        StringBuilder sb = new StringBuilder();
        sb.setLength(n);
        
        while (count[mostCommon - '0'] > 0) {
            sb.setCharAt(j, mostCommon);
            j += 2;
            count[mostCommon - '0']--;
        }

        if (j > n) {
            j = 1;
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                sb.setCharAt(j, (char)(i + '0'));
                count[i]--;

                j += 2;
                if (j > n) {
                    j = 1;
                }
            }
        }

        return sb.toString();
    }
}
