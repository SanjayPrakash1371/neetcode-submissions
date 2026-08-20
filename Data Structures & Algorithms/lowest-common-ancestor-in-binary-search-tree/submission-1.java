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


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode node = root;

        // make sure p is always smaller

        if(p.val > q.val)
        {
            TreeNode temp = p;
            p = q;
            q = temp;
        }

        while(node != null)
        {
            // if lca
             // greater 

            // smaller
            if(node.val >= p.val && node.val <= q.val){
                return node;
            }
            else if(node.val > p.val && node.val > q.val){
                node = node.left;
            }
            else{
                node = node.right;
            }


        }

        return null;
    }
}


// Imp plan
// Don need to rec , just to iterative and find the val
// we need to move the node eithe left or right

// if if node.val >= p and node.val <= q its lca return lca

// else 
// if node is > move left 
// if node is smaller move right 

// if null return null




// we know that it is a bst not a bt
// in bt we check the left and right complete , because we dont know where it lies
// in bst in not in some random order
// all left is smaller and all right is smaller

// there wont be duplicates

// so aways try to keep p as smaller and q as larger

// so for a  node , greater than p but lesser than q , it is the lca

// else if both are smaller go to left
// else both are larger go to right 
// dont go both the dire 
// we know for sure it lies on only one side 

