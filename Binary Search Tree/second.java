//Q2. Given a BST and a positive number k, find the k'th largest node in the BST.
//For example, consider the following binary search tree. If k = 2, the k'th largest node is 20.
// Node class representing a node in the BST
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// BST class with method to find the k'th largest node
class BST {
    Node root;
    int count;

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

    // Method to find the k'th largest node in the BST
    int findKthLargest(int k) {
        count = 0;
        Node kthLargest = findKthLargestRec(root, k);
        return kthLargest != null ? kthLargest.key : -1;
    }

    Node findKthLargestRec(Node root, int k) {
        if (root == null)
            return null;

        // Traverse the BST in reverse inorder (right, root, left) to find the k'th largest node
        Node right = findKthLargestRec(root.right, k);

        // If the k'th largest node is found in the right subtree, return it
        if (right != null)
            return right;

        // Increment the count of visited nodes
        count++;

        // If the current node is the k'th largest node, return it
        if (count == k)
            return root;

        // Otherwise, traverse the left subtree
        return findKthLargestRec(root.left, k);
    }
}

// Main class
public class second {
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

        // Find the k'th largest node (k = 2 in this example)
        int k = 2;
        int kthLargest = bst.findKthLargest(k);

        if (kthLargest != -1) {
            System.out.println("The " + k + "'th largest node is: " + kthLargest);
        } else {
            System.out.println("The BST does not have a " + k + "'th largest node.");
        }
    }
}