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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    public int maxDepth(TreeNode node) {
        if (node == null) return 0;

        int Left = maxDepth(node.left);
        int Right = maxDepth(node.right);

        max = Math.max(max, Left+Right);
        return Math.max(Left, Right) + 1;
    }
}



