package bai12_java_collectine_framework.bai_tap;

import bai12_java_collectine_framework.thuc_hanh.test_bst.BST;

public class TestSearchBST {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(5);
        tree.insert(6);
        tree.insert(10);
        tree.insert(8);
        tree.insert(3);
        System.out.println(tree.search(10));
    }
}