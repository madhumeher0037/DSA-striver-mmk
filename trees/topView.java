/************************************************************

    Following is the TreeNode class structure:

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

************************************************************/
import java.util.*;

class tuple{
    BinaryTreeNode node;
    int col;
    tuple(BinaryTreeNode node,int col){
        this.node = node;
        this.col=col;
    }
}
public class Solution {
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		// Write your code here.
        Queue<tuple> q = new LinkedList<tuple>();
        ArrayList<Integer> l = new ArrayList<Integer>();
        if(root==null) return l;
        Map<Integer,Integer> hm1 = new TreeMap<Integer,Integer>();
        tuple t = new tuple(root,0);
        q.offer(t);
        while(!q.isEmpty()){
            tuple t1 = q.poll();
            BinaryTreeNode node = t1.node;
            int col = t1.col;
            if(!hm1.containsKey(col)) hm1.put(col,node.val);
            
     		if(node.left!=null) q.offer(new tuple(node.left,col-1));
            if(node.right!=null) q.offer(new tuple(node.right,col+1));
        }
        for(Map.Entry<Integer,Integer> e : hm1.entrySet()){
            l.add((Integer)e.getValue());
        }
        return l;
	}
}