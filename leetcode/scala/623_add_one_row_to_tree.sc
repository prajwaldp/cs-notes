object Solution {
  def addOneRow(root: TreeNode, v: Int, d: Int): TreeNode = {
    def dfs(root: TreeNode, currDepth: Int): Unit = {
      if (root == null) return
      
      if (currDepth == d - 1) {
        val l = root.left
        val r = root.right
        
        root.left = new TreeNode(v, _left = l)
        root.right = new TreeNode(v, _right = r)
        return
      }
      
      dfs(root.left, currDepth + 1)
      dfs(root.right, currDepth + 1)
    }
    
    if (d == 1) return new TreeNode(v, root)
    
    dfs(root, 1)
    return root
  }
}
