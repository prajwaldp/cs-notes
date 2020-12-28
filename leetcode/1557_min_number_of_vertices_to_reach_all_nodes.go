package main

import "fmt"

func main() {
	edges := [][]int{
		{0, 1},
		{0, 2},
		{2, 5},
		{3, 4},
		{4, 2},
	}

	fmt.Printf("Ans = %v\n", findSmallestSetOfVertices(6, edges))
}

func findSmallestSetOfVertices(n int, edges [][]int) []int {
	indegrees := make([]int, n)
	for _, edges := range edges {
		indegrees[edges[1]]++
	}

	ans := make([]int, 0)

	for i := 0; i < n; i++ {
		if indegrees[i] == 0 {
			ans = append(ans, i)
		}
	}

	return ans;
}
