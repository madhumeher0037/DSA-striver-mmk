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
// floor is the greatest num among all nums which are smaller than the key
// when any value is lesser than key value we'll move to right,to find other values which are smmaller but greatest among them

public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        //    Write your code here.
        int floor=-1;
        while(root!=null){
            if(root.data==X){
                floor=X;
                break;
            }
            if(X>root.data){
                floor=root.data;
                root=root.right;
            }
            else{
                root=root.left;
            }
        }
        return floor;
    }
}