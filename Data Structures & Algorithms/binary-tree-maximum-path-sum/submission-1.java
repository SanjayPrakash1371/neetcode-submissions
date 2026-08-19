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
    public int findMaxPathSum(TreeNode node, int[] maxPathSum)
    {
        if(node == null) return 0;

        // left

        int leftSum = findMaxPathSum(node.left, maxPathSum);

        // right

        int rightSum = findMaxPathSum(node.right, maxPathSum);


        // update maxSum

        if(leftSum < 0) leftSum = 0;

        if(rightSum < 0) rightSum = 0;

        maxPathSum[0] = Math.max(maxPathSum[0], node.val + leftSum+rightSum);

        // return maxSum

        return node.val + Math.max(leftSum ,rightSum);
    }
    public int maxPathSum(TreeNode root) {

        
        int[] max = {root.val};

        findMaxPathSum(root, max);

        return max[0];
    }
}

// need to find the path with max sum
// it also contains negative 
// neg and neg is more neg
// neg and pos will reduce the pos
// so dont consider neg

// find left and right side sum , if max update the maxSum
// return the sum of max sum back to the parent
