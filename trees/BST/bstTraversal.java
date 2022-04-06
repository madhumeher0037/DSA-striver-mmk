/*
    Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    public T data;
	    public BinaryTreeNode<T> left;
	    public BinaryTreeNode<T> right;

	    BinaryTreeNode(T data) {
	        this.data = data;
	        this.left = null;
	        this.right = null;
	    }
	}
*/
// As we know,In a bst, 
// "node.left.data < node.data < node.right.dat"
// so serachData lesser than node value,then we move to left
// if searchData greater than node value,then we move to right
// At some point our node data is equal to searchData then return true
// if not return false

public class Solution {
	public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
		// Write your code here.
//         if(root==null) return false;
//         if(root.data==x) return true;
//         else if(root.data<x) return searchInBST(root.right,x);
//         else return searchInBST(root.left,x);
        	while(root!=null && root.data!=x){
                root = root.data<x? root.right:root.left;
            }
        	return root==null?false:true;
	}
}