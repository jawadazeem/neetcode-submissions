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
    public int maxDiameter = 0;


    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxDepth = getHeight(root);
        return maxDiameter;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left) + 1;
        int right = getHeight(root.right) + 1;
        
        if (left + right - 2 > maxDiameter) {
            maxDiameter = left + right - 2;
        }

        return Math.max(left, right);
    }
}
