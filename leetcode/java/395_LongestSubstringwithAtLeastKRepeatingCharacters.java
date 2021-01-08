/*
Longest Substring with At Least K Repeating Characters

Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is less than or equal to k.

s = dabaebbc
k = 2

d = 1
a = 2
b = 3
c = 1
e = 1

main:
    return s if k == 1
    start = 0
    end =  len(s) - 1
    return largest(s, start, end)

largest(s, start, end):
    if (valid) return length
    if (no character appears at least k times) return 0
    if (start == end) return 0
    return max(largest(d, start, end - 1), largest(d, start + 1, end))

dabaebbc
abaebbc         & dabaebb
abaebb & baebbc & abaebb & dabaeb
=> Overlapping sub problems

*/


class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        
        if (k == 1) return n;
        
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        int[][] cache = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1);
        }
        
        return longestSubstring(s, k, count, 0, s.length() - 1, cache);
    }

    private int longestSubstring(String s, int k, int[] count, int start, int end, int[][] cache) {
        if (start >= end) return 0;
        if (cache[start][end] != -1) {
            return cache[start][end];
        }

        boolean any = false, all = true;
        
        for (int i = start; i <= end; i++) {
            if (count[s.charAt(i) - 'a'] >= k) any = true;
            if (count[s.charAt(i) - 'a'] != 0 && count[s.charAt(i) - 'a'] < k) all = false;
        }

        if (all) {
            cache[start][end] = end - start + 1;
            return cache[start][end];
        }
        
        if (!any) {
            cache[start][end] = 0;
            return 0;
        }

        count[s.charAt(start) - 'a']--;
        int longestWithoutStart = longestSubstring(s, k, count, start + 1, end, cache);
        count[s.charAt(start) - 'a']++;
        
        count[s.charAt(end) - 'a']--;
        int longestWithoutEnd = longestSubstring(s, k, count, start, end - 1, cache);
        count[s.charAt(end) - 'a']++;

        cache[start][end] = Math.max(longestWithoutStart, longestWithoutEnd);
        return cache[start][end];
    }
}
