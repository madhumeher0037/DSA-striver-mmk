/*********************************************

    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

*********************************************/
// Same as top view,but here for every vertex we are going to store the last value instead of storing the first values in 
// top view
import java.util.*;
class tuple{
    int col;
    BinaryTreeNode node;
    tuple(int col,BinaryTreeNode node){
		this.col = col;
        this.node = node;
    }
}
public class Solution { 
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
         // Write your code here. 
        TreeMap<Integer,BinaryTreeNode> hm = new TreeMap<Integer,BinaryTreeNode>();
        Queue<tuple> q = new LinkedList<tuple>();
        q.offer(new tuple(0,root));
        while(!q.isEmpty()){
            tuple t = q.poll();
            int col = t.col;
            BinaryTreeNode node = t.node;
            hm.put(col,node);
            if(node.left!=null) q.offer(new tuple(col-1,node.left));
            if(node.right!=null) q.offer(new tuple(col+1,node.right));
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(Map.Entry<Integer,BinaryTreeNode> e:hm.entrySet()){
            res.add(e.getValue().val);
        }
        return res;
    }
}
