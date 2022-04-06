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
// for the kth largest number,we inorder traverse in reverse manner.first traverse to right nodes then root and then left
// right->root->left(Which will basically gives a sorted array in descending order)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] cnt = new int[1];
        int[] res = new int[1];
        inOrder(root,k,res,cnt);
        return res[0];
    }
    public static void inOrder(TreeNode node,int k,int[] res,int[] cnt){
        if(node==null) return;
        
        inOrder(node.left,k,res,cnt);
        
        if(++cnt[0]==k) res[0]=node.val;
        
        inOrder(node.right,k,res,cnt);
        
        return;
    }
}