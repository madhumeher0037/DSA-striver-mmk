/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode < Integer > {
        int data;
        BinaryTreeNode < Integer > left;
        BinaryTreeNode < Integer > right;

    public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/

public class Solution {
    public static int sumProp(BinaryTreeNode<Integer> root){
        if(root==null) return 0;
        int sum=0;
        if(root.left!=null) sum += root.left.data;
        if(root.right!=null) sum += root.right.data;
        if(sum>root.data){
            if(root.left!=null) root.left.data= sum;
            if(root.right!=null) root.right.data = sum;
            root.data=sum;
        }
        else{
            if(root.left!=null) root.left.data= root.data;
            if(root.right!=null) root.right.data = root.data;
        }
        sum=0;
        int leftVal = sumProp(root.left);
        int rightVal = sumProp(root.right);
        sum=leftVal+rightVal;
        if(sum>root.data){
			root.data=sum;
        }
        return root.data;
    }
    public static void changeTree(BinaryTreeNode < Integer > root) {
        // Write your code here.
        sumProp(root);
    }
}