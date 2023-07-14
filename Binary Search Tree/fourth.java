//Q4. Given a BST, find the inorder predecessor of a given key in it. If the key does not lie in the BST,
//return the previous greater node (if any) present in the BST.
// Node class representing a node in the BST
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// BST class with method to find the inorder predecessor
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

    // Method to find the inorder predecessor of a given key in the BST
    Node findInorderPredecessor(Node root, int key) {
        Node predecessor = null;
        Node current = root;

        while (current != null) {
            if (key < current.key) {
                current = current.left;
            } else if (key > current.key) {
                predecessor = current;
                current = current.right;
            } else {
                if (current.left != null) {
                    predecessor = findMaxKey(current.left);
                }
                break;
            }
        }

        return predecessor;
    }

    // Method to find the maximum key in the BST (rightmost node)
    Node findMaxKey(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}

// Main class
public class fourth {
    public static void main(String[] args) {
        BST bst = new BST();

        // Constructing the sample BST
        bst.insert(15);
        bst.insert(10);
        bst.insert(8);
        bst.insert(12);
        bst.insert(20);
        bst.insert(16);
        bst.insert(25);

        // Find the inorder predecessor of a given key (key = 16 in this example)
        int key = 16;
        Node predecessor = bst.findInorderPredecessor(bst.root, key);

        if (predecessor != null) {
            System.out.println("The inorder predecessor of " + key + " is: " + predecessor.key);
        } else {
            System.out.println("No inorder predecessor found for " + key + ".");
        }
    }
}