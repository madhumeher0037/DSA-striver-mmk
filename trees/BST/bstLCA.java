/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// It's a bst,so at the right we have elments greater than node and elements at left substree
// so conversly at left side we have smaller elements
// if two node values p and q are greater than the node value,then they present on the right side
// if they smaller then they present on left subtree
// if one of p and q is smaller than node and other one is greater,then that node is the LCA(LOWEST COMMON ANCESTOR)  
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr=null;
        if((p.val<root.val && q.val>root.val) || (p.val>root.val && q.val<root.val)) return root;
        else if(p.val==root.val || q.val==root.val) return root;
        else if(p.val<root.val && q.val<root.val) curr = lowestCommonAncestor(root.left,p,q);
        else if(p.val>root.val && q.val>root.val) curr = lowestCommonAncestor(root.right,p,q);
        return curr;
    }
}