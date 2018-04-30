/**
 * Created by IntelliJ Idea.
 * User: Menard Feko
 * Date: 4/29/18
 * Time: 9:36 PM
 * Contact: fekomenard@yahoo.fr
 * .java was created for...
 */
public class Avltree
{
    public class Node {
        int data;
        Node left;
        Node right;
        int height;

        public Node(int data ){
            this(data,null,null);
        }
        public Node(int data, Node left,Node right){
            this.data=data;
            this.right= right;
            this.left= left;
            this.height = 0;
        }

    }
    private int Height(Node t){

        return t==null?-1: t.height;
    }
    Node root;
    public Node insert(int value){
        return root=insertrec(value,root);
    }
    public Node insertrec(int value, Node latestroot){
        if(latestroot==null)
            return latestroot= new Node(value,null,null);
        if(value<latestroot.data)
            latestroot.left=insertrec(value,latestroot.left);
        else if(value>latestroot.data)
             latestroot.right=insertrec(value,latestroot.right);


        return balancetree(latestroot);

    }
    public static int allowedbalance=1;

    public Node balancetree(Node node){
        if(node==null)return node;

        if(Height(node.right)-Height(node.left)>allowedbalance) {
            if (Height(node.right.right) >= Height(node.right.left)) {
                node = rotatewithright(node);
            } else node = doublerotateright(node);
        }
        else if(Height(node.right)-Height(node.left)>allowedbalance) {
            if (Height(node.left.left) >= Height(node.left.right)) {
                node = rotatewithleft(node);
            } else node = doublerotateleft(node);
        }
        node.height= Math.max( Height(node.left),Height(node.right))+1;
        return node;
        }
    public Node rotatewithright(Node k2){
        Node k1 = k2.right;
        k2.right= k1.left;
        k1.left = k2;
        k2.height = Math.max( Height(k2.right),Height(k2.left))+1;
        k1.height= Math.max(Height(k2),Height(k2.left))+1;
        return k1;

    }
    public Node rotatewithleft(Node k2){
        Node k1=k2.left;
        k2.left=k1.right;
        k1.right=k2;
        k2.height = Math.max(Height(k2.left),Height(k2.right))+1;
        k1.height=Math.max(Height(k2),Height(k1.right));
        return k1;
    }
    public Node doublerotateleft(Node k3){
        k3.left = rotatewithright(k3.left);
        return rotatewithleft(k3);
    }

    public Node doublerotateright(Node k3){
        k3.right = rotatewithright(k3.right);
        return rotatewithright(k3);
    }

    public void preorder(){
        preorder(root);
    }
    private void preorder(Node latestroot){
        if(latestroot!=null){
            System.out.println(latestroot.data);
            preorder(latestroot.left);
            preorder(latestroot.right);
        }

    }


    public static void main(String[] args){
        Avltree t = new Avltree();
        t.insert(20);
        t.insert(12);
        t.insert(13);
        t.insert(40);
        t.insert(18);
        t.insert(2);
        t.preorder();






    }
}

