class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        recur(curr, l1, l2);
        return dummy.next;
    }
    public void recur(ListNode dummy, ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return;
        if (l1 == null) {
            dummy.next = l2;
            return;
        }
        if (l2 == null) {
            dummy.next = l1;
            return;
        }
        if (l1.val < l2.val) {
            dummy.next = l1;
            recur(dummy.next, l1.next, l2);
        } else {
            dummy.next = l2;
            recur(dummy.next, l1, l2.next);
        }
    }
}
