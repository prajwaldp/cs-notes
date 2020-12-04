type Node struct {
 	Val int
 	Left *Node
 	Right *Node
 	Next *Node
}

func connect(root *Node) *Node {
	var startOfNextLevel, curr, lastVisited *Node
	startOfNextLevel = root

	for startOfNextLevel != nil {
		curr = startOfNextLevel
		
		startOfNextLevel = nil
		lastVisited = nil
        
        for curr != nil {
            children := [2]*Node {curr.Left, curr.Right}

            for _, child := range(children) {
                if child != nil {
                    if lastVisited == nil {
                        startOfNextLevel = child
                    } else {
                        lastVisited.Next = child
                    }

                    lastVisited = child
                }
            }
            
            curr = curr.Next
        }
	}
	
	return root;
}
