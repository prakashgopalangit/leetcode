package com.prakash.leetcode.NewStart.Tree;

//https://leetcode.com/problems/maximum-average-subtree

public class MaximumAverageSubtree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(1);
        System.out.println("maxAverage---> " + new MaximumAverageSubtreeSolution().maximumAverageSubtree(root));
    }
}

class MaximumAverageSubtreeSolution{

    double maxAverage;
    TreeNode maxNode;

    public double maximumAverageSubtree(TreeNode root) {
        if(root==null) return maxAverage;
        maximumAverageSubtreeRecursive(root);
        return maxAverage;
    }

    public double[] maximumAverageSubtreeRecursive(TreeNode root){
        int count = 1;
        double currentTotalValue = root.val;
        if(root.left!=null){
            double[] doubleArray = maximumAverageSubtreeRecursive(root.left);
            count += doubleArray[0];
            currentTotalValue += doubleArray[1];
        }
        if(root.right!=null){
            double[] doubleArray = maximumAverageSubtreeRecursive(root.right);
            count += doubleArray[0];
            currentTotalValue += doubleArray[1];
        }
        double currentAverage = currentTotalValue/count;
        if(currentAverage>maxAverage){
            maxAverage = currentAverage;
            maxNode = root;
        }
        return new double[]{count, currentTotalValue};
    }

}