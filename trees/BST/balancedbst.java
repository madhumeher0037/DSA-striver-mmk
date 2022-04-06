package BST;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static int checkBalanceTree(TreeNode root){
        if(root==null) return 0;
        // check if we reached the root Node if it is then return the 0
        
        int lh = checkBalanceTree(root.left);
        if(lh==-1) return -1;
        //at some point if we get -1 at left tree,then our tree is not balanced tree
        
        int rh = checkBalanceTree(root.right);
        if(rh==-1) return -1;
        //at some point if we get -1 at right tree,then our tree is not balanced tree
        
        if(Math.abs(lh-rh)>1) return -1;
//         if absoulte diff of left tree and right tree is greater than 1 then tree is not balanced tree
        
        return Math.max(lh,rh)+1;
    }
    public boolean isBalanced(TreeNode root){
        return checkBalanceTree(root)==-1?false:true;
    }
}