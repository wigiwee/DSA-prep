public class BinarySearchTree {
    private TreeNode root;

    public static class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
    }
    public BinarySearchTree(){
        this.root = null;
    }
    public void insert(int data){
        TreeNode newNode = new TreeNode(data);
        if(this.root == null){
            this.root = newNode;
            return;
        }
        TreeNode temp = this.root;
        while (true){
            if(temp.data > data){
                if(temp.left==null){
                    temp.left = newNode;
                    break;
                }else {
                    temp = temp.left;
                }
            }
            if(temp.data<=data){
                if(temp.right ==null){
                    temp.right = newNode;
                    break;
                }else {
                    temp = temp.right;
                }
            }
        }
    }
    public boolean search(int data){
        TreeNode temp  = this.root;
        while (temp!= null){
            if(temp.data == data)
                return true;
            if(temp.data> data){
                temp = temp.left;
            }else
                temp = temp.right;
        }

        return false;
    }
    public TreeNode searchRecursively(TreeNode root , int data){
        if(root == null){
            return null;
        }
        if(root.data == data){
            return root;
        }
        if(root.data> data)
            return  searchRecursively(root.left , data);
        if(root.data <= data)
            return searchRecursively(root.right, data);
        return null;
    }
    public TreeNode insertRecursively(TreeNode root, int data){
        if(root == null){
            root = new TreeNode(data);
            return root;
        }
        if(data< root.data){
            root.left = insertRecursively(root.left , data);
        }else {
            root.right = insertRecursively(root.right, data);
        }
        return  root;
    }
    /* Given the root of the binary serach tree check whether the
    binary search tree is valid or not?
     */
    public boolean validateBST(TreeNode root){
        if(root == null){
            return false
        }
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(6);
        bst.insert(4);
        bst.insert(3);
        bst.insert(66);
        bst.insert(23);
        bst.insert(9);
        bst.insert(2);
        bst.insert(87);
        bst.insert(30);
        bst.insert(32);
        bst.insert(75);
        System.out.println(bst.root.data);
        System.out.println(bst.root.left.data);
        System.out.println(bst.root.right.data);
        System.out.println(bst.search(75));
        System.out.println(bst.searchRecursively(bst.root, 45).data);
/*
        long startTime = System.nanoTime();
        bst.insert(63);
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);



        long startTime = System.nanoTime();
        bst.insertRecursively(bst.root, 63);
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);

 */

    }
}
