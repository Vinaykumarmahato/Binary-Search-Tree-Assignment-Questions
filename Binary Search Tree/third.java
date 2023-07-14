// Node class representing a node in the BST
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// BST class with method to find a pair with a given sum
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

    // Method to find a pair with the given sum in the BST
    boolean findPairWithSum(Node root, int targetSum) {
        Node left = root, right = root;
        boolean done1 = false, done2 = false;
        int val1 = 0, val2 = 0;

        // Initialize left pointer
        while (!done1) {
            while (left != null && left.left != null)
                left = left.left;

            if (left == null)
                done1 = true;
            else {
                val1 = left.key;
                left = left.right;
                done1 = true;
            }
        }

        // Initialize right pointer
        while (!done2) {
            while (right != null && right.right != null)
                right = right.right;

            if (right == null)
                done2 = true;
            else {
                val2 = right.key;
                right = right.left;
                done2 = true;
            }
        }

        // Find the pair with the given sum
        while (val1 < val2) {
            if (val1 + val2 == targetSum) {
                System.out.println("Pair found: (" + val1 + ", " + val2 + ")");
                return true;
            }

            if (val1 + val2 < targetSum) {
                done1 = false;

                // Increment left pointer
                while (!done1) {
                    while (left != null && left.left != null)
                        left = left.left;

                    if (left == null)
                        done1 = true;
                    else {
                        val1 = left.key;
                        left = left.right;
                        done1 = true;
                    }
                }
            } else {
                done2 = false;

                // Decrement right pointer
                while (!done2) {
                    while (right != null && right.right != null)
                        right = right.right;

                    if (right == null)
                        done2 = true;
                    else {
                        val2 = right.key;
                        right = right.left;
                        done2 = true;
                    }
                }
            }
        }

        // No pair found with the given sum
        System.out.println("No pair found with sum " + targetSum);
        return false;
    }
}

// Main class
public class third {
    public static void main(String[] args) {
        BST bst = new BST();

        // Constructing the BST
        bst.insert(8);
        bst.insert(6);
        bst.insert(10);
        bst.insert(4);
        bst.insert(7);
        bst.insert(9);
        bst.insert(11);

        // Find a pair with the given sum (sum = 14 in this example)
        int targetSum = 14;
        bst.findPairWithSum(bst.root, targetSum);
    }
}
