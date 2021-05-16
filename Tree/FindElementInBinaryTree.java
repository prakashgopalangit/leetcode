package com.prakash.leetcode.NewStart.Tree;

import java.util.HashSet;
import java.util.Set;

public class FindElementInBinaryTree {
    public static void main(String[] args) {
        TreeNode nodeMinus1 = new TreeNode(-1, null, null);
        TreeNode nodeMinus1Root = new TreeNode(-1, null, nodeMinus1);
        FindElementInBinaryTreeSolution findElementInBinaryTreeSolution = new FindElementInBinaryTreeSolution(nodeMinus1Root);
        System.out.println(" element found 1 --> " + findElementInBinaryTreeSolution.find(1));
        System.out.println(" element found 2 --> " + findElementInBinaryTreeSolution.find( 2));
    }
}

class FindElementInBinaryTreeSolution{

    TreeNode classRoot;
    Set<Integer> set = new HashSet<>();

    public FindElementInBinaryTreeSolution(TreeNode root) {
        this.classRoot = root;
        clearContamination(this.classRoot, 0);
        //printTreeNode(root);
    }

    public void clearContamination(TreeNode root, int value){
        if(root==null) return;
        root.val = value;
        set.add(root.val);
        if(root.left!=null)
            clearContamination(root.left, 2*root.val+1);
        if(root.right!=null)
            clearContamination(root.right, 2*root.val+2);
    }

    public boolean find(int target) {
        return set.contains(target);
    }

    public boolean findRecursive(TreeNode root, int target,int value){
        if(root==null)
            return false;
        root.val = value;

        System.out.println(" target --> " + target);
        System.out.println(" 2*root.val+2 --> " + (2*root.val)+2);

        //if( (c=='p' && root.val == target) || (c=='l' && (2*root.val)+1==target) || (c=='r' && (2*root.val)+2==target))
        if(root.val == target)
                return true;
        return findRecursive(root.left, target, (2*root.val)+1) || findRecursive(root.right, target, (2*root.val)+2);

    }

    public void printTreeNode(TreeNode node){
        if(node==null) return;
        printTreeNode(node.left);
        System.out.println(" val --> " + node.val);
        printTreeNode(node.right);
    }



}
