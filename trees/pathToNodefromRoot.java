/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public boolean findPath(TreeNode A,int B,ArrayList<Integer> l){
        if(A==null) return false;
        if(A.val==B){
            l.add(B);
            return true;
        }
        if(!l.contains(A.val)) l.add(A.val);
        if(findPath(A.left,B,l)) return true;
        if(findPath(A.right,B,l)) return true;
        l.remove(l.size()-1);
        return false;
    }
    public ArrayList<Integer> solve(TreeNode A, int B) {
        if(A.val==B) return new ArrayList<Integer>(A.val);
        ArrayList<Integer> res = new ArrayList<Integer>();
        findPath(A,B,res);
        return res;
    }
}
