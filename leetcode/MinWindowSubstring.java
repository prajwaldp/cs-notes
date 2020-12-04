class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || s.length() < t.length()) {
            return "";
        }
        
        int[] count = new int[128];
        for (char c: t.toCharArray()) {
            count[c]++;
        }
        
        int[] window = new int[128];
        int minLength = Integer.MAX_VALUE;
        int ansBegin = 0, ansEnd = 0;
        boolean found = false;
        
        for (int begin = 0, end = 0; end < s.length(); end++) {
            window[s.charAt(end)]++;
            
            boolean isValid = true;
            for (int i = 0; i < 128; i++) {
                if (count[i] > window[i]) {
                    isValid = false;
                    break;
                }
            }

            while (isValid && begin <= end) {
                found = true;
                if (minLength > end - begin + 1) {
                    minLength = end - begin + 1;
                    ansBegin = begin;
                    ansEnd = end;
                }

                window[s.charAt(begin++)]--;
                
                for (int i = 0; i < 128; i++) {
                    if (count[i] > window[i]) {
                        isValid = false;
                        break;
                    }
                }
            }
        }

        return found ? s.substring(ansBegin, ansEnd + 1) : "";
    }
}
