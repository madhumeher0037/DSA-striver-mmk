/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // HashMap<ListNode,Integer> hm = new HashMap();
        // ListNode temp = head;
        // while(temp!=null){
        //     if(hm.containsKey(temp)) return true;
        //     hm.put(temp,temp.val);
        //     temp=temp.next;
        // }
        if(head==null) return false;
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow) return true;
        }
        return false;
    }
}