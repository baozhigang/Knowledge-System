/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeElements(head *ListNode, val int) *ListNode {
	if head == nil {
		return nil
	}
	if head.Val == val {
		return removeElements(head.Next, val)
	} else {
		head.Next = removeElements(head.Next, val)
		return head
	}
}


