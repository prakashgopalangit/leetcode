package com.prakash.leetcode.NewStart.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AllElementsInTwoBinarySearchTrees {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node2 = new TreeNode(2, node1, node4);

        TreeNode node0 = new TreeNode(0, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node1C = new TreeNode(1, node0, node3);

        List<Integer> list = new AllElementsInTwoBinarySearchTreesSolution().getAllElements(node2, node1C);
        for(Integer value: list)
            System.out.println(" Print value ---> " + value);
    }

}
class AllElementsInTwoBinarySearchTreesSolution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> pq = new PriorityQueue<Integer>();
        performInorderTraversal(root1, pq);
        System.out.println(" pq size---> " + pq.size());
        int size = pq.size();
        for(int i=0;i<size;i++)
            System.out.println(" pq value root1---> " + pq.poll());
        /*performInorderTraversal(root2, pq);
        for(int i=0;i<pq.size();i++)
            System.out.println(" pq value root1+root2---> " + pq.poll());

        for(int i=0;i<pq.size();i++)
            list.add(pq.poll());*/
        return list;
    }

    public void performInorderTraversal(TreeNode node, Queue<Integer> pq){
        if(node==null) return;
        performInorderTraversal(node.left, pq);
        System.out.println(" node val ---> " + node.val);
        pq.offer(node.val);
        performInorderTraversal(node.right, pq);
    }

}
