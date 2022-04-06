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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] i = new int[1];
        return buildBst(preorder,Integer.MAX_VALUE,i);
    }
    public TreeNode buildBst(int[] preOrder,int highBound,int[] i){
        if(i[0]>=preOrder.length || preOrder[i[0]]>highBound) return null;
        TreeNode root = new TreeNode(preOrder[i[0]++]);
        root.left = buildBst(preOrder,root.val,i);
        root.right = buildBst(preOrder,highBound,i);
        
        return root;
    }
}