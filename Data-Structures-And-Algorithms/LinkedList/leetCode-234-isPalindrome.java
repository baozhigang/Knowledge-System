/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();
        while(head != null) {
            vals.add(head.val);
            head = head.next;
        }
        int left=0,right=vals.size()-1;
        while(left < right) {
            if (vals.get(left) != vals.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

