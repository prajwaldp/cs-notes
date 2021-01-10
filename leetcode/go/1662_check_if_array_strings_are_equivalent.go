package main

func arrayStringsAreEqual(word1 []string, word2 []string) bool {
	var w1, w2, i, j int
	w1Len, w2Len := len(word1), len(word2)
	for w1 < w1Len && w2 < w2Len {
		if word1[w1][i] != word2[w2][j] {
			return false
		}

		i++
		j++

		if i == len(word1[w1]) {
			w1++
			i = 0
		}

		if j == len(word2[w2]) {
			w2++
			j = 0
		}

	}

	if w1 == w1Len && w2 == w2Len {
		return true
	}
	return false
}
