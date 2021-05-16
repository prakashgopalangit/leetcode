package com.prakash.leetcode.NewStart.Tree;
//https://leetcode.com/problems/maximum-binary-tree/

import sun.reflect.generics.tree.Tree;

public class MaximumBinaryTree {

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode.printBinaryTreeRecursive(new MaximumBinaryTreeSolution().constructMaximumBinaryTree(nums));
    }
}

class MaximumBinaryTreeSolution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructBinaryTree(nums, 0, nums.length-1);
    }

    public TreeNode constructBinaryTree(int[] nums, int startIndex, int endIndex){
        if(startIndex<0 || startIndex> nums.length-1 || endIndex<0 || endIndex > nums.length-1 || startIndex>endIndex)
            return null;
        if(startIndex==endIndex)
            return new TreeNode(nums[startIndex]);

        int maxIndex = findMaxIndex(nums, startIndex, endIndex);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructBinaryTree(nums, startIndex, maxIndex-1);
        root.right = constructBinaryTree(nums, maxIndex+1, endIndex);
        return root;
    }

    public int findMaxIndex(int[] nums, int stIndex, int endIndex){
        int maxValue = nums[stIndex];
        int maxIndex = stIndex;
        System.out.println("stIndex --> " + stIndex);
        System.out.println("endIndex --> " + endIndex);
        for(int i=stIndex+1; i<=endIndex;i++){
            if(nums[i]>maxValue){
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }



}
