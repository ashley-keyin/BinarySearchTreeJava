package com.keyin.binarysearchtree;

class BinarySearchTree {

    /* Class containing left
       and right child of current node
     * and key value*/
    class Node {
        int key;
        Node left, right;

        public Node(int data)
        {
            key = data;
            left = right = null;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    BinarySearchTree(int val) {
        root = new Node(val);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    // minValue method
    int minValue(Node root) {
        int minval = root.key;

        // Find minvalue
        while (root.left != null) {
            minval = root.left.key;
            root = root.left;
        }

        return minval;
    }

    // This method mainly calls insertRecur()
    void insert(int key) {
        root = insertRecur(root, key); }

    /* A recursive function to
       insert a new key in the BST */
    Node insertRecur(Node root, int key)
    {

        /* If the tree is empty,
           return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRecur(root.left, key);
        else if (key > root.key)
            root.right = insertRecur(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRecur()
    void inorder() {
        inorderRecur(root);
    }

   // inorder traversal of BST
    void inorderRecur(Node root)
    {
        if (root != null) {
            inorderRecur(root.left);
            System.out.println(root.key);
            inorderRecur(root.right);
        }
    }

    // delete method
    void delete(int key) {
        root = delete_recursive(root, key);
    }

    // delete_recursive method
    Node delete_recursive(Node root, int key) {
        // check if tree is empty
        if (root == null) {
            return root;
        }

        // traverse tree
        if (key < root.key) {
            root.left = delete_recursive(root.left, key);
        } else if (key > root.key) {
            root.right = delete_recursive(root.right, key);
        } else {
            // check if node contains only one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // check if root has more than one child
            root.key = minValue(root.right);

            // delete the inorder successor
            root.right = delete_recursive(root.right, root.key);
        }

        return root;
    }



}