/**
 * As soon as I saw the question, I thought the problem could be solved by DP.
 * But I saw Depth First Search as one of the tags,
 * and I realized I only need to keep track of the number of moves
 * 
 * Go bottom-up (as part of the left-right-root postorder traversal)
 * As you go up, keep track of the balance (-ve or +ve) that is going to be compensated for in the future
 * The absolute value of the balance number of moves is required to compensate for the +ve or -ve balance at that node
 */

class Solution {
  int numMoves = 0;
  
  public int distributeCoins(TreeNode root) {
    traverse(root);
    return numMoves;
  }
  
  int traverse(TreeNode root) {
    if (root == null) {
      return 0;
    }
    
    int leftBalance = traverse(root.left);
    int rightBalance = traverse(root.right);
    
    numMoves += Math.abs(leftBalance) + Math.abs(rightBalance);
    
    return leftBalance + rightBalance + root.val - 1;
  } 
}
