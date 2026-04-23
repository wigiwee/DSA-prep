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
        int carry = 0;
        ListNode prev = new ListNode(0, null);
        ListNode result = prev;
        int l1Val, l2Val;
        int sum;
        while(l1 != null || l2 != null){
            if(l1 == null){
                l1Val = 0;
            }else{
                l1Val = l1.val;
                l1 = l1.next;
            }
            if (l2 == null){
                l2Val =0;
            }else{
                l2Val = l2.val;
                l2 = l2.next;
            }

            sum = l1Val + l2Val + carry;
            carry = (sum/100)*10 + (sum%100)/10;
            ListNode newListNode = new ListNode((sum%100)%10, null);
            prev.next = newListNode;
            prev = newListNode;

        }
        if (carry != 0){
            ListNode newListNode = new ListNode(carry,null);
            prev.next = newListNode;
        }
        return result.next;
    }
}
