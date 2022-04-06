/****************************************************************

       Following is the class structure of the Node class:

       class Node {
	int data;
	Node next;
	Node child;

	public Node(int data) {
		this.data = data;
		this.next = null;
		this.child = null;
	}
}

*****************************************************************/
public class Solution {
    public static Node mergeSortLL(Node l1,Node l2){
        Node temp = new Node(0);
        Node res = temp;
        while(l1!=null && l2!=null){
            if(l1.data<l2.data){
                temp.child=l1;
                l1=l1.child;
                temp=temp.child;
            }
            else{
                temp.child=l2;
                l2=l2.child;
                temp=temp.child;
            }
        }
        if(l1==null) temp.child=l2;
        else temp.child=l1;
        return res.child;
    }
	public static Node flattenLinkedList(Node start) {
		 //Write your code here
        if(start==null || start.next==null) return start;
//         recursively go to the last node
//         on backtracking merge the last two linked list into one list
        start.next=flattenLinkedList(start.next);
//         merge the two linked list which are in bottom of every node by using merge sort technique of linked list
        start = mergeSortLL(start,start.next);
         
       	return start;
	}
}

