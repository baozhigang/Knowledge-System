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
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 0) {
            TreeNode Left = queue.removeFirst();
            TreeNode Right = queue.removeFirst();
            if (Left == null && Right == null) {
                continue;
            }
            if ((Left == null || Right == null) || Left.val != Right.val) {
                return false;
            }
            queue.add(Left.left);
            queue.add(Right.right);

            queue.add(Left.right);
            queue.add(Right.left);
        }
        return true;
    }
}

