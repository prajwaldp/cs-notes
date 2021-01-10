package main

/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

func findRoot(tree []*Node) *Node {
	visited := make(map[*Node]bool)

	for _, node := range tree {
		if visited[node] {
			continue
		}

		q := make([]*Node, 0)
		q = append(q, node)

		for len(q) != 0 {
			next := q[0]
			q = q[1:]

			for _, child := range(next.Children) {
				if !visited[child] {
					visited[child] = true
					q = append(q, child)
				}
			}
		}
	}

	for _, node := range(tree) {
		if !visited[node] {
			return node
		}
	}

	return nil
}
