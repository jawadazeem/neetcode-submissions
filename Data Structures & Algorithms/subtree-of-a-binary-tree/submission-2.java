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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return root == subRoot;
        }

        if (subRoot == null) return false;

        boolean leftGood = false;
        boolean rightGood = false;
        boolean same = false;

        if (root.val == subRoot.val) {
            same = checkDfs(root, subRoot);
        }

        leftGood = isSubtree(root.left, subRoot);
        rightGood = isSubtree(root.right, subRoot);

        return same || leftGood || rightGood;
    }

    public boolean checkDfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return root == subRoot;
        }

        if (subRoot == null) return false;

        boolean result = root.val == subRoot.val;

        boolean left = checkDfs(root.left, subRoot.left);
        boolean right = checkDfs(root.right, subRoot.right);

        return result && left && right;
    }
}
