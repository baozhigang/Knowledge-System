/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func inorderTraversal(root *TreeNode) []int {
	ret := []int{}
	var inOrder func(curr *TreeNode)
	inOrder = func(curr *TreeNode) {
		if curr == nil {
			return
		}
		inOrder(curr.Left)
		ret = append(ret, curr.Val)
		inOrder(curr.Right)
	}
	inOrder(root)
	return ret
}