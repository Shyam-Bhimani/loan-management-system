package com.loan.week7;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }

    public void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.value+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void postOrder(TreeNode root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value+" ");
    }

    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.value+" ");
        inOrder(root.right);
    }

    public void levelOrder(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            System.out.print(current.value+" ");
            if(current.left!=null){
                queue.offer(current.left);
            }
            if(current.right!=null){
                queue.offer(current.right);
            }
        }
    }
}
