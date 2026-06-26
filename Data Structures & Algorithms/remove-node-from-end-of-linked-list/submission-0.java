/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }


 1-2-3-4-5-6-7
 n = 3

 remove 5th node;


 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = new ListNode(-1);
        slow.next = head;
        ListNode dummy = slow;
        ListNode fast = slow;

        int count = n;

        while(count>=0 && fast!=null){
            fast = fast.next;
            count--;
        }

        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }

        
        slow.next = slow.next.next;

        return dummy.next;
    }
}
