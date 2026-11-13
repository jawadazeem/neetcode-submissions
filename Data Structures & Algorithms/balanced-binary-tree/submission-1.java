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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (dfs(root) == -1) {
            return false;
        }

        return true;
    }

    public int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int lh = dfs(root.left) + 1;
        int rh = dfs(root.right) + 1;

        if (dfs(root.left) == -1 || dfs(root.right) == -1) {
            return -1;
        }

        if (Math.abs(lh-rh) > 1) {
            return -1;
        }

        return Math.max(lh, rh);
    }
}
