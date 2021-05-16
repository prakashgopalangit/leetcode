package com.prakash.leetcode.NewStart.Tree;

import java.util.ArrayList;
import java.util.List;

public class DeepestLeavesSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);

        System.out.println(" output --> " + new DeepestLeavesSumSolution().deepestLeavesSum(root));

    }
}

class DeepestLeavesSumSolution {
    public int deepestLeavesSum(TreeNode root) {
        if(root==null) return 0;
        List<Integer> list = new ArrayList<>();
        bfs(root, list, 0);
        System.out.println(" list --> " + list);
        return list.get(list.size()-1);
    }

    public void bfs(TreeNode root, List<Integer> list, int level){
        if(root==null) return;
        if(list.size()==level)
            list.add(0);
        int levelTotal = list.get(level);
        levelTotal += root.val;
        list.set(level, levelTotal);
        bfs(root.left, list, level+1);
        bfs(root.right, list, level+1);
    }


}
