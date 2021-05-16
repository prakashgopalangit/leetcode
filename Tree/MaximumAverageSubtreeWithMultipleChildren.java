package com.prakash.leetcode.NewStart.Tree;

import java.util.ArrayList;
import java.util.List;

public class MaximumAverageSubtreeWithMultipleChildren {

    public static void main(String[] args) {
        TreeNodeWithChildren root = new TreeNodeWithChildren(20);

        TreeNodeWithChildren node12 = new TreeNodeWithChildren(12);
        TreeNodeWithChildren node18 = new TreeNodeWithChildren(18);
        List<TreeNodeWithChildren> list1 = new ArrayList<>();
        list1.add(node12);
        list1.add(node18);
        root.children = list1;

        TreeNodeWithChildren node11 = new TreeNodeWithChildren(11);
        TreeNodeWithChildren node2 = new TreeNodeWithChildren(2);
        TreeNodeWithChildren node3 = new TreeNodeWithChildren(3);
        List<TreeNodeWithChildren> list2 = new ArrayList<>();
        list2.add(node11);
        list2.add(node2);
        list2.add(node3);
        node12.children = list2;

        TreeNodeWithChildren node15 = new TreeNodeWithChildren(15);
        TreeNodeWithChildren node8 = new TreeNodeWithChildren(8);
        List<TreeNodeWithChildren> list3 = new ArrayList<>();
        list3.add(node15);
        list3.add(node8);
        node18.children = list3;

        System.out.println(" maxAverage---> " + new MaximumAverageSubtreeWithMultipleChildrenSolution().maximumAverageSubtree(root));
    }
}

class MaximumAverageSubtreeWithMultipleChildrenSolution{
    double maxAverage;
    TreeNodeWithChildren maxNode;

    public double maximumAverageSubtree(TreeNodeWithChildren root) {
        if(root==null) return maxAverage;
        maximumAverageSubtreeRecursive(root);
        return maxAverage;
    }

    public double[] maximumAverageSubtreeRecursive(TreeNodeWithChildren root){
        int count = 1;
        double currTotal = root.val;
        if(root.children!=null){
            for(TreeNodeWithChildren children : root.children){
                double[] childrenDoubleArray = maximumAverageSubtreeRecursive(children);
                count += childrenDoubleArray[0];
                currTotal += childrenDoubleArray[1];
            }
        }
        double average = currTotal/count;
        if(count>1 && average>maxAverage){
            maxAverage = average;
            maxNode = root;
        }
        return new double[]{count, currTotal};
    }


}




class TreeNodeWithChildren{
    int val;
    List<TreeNodeWithChildren> children;
    TreeNodeWithChildren(int val){
        this.val = val;
    }

}