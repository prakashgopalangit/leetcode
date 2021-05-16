package com.prakash.leetcode.NewStart.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node1 = new TreeNode(1, node5, node6);
        System.out.println(" print values ---> " + new FindLargestValueInEachTreeRowSolution().largestValues(node1));

    }
}

class FindLargestValueInEachTreeRowSolution{
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        largestValuesRecursive(root, list, 0);
        return list;
    }
    public void largestValuesRecursive(TreeNode node, List<Integer> list, int level){
        if(node==null) return;
        System.out.println(" level --> " + level);
        System.out.println(" list.size() --> " + list.size());
        if(level == list.size()) {
            list.add(Integer.MIN_VALUE);
        }
        System.out.println(" node.val --> " + node.val);
        System.out.println(" list.get(level) --> " + list.get(level));
        if(node.val > list.get(level)) {
            list.remove(level);
            list.add(level, node.val);
            System.out.println("printing list --> "+ list);
        }
        if(node.right!=null)
            largestValuesRecursive(node.right, list, level+1);
        if(node.left!=null)
            largestValuesRecursive(node.left, list, level+1);
    }
}
