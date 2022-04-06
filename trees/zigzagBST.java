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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        boolean flag=false;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        res.add(new ArrayList<Integer>());
        res.clear();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> innerRes = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode n = q.poll();
                if(n.left!=null) q.offer(n.left);
                if(n.right!=null) q.offer(n.right);
                innerRes.add(n.val);
            }
            if(flag==true){
                Collections.reverse(innerRes);
                res.add(innerRes);
            }
            else res.add(innerRes);
            flag=!flag;
        }
        
        return res;
    }
    
}