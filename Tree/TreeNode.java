package com.prakash.leetcode.NewStart.Tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){ this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
      this.val = val;
      this.left = left;
      this.right = right;
    }

    static void printBinaryTreeRecursive(TreeNode root){
        if(root==null) return;
        if(root.left!=null)
            printBinaryTreeRecursive(root.left);
        System.out.print(root.val);
        if(root.right!=null)
            printBinaryTreeRecursive(root.right);
    }

}
