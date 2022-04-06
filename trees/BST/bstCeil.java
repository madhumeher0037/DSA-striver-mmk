/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

// ceil is the smallest number among the nums greater than or equal to key value
// if key is lesser than node data we'll move to left to find the smallest num among greater nums than key   

public class Solution {

    public  static int findCeil(TreeNode<Integer> node, int x) {

        // Write your code here
        int ceil=-1;
        while(node!=null){
            if(x==node.data){
                ceil=x;
                break;
            }
			else if(x<node.data){
                ceil=node.data;
                node=node.left;
            }
            else  node=node.right;
        }
		return ceil;
    }
}
