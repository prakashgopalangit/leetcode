package com.prakash.leetcode.NewStart.Tree;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args){
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(" maxSum ---> "+ new BinaryTreeMaximumPathSumSolution().maxPathSum(root));



    }


    public int[] hi(){
        return new int[]{0,0};
    }
}

class BinaryTreeMaximumPathSumSolution{
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumRecursive(root);
        return maxSum;
    }
    public int maxPathSumRecursive(TreeNode root){
        if(root==null) return 0;

        int leftSum = maxPathSumRecursive(root.left);
        int rightSum = maxPathSumRecursive(root.right);

        int childSum = Math.max(leftSum, rightSum);
        int childWithParentSum = Math.max(root.val, root.val+childSum);

        int localSum = Math.max(childWithParentSum, root.val+leftSum+rightSum);

        if(localSum>maxSum)
            maxSum = localSum;

        return childWithParentSum;

    }
}
