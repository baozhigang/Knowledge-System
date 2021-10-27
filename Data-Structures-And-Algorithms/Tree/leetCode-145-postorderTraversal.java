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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        postOrder(root, list);
        return list;
    }
    public void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;

        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }
}

