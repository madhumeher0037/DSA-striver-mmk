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
    public ListNode swapNodes(ListNode head, int k) {
        if(head.next==null || head==null) return head;
        ListNode k1=head;
        int cnt=1;
        while(cnt<k){
            k1=k1.next;
            cnt++;
        }
        ListNode slow=head,fast=k1;
        while(fast.next!=null){
           fast=fast.next;
            slow=slow.next;
        }
        int temp = k1.val;
        k1.val=slow.val;
        slow.val=temp;
        return head;
    }
}