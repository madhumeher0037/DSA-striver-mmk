/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node it = head;
        Node front = head;
        while(it!=null){
            front = front.next;
            Node cpy = new Node(it.val);
            it.next=cpy;
            cpy.next=front;
            it=front;
        }
        it=head;
        while(it!=null){
            it.next.random=it.random==null?null:it.random.next;
            it=it.next.next;
        }
        Node pseudoNode = new Node(0);
        Node curr = pseudoNode;
        it=head;
        front=head;
        while(it!=null){
            front = it.next.next;
            curr.next = it.next;
            curr=curr.next;
            it.next = front;
            it=front;
        }
        return pseudoNode.next;
    }
}