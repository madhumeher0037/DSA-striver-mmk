/**********************************************************	
	
	Following is the representation of Binary Tree Node:
 	
 	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}

*********************************************************/
import java.util.*;
public class Solution
{
    public static BinaryTreeNode markParents(HashMap<BinaryTreeNode,BinaryTreeNode> hm ,BinaryTreeNode root,int start){
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode<Integer> res = new BinaryTreeNode<Integer>(-1);
        q.add(root);
        while(!q.isEmpty()){
            BinaryTreeNode curr = q.poll();
            if((int)curr.data==start) res=curr;
            if(curr.left!=null){
                hm.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                hm.put(curr.right,curr);
                q.offer(curr.right);
            }
		}
        return res;
    }
    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
        // Write your code here.
        HashMap<BinaryTreeNode,BinaryTreeNode> pm = new HashMap<BinaryTreeNode,BinaryTreeNode>();
        BinaryTreeNode<Integer> res = markParents(pm,root,start);
        return timeTakenToBurn(pm,res);
    }
    public static int timeTakenToBurn(HashMap<BinaryTreeNode,BinaryTreeNode> pm,BinaryTreeNode res){
        HashMap<BinaryTreeNode,Boolean> vis = new HashMap<BinaryTreeNode,Boolean>();
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(res);
        vis.put(res,true);
        int currDis=0;
        while(!q.isEmpty()){
            int size=q.size();
            int l=0;
            for(int i=0;i<size;i++){
                BinaryTreeNode curr = q.poll();
                if(pm.get(curr)!=null && vis.get(pm.get(curr))==null){
                    l=1;
                    q.offer(pm.get(curr));
                    vis.put(pm.get(curr),true);
                }
                if(curr.left!=null && vis.get(curr.left)==null){
                    l=1;
                    q.offer(curr.left);
                    vis.put(curr.left,true);
                }
                if(curr.right!=null && vis.get(curr.right)==null){
                    l=1;
                    q.offer(curr.right);
                    vis.put(curr.right,true);
                }
            }
            if(l==1) currDis++;
        }
        return currDis;
    }
}