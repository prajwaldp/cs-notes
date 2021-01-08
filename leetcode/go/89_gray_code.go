func grayCode(n int) []int {
	a := make([]int, 1)

	for i := 0; i < n; i++ {
		currSize := len(a)

		for j := currSize - 1; j >= 0; j-- {
			a = append(a, a[j] | 1 << i)
		}
	}

	return a
}
