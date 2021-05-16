package com.prakash.leetcode.NewStart.Tree;

//https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

public class Find_Node_BinaryTreeIn_Clone_Tree {

    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node3 = new TreeNode(3, node6, node9);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node7 = new TreeNode(7, node4, node3);

        TreeNode node6Cloned = new TreeNode(6, null, null);
        TreeNode node9Cloned = new TreeNode(9, null, null);
        TreeNode node3Cloned = new TreeNode(3, node6Cloned, node9Cloned);
        TreeNode node4Cloned = new TreeNode(4, null, null);
        TreeNode node7Cloned = new TreeNode(7, node4Cloned, node3Cloned);

        System.out.println(" print values ---> " + new Find_Node_BinaryTreeIn_Clone_TreeSolution().getTargetCopy(node7, node7Cloned,node3 ).val);

    }
}

class Find_Node_BinaryTreeIn_Clone_TreeSolution {
    TreeNode clonedTargetCopy;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        clonedTargetCopy = target;
        getTargetCopyRecursive(original, cloned, target, clonedTargetCopy);
        return clonedTargetCopy;
    }

    public void getTargetCopyRecursive(TreeNode original, TreeNode cloned, TreeNode target, TreeNode clonedTargetCopy){
        if(original==target)
            clonedTargetCopy = cloned;
        if(original.left!=null)
            getTargetCopyRecursive(original.left, cloned.left, target, clonedTargetCopy);
        if(original.right!=null)
            getTargetCopyRecursive(original.right, cloned.right, target, clonedTargetCopy);
    }

    /*
    One way of solving the problem

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return getTargetCopyRecursive(original, cloned, target);

    }

    public TreeNode getTargetCopyRecursive(TreeNode original, TreeNode cloned, TreeNode target){
        TreeNode clonedTargetCopy = null;
        if(original==target){
            clonedTargetCopy = cloned;
            return clonedTargetCopy;
        }
        if(original.left!=null && clonedTargetCopy==null)
            clonedTargetCopy = getTargetCopyRecursive(original.left, cloned.left, target);
        if(original.right!=null && clonedTargetCopy==null)
            clonedTargetCopy = getTargetCopyRecursive(original.right, cloned.right, target);
        return clonedTargetCopy;
    }*/

}
