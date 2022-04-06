/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1=headA;
        ListNode l2=headB;
        HashMap<ListNode,Integer> hm1 = new HashMap();
        while(l1!=null){
            hm1.put(l1,l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            if(hm1.containsKey(l2)) return l2;
            l2=l2.next;
        }
        return l2==null?l2:l1;
        // ListNode l3=headB;
        // while(l1!=null){
        //     l1.val=(-1*l1.val);
        //     l1=l1.next;
        // }
        // int cnt=0;
        // while(l2!=null){
        //     if(l2.val<0){
        //         cnt++;
        //         break;
        //     }
        //     cnt++;
        //     l2=l2.next;
        // }
        // if(l2==null){
        //     l1=headA;
        //     while(l1!=null){
        //         l1.val=(-1*l1.val);
        //         l1=l1.next;
        //     }
        //     return l2;
        // }
        // while(cnt!=1){
        //     l3=l3.next;
        //     cnt--;
        // }
        // l1=headA;
        // while(l1!=null){
        //     l1.val=(-1*l1.val);
        //     l1=l1.next;
        // }
        // if(l2==null)  return l2;
        // return l3;
    }
}