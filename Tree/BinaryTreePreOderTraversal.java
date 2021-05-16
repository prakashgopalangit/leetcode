package com.prakash.leetcode.NewStart.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(1);
        System.out.println(" Pre Order Recursive ---> " + new BinaryTreePreOderTraversalSolution().preOrderRecursive(root));
        System.out.println(" Pre Order Iterative ---> " + new BinaryTreePreOderTraversalSolution().preOrderIterative(root));
    }

}

class BinaryTreePreOderTraversalSolution{

    public List<Integer> preOrderRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        preOrderRecursion(root, list);
        return list;
    }
    public void preOrderRecursion(TreeNode root, List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        preOrderRecursion(root.left, list);
        preOrderRecursion(root.right, list);
    }

    public List<Integer> preOrderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                list.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return list;
    }


}
