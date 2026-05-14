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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode head = new ListNode(-1);
        ListNode node = head;
        int carry = 0;
        while(node1!=null && node2!=null){
            int sum = node1.val + node2.val;
            sum+=carry;
            carry = sum/10;
            sum = sum%10;
            System.out.println(carry);
            ListNode tmpNode = new ListNode(sum);
            node1 = node1.next;
            node2 = node2.next;
            node.next = tmpNode;
            node = node.next;
        }

        while(node1!=null){
            int sum = node1.val+carry;
            carry = sum/10;
            sum = sum%10;
            node1 = node1.next;

            ListNode tmpNode = new ListNode(sum);
            node.next = tmpNode;
            node = node.next;
        }
        while(node2!=null){
            int sum = node2.val+carry;
            carry = sum/10;
            sum = sum%10;
            node2 = node2.next;

            ListNode tmpNode = new ListNode(sum);
            node.next = tmpNode;
            node = node.next;
        }
        System.out.println(carry);
        if(carry>0){
            ListNode tmpNode = new ListNode(carry);
            node.next = tmpNode;
        }

        return head.next;
    }
}
