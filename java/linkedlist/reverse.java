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
    public ListNode reverseList(ListNode head) {
        return head = fun(head,null);
    }
    
    public static ListNode fun(ListNode curr,ListNode prev){
        if(curr==null) return prev;
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        return fun(curr,prev);
    }
}


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
    public ListNode reverseList(ListNode head) {
        ListNode d = null;
        while(head!=null){
            ListNode next=head.next;
            head.next=d;
            d=head;
            head=next;
        }
        return d;
    }
}