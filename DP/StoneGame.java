package com.prakash.leetcode.NewStart.DP;

public class StoneGame {
    public static void main(String[] args) {
        int[] stones = {7,7,12,16,41,48,41,48,11,9,34,2,44,30,27,12,11,39,31,8,23,11,47,25,15,23,4,17,11,50,16,50,38,34,48,27,16,24,22,48,50,10,26,27,9,43,13,42,46,24};
        System.out.println(" is Alex winner-->" + new StoneGameSolution().stoneGame(stones));

    }

}

class StoneGameSolution {

    public boolean stoneGame(int[] piles) {
        int[][] memo = new int[piles.length+1][piles.length+1];
        int alexTotal = countStones(piles, 0, piles.length-1, memo );

        System.out.println(" alexTotal --> "+ alexTotal);
        int pilesTotal = 0;
        for(int val : piles){
            pilesTotal += val;
        }
        return alexTotal>pilesTotal/2;
    }

    public int countStones(int[] piles,int stIndex, int endIndex, int[][] memo){
        if(stIndex>endIndex || endIndex<stIndex) return 0;
        int maxTotal = Integer.MIN_VALUE;

        if(stIndex>endIndex || endIndex<stIndex)
            return 0;
        if(memo[stIndex][endIndex]!=0)
            return memo[stIndex][endIndex];

        int firstStone = piles[stIndex] + Math.max(countStones(piles, stIndex+2, endIndex, memo),
                countStones(piles, stIndex+1, endIndex-1, memo));
        System.out.println(" firstStone--> "+ firstStone);
        int lastStone = piles[endIndex] + Math.max(countStones(piles, stIndex, endIndex-2, memo),
                countStones(piles, stIndex+1, endIndex-1, memo));
        System.out.println(" lastStone--> "+ lastStone);
        maxTotal = Math.max(firstStone, lastStone);
        memo[stIndex][endIndex] = maxTotal;
        return memo[stIndex][endIndex];

    }

}