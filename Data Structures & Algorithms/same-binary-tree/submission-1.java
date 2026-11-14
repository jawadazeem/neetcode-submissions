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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        Deque<TreeNode> queueP = new ArrayDeque<>();
        Deque<TreeNode> queueQ = new ArrayDeque<>();
        queueP.add(p);
        queueQ.add(q);

        int levelSize;
        while (!queueP.isEmpty()) {
            levelSize = queueP.size();  

            for (int i=0; i<levelSize; i++) {
                TreeNode curP = queueP.poll();
                TreeNode curQ = queueQ.poll();

                if (curP == null || curQ == null ) {
                    if (!(curQ == null && curP == null)) {
                        return false;
                    }
                }

                if (curP.val != curQ.val) {
                    return false;
                }

                if (curQ.left != null) {
                    if (curP.left == null) {
                        return false;
                    }
                }

                if (curP.left != null) {
                    if (curQ.left == null) {
                        return false;
                    }

                    queueP.add(curP.left);
                    queueQ.add(curQ.left);
                }

                if (curQ.right != null) {
                    if (curP.right == null) {
                        return false;
                    }
                }

                if (curP.right != null) {
                    if (curQ.right == null) {
                        return false;
                    }

                    queueP.add(curP.right);
                    queueQ.add(curQ.right);
                }
            }
        }

        return true;
    }
}
