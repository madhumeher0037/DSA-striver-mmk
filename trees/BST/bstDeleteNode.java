/*************************************************************************
    Following is the class structure of the Node class:

	class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}
*************************************************************************/
// first search the parent of given node using any bst traversal method
// then link the parent left to child left,that will break bond of parent and child 
// before doing above step connect right subtree to left subtree rightmost element/node
// (Because right subtree elements are greater than the elements present in left substree)
// take care of the edge cases
public class Solution {
    public static BinaryTreeNode findParent(BinaryTreeNode curr,BinaryTreeNode parent,BinaryTreeNode child,int key){
        if((int)curr.data==key){
            return curr;
        }
        while(curr!=null){
            if((int)curr.data<key){
                if(curr.right!=null && (int)curr.right.data==key){
                    return curr;
				}
                else curr=curr.right;
            }
            else if((int)curr.data>key){
                if(curr.left!=null && (int)curr.left.data==key){
                    return curr;
                }
                else curr=curr.left;
            }        
		}
        return curr;
    }
    public static BinaryTreeNode<Integer> findLastRight(BinaryTreeNode<Integer> root){
        if(root.right!=null) root=findLastRight(root.right);
        return root;
    }
    public static BinaryTreeNode<Integer> helperToDelete(BinaryTreeNode<Integer> root){
        if(root.left==null) return root.right;
        else if(root.right==null) return root.left;
        BinaryTreeNode currRightNode = root.right;
        BinaryTreeNode currLastrightnode = findLastRight(root.left);
        currLastrightnode.right=currRightNode;
//         System.out.println("hello" );
        return root.left;
    }
	public static BinaryTreeNode<Integer> deleteNode(BinaryTreeNode<Integer> root, int key) {
		//Write your code here.
        if(root==null) return root;
        if((int)root.data==key) return helperToDelete(root);
        BinaryTreeNode parent =null,node=null,c=root;
        parent=findParent(c,parent,node,key);
//         System.out.println("hello" + parent);
        if(parent.left!=null && (int)parent.left.data==key) parent.left=helperToDelete(parent.left);
        else if(parent.right!=null && (int)parent.right.data==key) parent.right=helperToDelete(parent.right);
        return root;
	}
}