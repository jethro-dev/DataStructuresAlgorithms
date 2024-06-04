package com.jethroau.dsa.datastructures.trees;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void testInsertAndSearch() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        assertTrue(tree.search(1));
        assertTrue(tree.search(2));
        assertTrue(tree.search(3));
        assertTrue(tree.search(4));
        assertTrue(tree.search(5));
        assertFalse(tree.search(6));
    }

    @Test
    public void testDelete() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        assertEquals("20 10 30", tree.inOrderTraversal());

        tree.delete(20);
        assertEquals("30 10", tree.inOrderTraversal());
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        assertEquals("20 30 40 50 60 70 80", tree.inOrderTraversal());

        tree.delete(50);
        assertEquals("20 30 40 80 60 70", tree.inOrderTraversal());
    }

    @Test
    public void testInOrderTraversal() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        assertEquals("4 2 5 1 3", tree.inOrderTraversal());
    }

    @Test
    public void testPreOrderTraversal() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        assertEquals("1 2 4 5 3", tree.preOrderTraversal());
    }

    @Test
    public void testPostOrderTraversal() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        assertEquals("4 5 2 3 1", tree.postOrderTraversal());
    }

    @Test
    public void testEmptyTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        assertEquals("", tree.inOrderTraversal());
    }

    @Test
    public void testSingleElementTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(1);

        assertEquals("1", tree.inOrderTraversal());
    }
}
