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

    public int findMaxdepth(TreeNode node)
    {
        if(node == null)  return 0;

        // find left
        int left = findMaxdepth(node.left);

        // find right
        int right = findMaxdepth(node.right);

        // return the 1 + Max of it

        return 1 + Math.max(left, right);
    }
    public int maxDepth(TreeNode root) {

        return findMaxdepth(root);
        
    }
}
// each node find its leftsubtree and right subtree , take the max of it , and do +1 and return