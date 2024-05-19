import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private TreeNode root;

    private static class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data = data;
        }

    }
    public BinaryTree(){
        this.root = null;
    }

    //recursive preOrder traversal
    public void preOrder(TreeNode root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);

    }

    //recursive postOrder traversal
    public void postOrder(TreeNode root){
        if(root == null) return;
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.data + " ");
    }

    //recursive inOrder traversal
    public void inOrder(TreeNode root){
        if( root == null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    //iterative preOrder traversal of binary tree
    public void iterativePreOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode temp ;
        while (!stack.isEmpty()){
            temp = stack.pop();
            System.out.print(temp.data+ " ");
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
    }

    //iterative inOrder traversal of binary tree
    public void iterativeInOrder(TreeNode root){
        if(root ==null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root ;
        while (!stack.isEmpty() || temp != null){
            if(temp!= null){
                stack.push(temp);
                temp = temp.left;
            }else {
                temp = stack.pop();
                System.out.print(temp.data+" ");
                temp = temp.right;
            }
        }
    }

    //iterative inOrder traversal of binary tree
    public void iterativePostOrder(TreeNode root){
        if(root == null) return;
    }

    public void levelwiseTraversal(TreeNode root){
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp ;
        while (!queue.isEmpty()){
            temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left!=null) queue.offer(temp.left);
            if(temp.right!= null) queue.offer(temp.right);

        }
    }
    public int findMax(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;

        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if (left>result){
            result = left;
        }
        if(right> result){
            result = right;
        }

        return result;

    }



    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        //creating a binary tree
        binaryTree.root = new TreeNode(1);
        binaryTree.root.left = new TreeNode(2);
        binaryTree.root.right = new TreeNode(3);
        binaryTree.root.left.right = new TreeNode(5);
        binaryTree.root.left.left = new TreeNode(4);
        binaryTree.root.right.left = new TreeNode(6);
        binaryTree.root.right.right = new TreeNode(7);


        System.out.println("Preorder traversal");
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        System.out.println("Postorder traversal");
        binaryTree.postOrder(binaryTree.root);
        System.out.println();
        System.out.println("Inorder traversal");
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        System.out.println("Preorder using iterative method:");
        binaryTree.iterativePreOrder(binaryTree.root);
        System.out.println();
        System.out.println("Inorder using iterative method:");
        binaryTree.iterativeInOrder(binaryTree.root);
        System.out.println();
        System.out.println("PostOrder using iterative method:");
        binaryTree.iterativePostOrder(binaryTree.root);
        System.out.println();
        System.out.println("Level wise Tree traversal: ");
        binaryTree.levelwiseTraversal(binaryTree.root);
        System.out.println();
        System.out.println("Maximum element in binary tree is: " +binaryTree.findMax(binaryTree.root));

    }
}


