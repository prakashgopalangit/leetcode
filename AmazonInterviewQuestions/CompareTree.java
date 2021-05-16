package com.prakash.leetcode.NewStart.AmazonInterviewQuestions;


public class CompareTree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(1);
        //root1.right = new TreeNode(5);
        //root1.left.left = new TreeNode(1);
        //root1.left.right = new TreeNode(2);


        TreeNode root2 = new TreeNode(1);
        //root2.left = new TreeNode(1);
        //root2.right = new TreeNode(2);

        System.out.println(" compare ---> "+ new CompareTreeSolution().isSubtree(root1, root2));
    }

}

class CompareTreeSolution{

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        System.out.println(" root.val --> "+ root.val);
        System.out.println(" subRoot.val --> "+ subRoot.val);
        if(compareTrees(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean compareTrees(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        return root1.val == root2.val && compareTrees(root1.left, root2.left) && compareTrees(root1.right, root2.right);
    }

}
