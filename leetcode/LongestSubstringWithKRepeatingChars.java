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
        
        char splitChar = '\0';
        for (int i = 0; i < 26; i++) {
            int c = count[i];
            if (c != 0 && c < k) {
                splitChar = (char)(c + 'a');
            }
        }

        if (splitChar == '\0') {
            return n;
        }
        
        int max = 0;
        
        for (String split: s.split("" + splitChar)) {
            max = Math.max(max, longestSubstring(split, k));
        }

        return max;
    }
}
