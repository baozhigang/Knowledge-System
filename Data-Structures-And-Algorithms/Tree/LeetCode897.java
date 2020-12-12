/**
 * 重点
 * 1.中序遍历把二叉树转为一个递增数组
 * 2.声明一个变量ans，指向0节点。变量cur也指向0节点
 * 3.指针变量cur的右节点指向1节点，然后当前指针cur右移一位
 * 4.循环下来，变量ans位置没变，他的右节点就是目标右子节点树状结构
 */

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List <Integer> list = new ArrayList<>();
        inorder(root, list);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v : list) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode root, List <Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
