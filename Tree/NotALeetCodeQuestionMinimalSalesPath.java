package com.prakash.leetcode.NewStart.Tree;

public class NotALeetCodeQuestionMinimalSalesPath {

    public static void main(String[] args) {

        NodeClass nodeClass1 = new NodeClass(1);
        NodeClass nodeClass1Parent = new NodeClass(1);
        nodeClass1Parent.children = new NodeClass[]{nodeClass1};

        NodeClass nodeClass2Parent = new NodeClass(2);
        nodeClass2Parent.children = new NodeClass[]{nodeClass1Parent};

        NodeClass nodeClass10 = new NodeClass(10);
        NodeClass nodeClass0Parent = new NodeClass(0);
        nodeClass0Parent.children = new NodeClass[]{nodeClass10};

        NodeClass nodeClass3 = new NodeClass(3);
        nodeClass3.children = new NodeClass[]{nodeClass2Parent,nodeClass0Parent };


        NodeClass nodeClass4 = new NodeClass(4);
        NodeClass nodeClass5Parent = new NodeClass(5);
        nodeClass5Parent.children = new NodeClass[]{nodeClass4};


        NodeClass nodeClass1a = new NodeClass(1);
        NodeClass nodeClass5a = new NodeClass(5);
        NodeClass nodeClass6 = new NodeClass(6);
        nodeClass6.children = new NodeClass[]{nodeClass1a,nodeClass5a };

        NodeClass root = new NodeClass(0);
        root.children = new NodeClass[]{nodeClass5Parent,nodeClass3,nodeClass6};

        System.out.println("cheapestCost ---> "+ new NotALeetCodeQuestionMinimalSalesPathSolution().getCheapestCost(root));






    }

}

class NotALeetCodeQuestionMinimalSalesPathSolution{
    public int getCheapestCost(NodeClass root){
        int minCost = Integer.MAX_VALUE;
        System.out.println("root.cost --->"+ root.cost);

        if(root.children==null)
            return root.cost;


        for(NodeClass neighbor : root.children) {
            minCost = Math.min(minCost, root.cost + getCheapestCost(neighbor));
            System.out.println(" minCost ---> "+ minCost);
        }
        return minCost==Integer.MAX_VALUE?root.cost:minCost;
    }
}

class NodeClass {
    int cost;
    NodeClass[] children;
    NodeClass parent;

    NodeClass(int cost){
        this.cost = cost;
        this.children = null;
        this.parent = null;
    }

}