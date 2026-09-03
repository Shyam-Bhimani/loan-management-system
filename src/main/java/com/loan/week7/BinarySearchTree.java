package com.loan.week7;

public class BinarySearchTree {
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode();
        TreeNode root=null;
        root=treeNode.insert(root,10);
        root=treeNode.insert(root,5);
        root=treeNode.insert(root,15);
        root=treeNode.insert(root,2);
        root=treeNode.insert(root,7);

        System.out.println("InOrder of BST return in sorted order : ");
        treeNode.inOrder(root);

        System.out.println("\n Search : ");
        System.out.println(treeNode.search(root,2).value);
    }
}
