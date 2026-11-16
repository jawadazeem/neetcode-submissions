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
        // smaller than the smaller of the two, move right
        // larger than both, go right.
        // anything else, you've found the time. O(n)
        int sm = Math.min(p.val, q.val);
        int lg = Math.max(p.val, q.val);

        while (root != null) {
            int val = root.val;

            if (val < sm) {
                root = root.right;
            } else if (val > lg) {
                root = root.left;
            } else {
                return root;
            }
        }
        return root;
    }
}
