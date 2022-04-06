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

// In the problem statement ,they given that the complexity must be less than O(n)
// Basically a complete binary tree is tree where all levels are fully filled except for the last level
// ,where nodes must present as left as possible in last level.

// so in this problem the algorithm check whether the left tree height and the right tree height are equal are not
// if they are equal that means all levels are fully filled including with last level using formula ( 2^heighOFTheLeftTree - 1)
// we can find the no of nodes
// if the are not equal, then we add 1 along we recursively call our function to left  and right sub trees,then 
// to perform above steps again.this recursiv call continues untill the height of left and right are equal.
// NOTE:In this problem ,Height is the no of nodes from leaf to root nodes.
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        
        int leftHeight = findLheight(root);
        int rightHeight = findRheight(root);
                // System.out.println(leftHeight);
        // System.out.println(rightHeight);

        // System.out.println((2^leftHeight)-1);
        if(leftHeight==rightHeight) return (int)Math.pow(2,leftHeight)-1;
        
        return 1+countNodes(root.left) +countNodes(root.right);
    }
    public int findLheight(TreeNode root){
        int cntH=0;
        while(root!=null){
            cntH++;
            root=root.left;
        }
        return cntH;
    }
    public int findRheight(TreeNode root){
        int cntH=0;
        while(root!=null){
            cntH++;
            root=root.right;
        }
        return cntH;
    }
}