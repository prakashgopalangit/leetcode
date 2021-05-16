package com.prakash.leetcode.NewStart.Tree;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestors_Q3 {

    public static void main(String[] args) {
        Node root = new Node(3, null);
        root.left = new Node(5, root);
        root.right = new Node(1, root);
        root.left.left = new Node(6, root.left);
        root.left.right = new Node(2, root.left);
        root.left.right.left = new Node(7, root.left.right);
        root.left.right.right = new Node(4, root.left.right);

        root.right.left = new Node(0, root.right);
        root.right.right = new Node(8, root.right);

        Node node = new LowestCommonAncestors_Q3Solution1().lowestCommonAncestor(root.left.left, root.left.right.right); // node 6 & 4
        System.out.println(" node val ---> "+ node.val);

        Node returnNode = new LowestCommonAncestors_Q3Solution2().lowestCommonAncestor(root.left.left, root.left.right.right); // node 6 & 4
        System.out.println(" returnNode val ---> "+ node.val);
    }

}

class LowestCommonAncestors_Q3Solution1{
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = new HashSet<>();
        while(p!=null){
            set.add(p);
            p = p.parent;
        }
        while(!set.contains(q)){
            q = q.parent;
        }
        return q;
    }

}


class LowestCommonAncestors_Q3Solution2{

    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        while( a!= b){
            a = (a==null)? q:a.parent;
            /*if(a!=null)
                System.out.println(" a.val -->" + a.val);*/
            b = (b== null)? p:b.parent;
            /*if(b!=null)
                System.out.println(" b.val -->" + b.val);
            System.out.println(" ---------------- ");*/
        }
        return a;
    }

}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;

    Node(int val, Node parent){
        this.val = val;
        this.parent = parent;
    }
};