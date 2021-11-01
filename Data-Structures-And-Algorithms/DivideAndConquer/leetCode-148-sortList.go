/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func sortList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	fast, slow := head.Next.Next, head
	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
	}
	p1 := sortList(slow.Next)
	slow.Next = nil
	p2 := sortList(head)
	return merge(p1, p2)
}
func merge(p1, p2 *ListNode) *ListNode {
	dummy := &ListNode{0, nil}
	p := dummy
	for p1 != nil && p2 != nil {
		if p1.Val < p2.Val {
			p.Next = p1
			p1 = p1.Next
		} else {
			p.Next = p2
			p2 = p2.Next
		}
		p = p.Next
	}
	if p1 == nil {
		p.Next = p2
	}
	if p2 == nil {
		p.Next = p1
	}
	return dummy.Next
}