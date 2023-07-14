//Q5. Given a BST and two nodes x and y in it, find the lowest common ancestor (LCA) of x and y.
//The solution should return null if either x or y is not the actual node in the tree.
//Assignment Questions

//Cracking the Coding Interview in JAVA - Foundation

//LCA (6, 12) = 10
//LCA (10, 12) = 10
//LCA (20, 6) = 15
//LCA (18, 22)= 20
//LCA (30, 30) = 30

// Node class representing a node in the BST
// Node class representing a node in the BST
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// BST class with method to find the Lowest Common Ancestor (LCA)
class BST {
    Node root;

    public BST() {
        root = null;
    }

    // Method to insert a new node in the BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Method to find the Lowest Common Ancestor (LCA) of two nodes in the BST
    Node findLCA(Node root, int x, int y) {
        while (root != null) {
            if (root.key > x && root.key > y)
                root = root.left;
            else if (root.key < x && root.key < y)
                root = root.right;
            else if (root.key == x || root.key == y)
                return root;
            else
                break;
        }
        return null;
    }
}

// Main class
public class fifth {
    public static void main(String[] args) {
        BST bst = new BST();

        // Constructing the BST
        bst.insert(15);
        bst.insert(10);
        bst.insert(8);
        bst.insert(12);
        bst.insert(20);
        bst.insert(16);
        bst.insert(25);

        // Find the Lowest Common Ancestor (LCA) of two nodes (x and y)
        int x, y;
        Node lca;

        // Example test cases
        x = 6;
        y = 12;
        lca = bst.findLCA(bst.root, x, y);
        System.out.println("LCA (" + x + ", " + y + ") = " + (lca != null ? lca.key : "null"));

        x = 10;
        y = 12;
        lca = bst.findLCA(bst.root, x, y);
        System.out.println("LCA (" + x + ", " + y + ") = " + (lca != null ? lca.key : "null"));

        x = 20;
        y = 6;
        lca = bst.findLCA(bst.root, x, y);
        System.out.println("LCA (" + x + ", " + y + ") = " + (lca != null ? lca.key : "null"));

        x = 18;
        y = 22;
        lca = bst.findLCA(bst.root, x, y);
        System.out.println("LCA (" + x + ", " + y + ") = " + (lca != null ? lca.key : "null"));

        x = 30;
        y = 30;
        lca = bst.findLCA(bst.root, x, y);
        System.out.println("LCA (" + x + ", " + y + ") = " + (lca != null ? lca.key : "null"));
    }
}
