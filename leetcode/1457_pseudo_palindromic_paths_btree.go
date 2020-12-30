package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func pseudoPalindromicPaths(root *TreeNode) int {
	return preorder(root, 0)
}

func preorder(root *TreeNode, countState int) int {
	if root == nil {
		return 0
	}

	// Compute occurrences of each digit in the corresponding register
	countState ^= 1 << (root.Val - 1)

	if root.Left == nil && root.Right == nil {
		// Check parity with the XOR operation
		// Repetitions would have cancelled out each other making the
		// cumulative XOR equal to 0
		if countState&(countState-1) == 0 {
			return 1
		}
	}

	return preorder(root.Left, countState) +
		preorder(root.Right, countState)
}
