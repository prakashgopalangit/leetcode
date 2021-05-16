package com.prakash.leetcode.NewStart.Tree;


public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        printRoot(root);

    }

    public static void printRoot(TreeNode root){
        while(root!=null){
            System.out.println(" root val " + root.val);
            System.out.println(" root left " + root.left);
            root = root.right;
        }

    }

}

class FlattenBinaryTreeToLinkedListSolution {
    public void flatten(TreeNode root) {
        flattenRoot(root);

}

    public TreeNode flattenRoot(TreeNode root){
        if(root==null) return root;
        if(root.left!=null) {
            TreeNode rightCopy = root.right;
            TreeNode flattenLeft = flattenRoot(root.left);
            TreeNode flattenCopy = flattenLeft;
            while(flattenCopy.right!=null){
                flattenCopy = flattenCopy.right;
            }
            flattenCopy.right = flattenRoot(rightCopy);
            root.right = flattenLeft;
        }else{
            root.right = flattenRoot(root.right);
        }
        root.left = null;
        return root;

    }

}
