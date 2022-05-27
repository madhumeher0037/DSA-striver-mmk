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
// set the index for every node 
// then lenght of that width is last - first + 1
// to find index of left node  is currIndex*2+1
// to find index of right node  is currIndex*2+2
// inorder to overcome the over flow of indexes , we subtract the min of above level to curr level index 
class pair{
    int Ind;
    TreeNode node;
    pair(TreeNode node,int Ind){
        this.Ind = Ind;
        this.node = node;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> q = new LinkedList<pair>();
        q.offer(new pair(root,1));
        int maxLen = 1;
        while(!q.isEmpty()){
            int size = q.size();
            int minInd = q.peek().Ind;
            int first =0,last =0;
            for(int i=0;i<size;i++){
                int currIndex = q.peek().Ind - minInd;
                TreeNode node = q.peek().node;
                if(i==0) first = currIndex;
                if(i==size-1) last = currIndex;
                if(node.left!=null) q.offer(new pair(node.left,currIndex*2+1));
                if(node.right!=null) q.offer(new pair(node.right,currIndex*2+2));
                q.poll();
            }
            maxLen = Math.max(last-first+1,maxLen);
        }
        return maxLen;
    }
}public class widthOfTree {
    
}
