package codingInterview;

class Node {
    int val;
    Node left, right;

    public Node(int item) {
        val = item;
        left = right = null;
    }
}

class BST {
    Node root;

    BST() {
        root = null;
    }

    // Insert method
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.val) {
            root.left = insertRec(root.left, key);
        } else if (key > root.val) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // Inorder traversal for displaying the tree
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.val + " ");
            inorderRec(root.right);
        }
    }

    void sumPre(){
        System.out.println(sum(root));
    }

    int sum(Node node){
        if(node==null) return 0;

        return sum(node.left)+ node.val+ sum(node.right);
    }

    public static void main(String[] args) {
        BST tree = new BST();

        /* Example usage */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print inorder traversal of the BST
        tree.inorder();  // Output: 20 30 40 50 60 70 80

        tree.sumPre();
    }
}
