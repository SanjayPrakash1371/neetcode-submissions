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

    public void findSumOfPaths(TreeNode node, int pathSum , int[] allPathSum)
    {
        if(node == null) return;
        
        // take the node sum + path sum


        pathSum = pathSum * 10 + node.val;

        // if leaf
        if(node.left == null && node.right == null)
        {
            allPathSum[0]+=pathSum;
        }

        else{

            findSumOfPaths(node.left, pathSum, allPathSum);

            findSumOfPaths(node.right, pathSum, allPathSum);
        }


        pathSum = pathSum / 10;

        return;


        // not a leaf
    }

    public int sumNumbers(TreeNode root) {
        
        int[] allPathSum = {0};

        findSumOfPaths(root, 0, allPathSum);

        return allPathSum[0];

    }
}

// Imp 
// do a back traking technique like 

// not a leaf 
// and the node into the sum 
// go to left 
// go to right 
// remove the curr node sum from the carried sum

// if leaf
// add the sum to the total Sum of all the paths 

// both the case remove the curr node sum from the carried sum



// we need to find all the root to leaf paths , and add it into one sum
// we need to go to all the root to leaf paths 
// we need to do back tracking 
// if its a leaf node , its a conclude state of a path

