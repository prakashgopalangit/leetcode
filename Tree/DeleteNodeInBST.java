package com.prakash.leetcode.NewStart.Tree;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodeInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(12);
        root.right.right.left = new TreeNode(11);
        DeleteNodeInBSTSolution sol = new DeleteNodeInBSTSolution();
        List<Integer> list = new ArrayList<>();
        /*list = null;
        printBST(sol.deleteNode(root, 6), list);
        System.out.println(" print new BST for deleting 6--> " + list);*/

        /*list= null;
        list = new ArrayList<>();
        printBST(sol.deleteNode(root, 10), list);
        System.out.println(" print new BST for deleting 10--> " + list);*/

        list= null;
        list = new ArrayList<>();
        printBST(sol.deleteNode(root, 8), list);
        System.out.println(" print new BST for deleting 8--> " + list);
    }

    public static void printBST(TreeNode root, List<Integer> list){
        if(root==null) return;
        printBST(root.left, list);
        list.add(root.val);
        printBST(root.right, list);
    }

}

class DeleteNodeInBSTSolution{
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        if(root.val==key){
            TreeNode curr = root.right;
            if(curr!=null){
                while(curr.left!=null){
                    curr = curr.left;
                }
                curr.left = root.left;
                return root.right;
            } else{
                return root.left;
            }
        }
        if(key>root.val){
            root.right = deleteNode(root.right, key);
        }else{
            root.left  = deleteNode(root.left, key);
        }
        return root;
    }

}
