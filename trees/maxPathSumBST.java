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
    public int maxPathSum(TreeNode root) {
        int[] s = new int[1];
        s[0]=Integer.MIN_VALUE;
        findSum(root,s);
        return s[0];
    }
    public static int findSum(TreeNode root,int[] s){
        if(root==null) return 0;
        
        int leftSum = Math.max(0,findSum(root.left,s));
        int rightSum = Math.max(0,findSum(root.right,s));
        
        s[0] = Math.max(s[0],root.val+leftSum+rightSum);
        
        return root.val+Math.max(leftSum,rightSum);
    }
}