# Binary-Search-Tree-Assignment-Questions

# Binary Search Tree (BST) Problems

This repository contains Java code for various problems related to Binary Search Trees (BST). Each problem is implemented as a separate class, and the main class demonstrates how to use these implementations.

## Q1: Search in BST

Q1. Write an iterative program to search for an element in BST. Also construct a sample BST and
try to search for elements in the same.
The for BST is : 15, 10, 20, 8, 12, 16, 25
Search for 25 in it.

The given key is the right node of the node with key 20

## Q2: Find k'th Largest Node in BST

Q2. Given a BST and a positive number k, find the k'th largest node in the BST.
For example, consider the following binary search tree. If k = 2, the k'th largest node is 20.

## Q3: Find Pair with Given Sum in BST

Q3. Given a binary search tree, find a pair with a given sum present in it.
For example, consider the following BST. If the given sum is 14, the pair is (8, 6).

## Q4: Find Inorder Predecessor in BST

Q4. Given a BST, find the inorder predecessor of a given key in it. If the key does not lie in the BST,
return the previous greater node (if any) present in the BST.
The predecessor of node 15 is 12
The predecessor of node 10 is 8
The predecessor of node 20 is 16
The predecessor doesn’t exist for node 8
The predecessor of node 12 is 10
The predecessor of node 16 is 15
The predecessor of node 25 is 20
A node’s inorder predecessor is a node with maximum value in its left subtree, i.e., its left
subtree’s right-most child. If the left subtree of the node doesn’t exist, then the inorder
predecessor is one of its ancestors
Q5. Given a BST and two nodes x and y in it, find the lowest common ancestor (LCA) of x and y.
The solution should return null if either x or y is not the actual node in the tree.

## Q5: Find Lowest Common Ancestor (LCA) in BST

Q5. Given a BST and two nodes x and y in it, find the lowest common ancestor (LCA) of x and y.
The solution should return null if either x or y is not the actual node in the tree.
Assignment Questions
 
- LCA (6, 12) = 10
- LCA (10, 12) = 10
- LCA (20, 6) = 15
- LCA (18, 22)= 20
- LCA (30, 30) = 30

## Usage

To run the code, make sure you have Java Development Kit (JDK) installed. Compile the Java files using the following command:

