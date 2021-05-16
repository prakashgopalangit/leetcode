package com.prakash.leetcode.NewStart.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(1);
        System.out.println(" In Order Recursive ---> " + new BinaryTreeInOderTraversalSolution().inOrderRecursive(root));
        System.out.println(" In Order Iterative ---> " + new BinaryTreeInOderTraversalSolution().inOrderIterative(root));
        System.out.println(" In Order Morris Logic ---> " + new BinaryTreeInOderTraversalSolution().morrisInOrder(root));
    }

}

class BinaryTreeInOderTraversalSolution{

    public List<Integer> inOrderRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        inOrderRecursion(root, list);
        return list;
    }
    public void inOrderRecursion(TreeNode root, List<Integer> list){
        if(root==null) return;
        inOrderRecursion(root.left, list);
        list.add(root.val);
        inOrderRecursion(root.right, list);
    }

    public List<Integer> inOrderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }

    public List<Integer> morrisInOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        TreeNode currHead;
        while(curr!=null){
           if(curr.left==null){
               list.add(curr.val);
               curr = curr.right;
           }else{
               currHead = curr.left;
               while(currHead.right!=null){
                   currHead = currHead.right;
               }
               currHead.right = curr;
               TreeNode tempNode = curr;
               curr = curr.left;
               tempNode.left = null;
           }


        }
        return list;
    }


}
