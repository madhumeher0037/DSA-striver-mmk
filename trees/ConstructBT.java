public class Main
{
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		Tree t = new Tree();
		Tree root = t.createTree(arr,0);
		t.InOrder(root);
	}
}
class Tree{
    int val;
    Tree left,right;
    Tree(){
        val=0;
        left=null;
        right=null;
    }
    public Tree createTree(int[] arr,int i){
        Tree root=null;
        if(i<arr.length){
            root = new Tree();
            root.val = arr[i];
            root.left = createTree(arr,(2*i)+1);
            root.right = createTree(arr,(2*i)+2);
        }
        return root;
    }
    public static void InOrder(Tree root){
        if(root==null) return;
        InOrder(root.left);
        System.out.print(root.val+" ");
        InOrder(root.right);
    }
}
