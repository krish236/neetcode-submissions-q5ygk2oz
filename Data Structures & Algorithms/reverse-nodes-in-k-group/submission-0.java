/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }


 1-2-3-4-5-6-7 k =3

 3-2-1-null

 node n = reverse(head);

 ListNode rev = reverse(prev,k);

head.next = rev;

return n

 7-6-5-4

 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return null;
        ListNode temp = head;
        for(int i = 0; i < k; i++){
            if(temp == null)
                return head;
            temp = temp.next;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        int cnt = 0;

        while(cnt<k && curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }

        ListNode node = reverseKGroup(curr,k);

        head.next = node;

        return prev;
    }
}
