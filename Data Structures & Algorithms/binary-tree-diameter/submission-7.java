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
    public int maxDepth = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);

        return maxDepth;
    }

    /* 
     * Answers: What is the max depth of this tree,
     * while also updating maxDepth for where it is at,
     * which involves computing the v (both legs)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ld = 1 + maxDepth(root.left);
        int rd = 1 + maxDepth(root.right);

        if (ld + rd - 2 > maxDepth) {
            maxDepth = ld + rd - 2;
        }

        return Math.max(ld, rd);
    }
}
