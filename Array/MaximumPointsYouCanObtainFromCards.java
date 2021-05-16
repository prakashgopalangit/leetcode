package com.prakash.leetcode.NewStart.Array;

public class MaximumPointsYouCanObtainFromCards {

    public static void main(String[] args) {
        int[] cardPoints = {1,79,80,1,1,1,200,1};
        int k = 3;
        System.out.println(" maxScore ---> "+ new MaximumPointsYouCanObtainFromCardsSolution().maxScore(cardPoints, k));
    }
}

class MaximumPointsYouCanObtainFromCardsSolution {
    public int maxScore(int[] cardPoints, int k) {
        return maxPoints(cardPoints, 0, cardPoints.length-1, k);
    }

    public int maxPoints(int[] cardPoints, int i, int j, int k){
        if(i>=cardPoints.length || j<=0)
            return 0;
        if(k==0)
            return 0;
        int first = cardPoints[i] + maxPoints(cardPoints, i+1, j, k-1);
        int last = cardPoints[j] + maxPoints(cardPoints, i, j-1, k-1);
        return Math.max(first, last);

    }


}
