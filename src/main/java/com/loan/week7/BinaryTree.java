package com.loan.week7;

public class BinaryTree{

    public static void main(String[] args) {
        TreeNode treeNode;
        treeNode=new TreeNode(10);
        treeNode.left=new TreeNode(5);
        treeNode.left.left=new TreeNode(2);
        treeNode.left.right=new TreeNode(7);

        treeNode.right=new TreeNode(15);

        System.out.println("PreOrder : ");
        treeNode.preOrder(treeNode);
        System.out.println();
        System.out.println("PostOrder : ");
        treeNode.postOrder(treeNode);
        System.out.println();
        System.out.println("InOrder : ");
        treeNode.inOrder(treeNode);
        System.out.println();
        System.out.println("LevelOrder : ");
        treeNode.levelOrder(treeNode);

    }
}
