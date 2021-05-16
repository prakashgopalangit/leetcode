package com.prakash.leetcode.NewStart.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostOderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(1);
        System.out.println(" Post Order Recursive ---> " + new BinaryTreePostOderTraversalSolution().postOrderRecursive(root));
        System.out.println(" Post Order Iterative ---> " + new BinaryTreePostOderTraversalSolution().postOrderIterative(root));
    }

}

class BinaryTreePostOderTraversalSolution{

    public List<Integer> postOrderRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        postOrderRecursion(root, list);
        return list;
    }
    public void postOrderRecursion(TreeNode root, List<Integer> list){
        if(root==null) return;
        postOrderRecursion(root.left, list);
        postOrderRecursion(root.right, list);
        list.add(root.val);
    }

    public List<Integer> postOrderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(0, node.val);
            if(node.left!=null)
                stack.push(node.left);
            if(node.right!=null)
                stack.push(node.right);
        }

        return list;
    }


}
