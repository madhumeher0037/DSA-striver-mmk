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
class tuple{
    TreeNode node;
    int row;
    int col;
    tuple(TreeNode node,int row,int col){
        this.node = node;
        this.row=row;
        this.col=col;
    }
}
// row is vertical
// col is level
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> hm = new TreeMap<>();
        tuple p = new tuple(root,0,0);
        // traverse the whole tree using any traversal method,store col/level as keys and priority queue which stores              
        // the node values of specific vertical vertex as a values to it.
        // store above hashmap as value to another hashMap with vertical/row as key
        Stack<tuple> s = new Stack<tuple>();
        s.push(p);
        while(!s.isEmpty()){
            tuple t = s.pop();
            TreeNode node = t.node;
            int row = t.row;
            int col = t.col;
            
            if(!hm.containsKey(row)) hm.put(row, new TreeMap<>());
            
            if(!hm.get(row).containsKey(col)) hm.get(row).put(col,new PriorityQueue<Integer>());
            
            hm.get(row).get(col).offer(node.val);
            
            if(node.right!=null) s.push(new tuple(node.right,row+1,col+1));
            if(node.left!=null) s.push(new tuple(node.left,row-1,col+1));
    
        }
        
        
        // Level order traversal
//         Queue<tuple> q = new LinkedList<tuple>();
//         q.add(p);
//         while(!q.isEmpty()){
//             tuple t = q.poll();
//             TreeNode node = t.node;
//             int row = t.row;
//             int col = t.col;
            
//             if(!hm.containsKey(row)) hm.put(row, new TreeMap<>());
            
//             if(!hm.get(row).containsKey(col)) hm.get(row).put(col,new PriorityQueue<Integer>());
            
//             hm.get(row).get(col).offer(node.val);
            
//             if(node.left!=null){
//                 tuple t1 = new tuple(node.left,row-1,col+1);
//                 q.offer(t1);
//             }
//             if(node.right!=null){
//                 tuple t1 = new tuple(node.right,row+1,col+1);
//                 q.offer(t1);
//             }
//         }
        
        
        
        // try get the values from priority queue store them in list
        List<List<Integer>> l = new ArrayList<>();
        l.add(new ArrayList<Integer>());
        l.clear();
        for(TreeMap<Integer,PriorityQueue<Integer>> e : hm.values()){
            List<Integer> innerRes = new ArrayList<Integer>();
            for(PriorityQueue<Integer> e1:e.values()){
                while(!e1.isEmpty()) innerRes.add(e1.poll());
            }
            l.add(innerRes);
        }
        return l;
    }
}