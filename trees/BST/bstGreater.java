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
// There is a pattern in the node,each node is equals to sum of its key value and all keys


// for a node has all greater values are present at right side and left node has greater values in parent nodes 
// and all right nodes of parent 

// first traverse right node ,add it to a refernce variable and store it in root
// Then traverse left node ,all greater values are stored in sum variable the add it curr node along with its val
// its simple inorder traversal

class Solution {
    public TreeNode convertBST(TreeNode root) {
        int[] sum = new int[1];
        slove(root,sum);
        return root;
    }
    public void slove(TreeNode root,int[] sum){
        if(root==null) return;
        slove(root.right,sum);
        sum[0]+=root.val;
        root.val=sum[0];
        // System.out.println(sum[0]);
        slove(root.left,sum);
        return;
    }
}