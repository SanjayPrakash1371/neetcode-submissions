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
    public int findHeight(TreeNode node, int[] maxPath)
    {
        if(node == null) return 0;

        // left 

        int lH = findHeight(node.left,maxPath );

        // right

        int rH = findHeight(node.right, maxPath);

        // update the max Path

        maxPath[0] = Math.max(maxPath[0], rH + lH);

        // return height

        return 1 + Math.max(lH, rH);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        
        int[] max = {0};
        findHeight(root,max);

        return max[0];
    }
}

// we need to know the left and right 
// aslo we need to maintain the max path 

// path dist leftHeight + right 
// height is max of them
// update the max Path
