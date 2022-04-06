// Successor code
class Solution {
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        TreeNode successor = null;
        
        while (root != null) {
            
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        
        return successor;
    }
}
// Predecessor code
class Solution{
    public TreeNode inorderPredecesspr(TreeNode root,TreeNode p){
        TreeNode predecesor=null;
        while(root!=null){
            if(root.val>=p){
                root=root.left;
            }
            else{
                predecesor=root;
                root=root.right;
            }
        }
        return predecesor;
    }
}