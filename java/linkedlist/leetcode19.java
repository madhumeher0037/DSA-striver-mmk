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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode d = head;
        ListNode fast=d,slow=d;
        // Tortoise-haire Approach
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        if(fast==null) return d.next;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        ListNode node = slow.next;
        slow.next=slow.next.next;
        return head;
        // if(n==1){
        //     if(head.next==null) return head=null;
        //     ListNode temp1=null;
        //     ListNode temp2=head;
        //     while(temp2.next!=null){
        //         temp1=temp2;
        //         temp2=temp2.next;
        //     }
        //     temp1.next=null;
        //     return head;
        // }
        // ListNode prev=null;
        // ListNode curr = head;
        // ListNode next=null;
        // while(curr!=null)
        // {
        //     next=curr.next;
        //     curr.next=prev;
        //     prev=curr;
        //     curr=next;
        // }
        // head=prev;
        // ListNode temp1=null;
        // ListNode temp2=head;
        // while(n!=1)
        // {
        //     n--;
        //     temp1=temp2;
        //     temp2=temp2.next;
        // }
        // temp1.next=temp2.next;
        // prev=null;
        // curr = head;
        // next=null;
        // while(curr!=null)
        // {
        //     next=curr.next;
        //     curr.next=prev;
        //     prev=curr;
        //     curr=next;
        // }
        // head=prev;
        // return head;
    }
}