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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
       
       TreeNode parent = null;
       int me = 0; // 0 means left, 1 means right.
        TreeNode ref = root;
        if (root.val == key) {
            if (root.right != null) {
                tiniestDisplacement(root);
                return root;
            } else if (root.left != null){
                return root.left;
            } else {
                return null;
            }
        }
        
        while (root != null) {
            int v = root.val;
            if (v < key) {
                if (root.right == null) return ref;
                parent = root;
                root = root.right;
                me = 1;
            } else if (v > key) {
                if (root.left == null) return ref;
                parent = root;
                root = root.left;
                me = 0;
            } else {
                if (root.left == null || root.right == null) {
                    if (root.left == root.right) {
                        if (me == 0) parent.left = null;
                        if (me == 1) parent.right = null;
                    }
                    if (root.left == null) {
                        if (me == 0) parent.left = root.right;
                        if (me == 1) parent.right = root.right;
                    } else {
                        if (me == 0) parent.left = root.left;
                        if (me == 1) parent.right = root.left;
                    }
                } else {
                    tiniestDisplacement(root);
                }
                return ref;
            }
        }

        return ref;
    }

    private void tiniestDisplacement(TreeNode root) {
        TreeNode ref = root.right;
        TreeNode currParent = null;

        while (ref.left != null) {
            currParent = ref;
            ref = ref.left;
        }

        root.val = ref.val;
        if (currParent == null) {
            root.right = ref.right;
            return;
        }
        
        currParent.left = ref.right;
    }

}