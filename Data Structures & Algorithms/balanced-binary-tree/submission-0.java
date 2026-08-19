/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int checkIsBalanced(TreeNode node)
    {
        if(node == null) return 0;

        // left height

        int leftHeight = checkIsBalanced(node.left);

        if(leftHeight == -1) return -1;

        // right height
        int rightHeight = checkIsBalanced(node.right);

        if(rightHeight == -1) return -1;

        // is current is not balance

        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        // else return height 

        return 1 + Math.max(leftHeight, rightHeight);
    }
    public boolean isBalanced(TreeNode root) {
        
        return checkIsBalanced(root) == -1 ? false : true;
    }
}

// height diff of any of the subtree must not differ , more than 1

// so we need height of left and right

// also we need to know for an node, if any of its left or right have encountered a false
// we dont need tp proceed with other 
// Both need to be handled with int
