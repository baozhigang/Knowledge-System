/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func diameterOfBinaryTree(root *TreeNode) int {
	ans := 0
	maxDepth(root, &ans)
	return ans
}
func maxDepth(node *TreeNode, ans *int) int {
	if node == nil {
		return 0
	}

	left := maxDepth(node.Left, ans)
	right := maxDepth(node.Right, ans)

	*ans = max(*ans, left+right)
	return max(left, right) + 1
}
func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}



