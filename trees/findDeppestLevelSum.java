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
    public int deepestLeavesSum(TreeNode root) {
        Queue<pair> q = new LinkedList<pair>();
        pair p = new pair(root,1);
        q.offer(p);
        int d = deppestNode(root);
        int sum =0;
        while(!q.isEmpty()){
            pair p1 = q.poll();
            if(p1.level==d) sum+=p1.root.val;
            if(p1.root.left!=null){
                pair np = new pair(p1.root.left,p1.level+1);
                q.offer(np);
            }
            if(p1.root.right!=null){
                pair np = new pair(p1.root.right,p1.level+1);
                q.offer(np);
            }
        }
        return sum;
    }
    
    public static int deppestNode(TreeNode root){
        if(root==null) return 0;
        int l =0,r=0;
        l = 1+deppestNode(root.left);
        r = 1+deppestNode(root.right);
        
        return Math.max(l,r);
    }
}

class pair{
    TreeNode root;
    int level;
    pair(TreeNode v,int l){
        this.root=v;
        this.level=l;
    }
}