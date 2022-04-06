/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParents(Map<TreeNode,TreeNode> p,TreeNode root){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left!=null){
                p.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                p.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> pm = new HashMap<TreeNode,TreeNode>();
        markParents(pm,root);
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Map<TreeNode,Boolean> vis = new HashMap<TreeNode,Boolean>();
        // System.out.println(pm);
        vis.put(target,true);
        q.add(target);
        int currDis=0;
        while(!q.isEmpty()){
            if(currDis==k) break;
            currDis++;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(pm.get(curr)!=null && vis.get(pm.get(curr))==null){
                            // System.out.println("hello");

                    q.offer(pm.get(curr));
                    vis.put(pm.get(curr),true);
                }
                if(curr.left!=null && vis.get(curr.left)==null){
                            // System.out.println("hello");

                    q.offer(curr.left);
                    vis.put(curr.left,true);
                }
                 if(curr.right!=null && vis.get(curr.right)==null){
                             // System.out.println("hello");

                    q.offer(curr.right);
                    vis.put(curr.right,true);
                }
            }
        }
        // System.out.println(vis);
        // System.out.println(q);
        List<Integer> l = new ArrayList<Integer>();
        while(!q.isEmpty()) l.add(q.poll().val);
        return l;
    }
}