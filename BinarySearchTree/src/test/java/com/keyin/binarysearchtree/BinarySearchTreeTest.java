package com.keyin.binarysearchtree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

   // Initializing instance of BinarySearchTree
    BinarySearchTree tree = new BinarySearchTree();

    // Insert values
    @BeforeEach
    void setup() {
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
    }

    @Test
    void testIfRootNode_NotNull() {
        Assertions.assertNotNull(tree.getRoot());
    }

    @Test
    void testRightNodeExists() {
        Assertions.assertEquals(70, tree.root.getRight().key);
    }

    @Test
    void testLeftNodeExists() {
        Assertions.assertEquals(30, tree.root.getLeft().key);
    }

}
