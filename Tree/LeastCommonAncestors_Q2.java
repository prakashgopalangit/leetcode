package com.prakash.leetcode.NewStart.Tree;

import java.util.*;

public class LeastCommonAncestors_Q2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode treeNode = new LeastCommonAncestors_Q2RecursiveSolution().lowestCommonAncestor(root, root.left, root.left.right.right);

        // TreeNode node10 = new TreeNode(10);
        // TreeNode treeNode = new LeastCommonAncestors_Q2IterativeSolution().lowestCommonAncestor(root, root.left, node10);

        if(treeNode!=null)
            System.out.println(" treenode val --> "+ treeNode.val);
        else
            System.out.println(" treenode is null ");

    }
}

class LeastCommonAncestors_Q2RecursiveSolution {
    boolean isPFound;
    boolean isQFound;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode commonAncestor = lowestCommonAncestorRecursive(root, p, q);
        if(isPFound && isQFound)
            return commonAncestor;
        else
            return null;
    }
    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q){
        System.out.println(" p.val "+p.val);
        System.out.println(" q.val "+q.val);
        if(root==null) return root;

        System.out.println(" --------------------------------------- ");
        System.out.println(" --------------------------------------- ");
        System.out.println(" root.val --> " + root.val);
        if(root.left!=null)
            System.out.println(" root.left.val --> " + root.left.val);
        if(root.right!=null)
            System.out.println(" root.right.val --> " + root.right.val);
        TreeNode left = lowestCommonAncestorRecursive(root.left, p, q);
        TreeNode right = lowestCommonAncestorRecursive(root.right, p, q);
        System.out.println(" left --> " + left);
        System.out.println(" right --> " + right);
        if(root==p){
            isPFound = true;
            return root;
        }
        if(root==q){
            isQFound = true;
            return root;
        }

        if(left==null)
            return right;
        else if(right==null)
            return left;
        else
            return root;

    }

}


class LeastCommonAncestors_Q2IterativeSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        stack.push(root);
        parent.put(root, null);
        System.out.println(" stack while loop just started ");
        while(!stack.isEmpty() && (!parent.containsKey(p) || !parent.containsKey(q))){
            TreeNode node = stack.pop();
            if(node.left!=null){
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if(node.right!=null){
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        System.out.println(" stack while loop is over ");
        Set<TreeNode> ancestors = new HashSet<>();
        while(p!=null){
            ancestors.add(p);
            p = parent.get(p);
        }

        while(q!=null && !ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}