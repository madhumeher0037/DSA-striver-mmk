import java.util.*;

class Main{
    public static void main(String[] args){
        BinarySearchTree t = new BinarySearchTree();
        t.insert(50);
        t.insert(30);
        t.insert(20);
        t.insert(40);
        t.insert(70);
        t.insert(60);
        t.insert(80);
        t.InOrder();
    }
}
class Node{
    int val;
    Node left,right;
    Node(int v){
        this.val = v;
        this.left = null;
        this.right = null;
    }
}
class BinarySearchTree{
    Node root;
    BinarySearchTree(){
        root = null;
    }
    BinarySearchTree(int val){
        root = new Node(val);
    }
    public void insert(int key){
        root = insertRec(root,key);
    }
    public Node insertRec(Node root,int key){
        if(root==null){
            root = new Node(key);
            return root;
        }
        
        if(key<root.val) root.left = insertRec(root.left,key);
        else root.right = insertRec(root.right,key);
        return root;
    }
    public void InOrder(){
        callInOrder(root);
        return;
    }
    public void callInOrder(Node root){
        if(root==null) return;
        callInOrder(root.left);
        System.out.print(root.val+" ");
        callInOrder(root.right);
    }
}