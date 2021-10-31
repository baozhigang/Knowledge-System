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
        if (p == null && q == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(p);
        queue.add(q);
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
            queue.add(Right.left);

            queue.add(Left.right);
            queue.add(Right.right);
        }
        return true;
    }
}


