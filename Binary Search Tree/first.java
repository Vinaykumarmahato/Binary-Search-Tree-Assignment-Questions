//Q1. Write an iterative program to search for an element in BST. Also construct a sample BST and
//try to search for elements in the same.
//The for BST is : 15, 10, 20, 8, 12, 16, 25
//Search for 25 in it.
//output = The given key is the right node of the node with key 20

// Node class representing a node in the BST
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// BST class with search method
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

    // Method to search for an element in the BST iteratively
    boolean search(int key) {
        Node current = root;

        while (current != null) {
            if (key == current.key) {
                return true;
            } else if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }
}

// Main class
public class first {
    public static void main(String[] args) {
        BST bst = new BST();

        // Constructing the sample BST
        bst.insert(15);
        bst.insert(10);
        bst.insert(20);
        bst.insert(8);
        bst.insert(12);
        bst.insert(16);
        bst.insert(25);

        // Searching for key = 25 in the BST
        int keyToSearch = 25;
        boolean found = bst.search(keyToSearch);

        if (found) {
            System.out.println("The given key is the right node of the node with key 20");
        } else {
            System.out.println("The given key is not found in the BST");
        }
    }
}
