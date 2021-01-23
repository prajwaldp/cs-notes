package main

func longestPalindrome(s string) string {
	n := len(s)
	state := make([][]bool, n)

	for i := 0; i < n; i++ {
		state[i] = make([]bool, n)
		state[i][i] = true
	}

	longestPalindromeLen := 0
	longestPalindromeStart := 0
	longestPalindromeEnd := 0

	for start := n; start >= 0; start-- {
		for dist := 1; dist < n-start; dist++ {
			end := start + dist

			if dist == 1 && s[start] == s[end] {
				state[start][end] = true
			} else if s[start] == s[end] {
				state[start][end] = state[start+1][end-1]
			}

			if state[start][end] && end-start+1 > longestPalindromeLen {
				longestPalindromeLen = end - start + 1
				longestPalindromeStart = start
				longestPalindromeEnd = end
			}
		}
	}

	return s[longestPalindromeStart : longestPalindromeEnd+1]
}
