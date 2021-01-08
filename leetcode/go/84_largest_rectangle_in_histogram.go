package main

type Rect struct {
	X int // x coordinate of the start position
	H int // height of the rectangle
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func largestRectangleArea(heights []int) int {
    n, maxArea := len(heights), 0
    stack := make([]Rect, 0)

	for i := 0; i <= n; i++ {
		startPos := i

        for len(stack) != 0 && (i == n || stack[len(stack)-1].H > heights[i]) {
            prevRect := stack[len(stack)-1]
			maxArea = max(maxArea, (i-prevRect.X)*prevRect.H)
			stack = stack[:len(stack)-1]  // stack.Pop
            startPos = prevRect.X
		}
        
        if i != n {
            stack = append(stack, Rect{startPos, heights[i]})  // stack.Push
        }
	}

	return maxArea
}
