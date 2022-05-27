
class pair{
    int col;
    int row;
    TreeNode node;
    pair(int col,int row,TreeNode node){
        this.col = col;
        this.row = row;
        this.node = node;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<pair> q = new LinkedList<pair>();
        q.add(new pair(0,0,root));
        Map<Integer,Map<Integer,PriorityQueue<Integer>>> tm = new TreeMap<>();
        while(!q.isEmpty()){
        //  traverse the whole tree using any traversal method,store col/level as keys and priority queue which stores              
        // the node values of specific vertical vertex as a values to it.
        // store above hashmap as value to another hashMap with vertical/row as key
       
            pair p = q.poll();
            int row = p.row;
            int col = p.col;
            TreeNode node = p.node;
            if(!tm.containsKey(row)){
                tm.put(row,new TreeMap<>());
            }
            if(!tm.get(row).containsKey(col)){
                tm.get(row).put(col,new PriorityQueue<Integer>());
            }
            tm.get(row).get(col).offer(node.val);
            if(node.left!=null) q.offer(new pair(col-1,row+1,node.left));
            if(node.right!=null) q.offer(new pair(col+1,row+1,node.right));
        }
        // System.out.println(tm);
        Map<Integer,List<Integer>> tm1 = new TreeMap<>();
        for(Map<Integer,PriorityQueue<Integer>> e1:tm.values()){
            for(Map.Entry<Integer,PriorityQueue<Integer>> e:e1.entrySet()){
                if(!tm1.containsKey(e.getKey())) tm1.put(e.getKey(),new ArrayList<Integer>());
                PriorityQueue<Integer> p = e.getValue();
                while(!p.isEmpty()) tm1.get(e.getKey()).add(p.poll());
            }
            
        }
        // System.out.println(tm1);
        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> e:tm1.entrySet()){
            res.add(e.getValue());
        }
        return res;
    }
}