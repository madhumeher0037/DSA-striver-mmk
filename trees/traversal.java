import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int key){
        data=key;
    }
}
class pair{
    Node node;
    int num;
    pair(Node node,int num){
        this.node=node;
        this.num=num;
    }
}

class traversal {
    public static void allTraversal(Node root){
        Stack<pair> st = new Stack();
        st.push(new pair(root,1));

        List<Integer> pre = new ArrayList<Integer>();
        List<Integer> in = new ArrayList<Integer>();
        List<Integer> post = new ArrayList<Integer>();

        while(!st.isEmpty()){
            // pair p = st.pop();
            // first check if nodenum is 1 then store node data to preorder array
            // if its then increment and check there exit left node
            // if they push them to stack

            if(st.peek().num==1){
                pre.add(st.peek().node.data);
                st.peek().num++;
                if(st.peek().node.left!=null){
                    st.push(new pair(st.peek().node.left,1));
                }
            }

            // first check if nodenum is 2 then store node data to inorder array
            // if its then increment and check there exit right node
            // if they push them to stack

            else if(st.peek().num==2){
                in.add(st.peek().node.data);
                st.peek().num++;
                if(st.peek().node.right!=null){
                    st.push(new pair(st.peek().node.right,1));
                }
            }

            // first check if nodenum is 3 then store node data to post array
            // if its then pop from stack

            else{
                post.add(st.peek().node.data);
                st.pop();
            }
        }
        for(Integer item:pre) System.out.print(item+" ");
            System.out.println();
            for(Integer item:in) System.out.print(item+" ");
            System.out.println();
            for(Integer item:post) System.out.print(item+" ");
            System.out.println();
    }
    public static void preOrder(Node root){
        if(root==null) return;
        
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
        
        return;
    }
    public static void postOrder(Node root){
        if(root==null) return;
        
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
        
        return;
    }
    public static void inOrder(Node root){
        if(root==null) return;
        
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
        
        return;
    }
    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                System.out.print(q.poll().data+" ");
            }
        }
    }
    public static void preOrderIterative(Node root){
        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.empty()){
            Node temp = s.pop();
            if(temp.right!=null) s.push(temp.right);
            if(temp.left!=null) s.push(temp.left);
            System.out.print(temp.data+" ");
        }
    }
    public static void inOrderIterative(Node root){
        Stack<Node> s = new Stack<>();
        Node node = root;
        while(true){
            if(node!=null){
                s.push(node);
                node=node.left;
            }
            else{
                if(s.isEmpty()) break;
                node = s.pop();
                System.out.print(node.data+" ");
                node = node.right;
            }
        }
    }
    public static void postOrderIterative(Node root){
        Stack<Node> s1 = new Stack();
        Stack<Node> s2 = new Stack();
        s1.push(root);
        while(true){
            if(s1.isEmpty()) break;
            Node node = s1.pop();
            if(node.left!=null) s1.push(node.left);
            if(node.right!=null) s1.push(node.right);
            s2.push(node);
        }
        while(!s2.isEmpty()){
            System.out.print(s2.pop().data+" ");
        }
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right= new Node(4);
        root.left.left = new Node(5);
        root.left.left.left=new Node(10);
        root.right.right= new Node(7);
        root.right.left = new Node(9);
        root.right.left.left=new Node(50);
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        // levelOrder(root);
        // System.out.println();
        // preOrderIterative(root);
        // System.out.println();
        // inOrderIterative(root);
        // System.out.println();
        // postOrderIterative(root);
        allTraversal(root);
    }
}
