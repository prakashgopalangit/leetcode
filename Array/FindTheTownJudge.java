package com.prakash.leetcode.NewStart.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTheTownJudge {

    public static void main(String[] args) {
        int[][] trust= {{1,3},{1,4},{2,3},{2,4},{4,3}};
        int N = 4;

        System.out.println(" find judge --> "+ new FindTheTownJudgeSolution().findJudge(N, trust));
    }

}

class FindTheTownJudgeSolution {

    //Optimized thinking
    public int findJudge(int N, int[][] trust) {
        Set<Integer> uniqueJudges = new HashSet<>();
        for(int i=0;i<trust.length;i++)
            uniqueJudges.add(trust[i][0]);
        for(int i=1;i<=N;i++){
            if(!uniqueJudges.contains(i))
                return i;
        }
        return -1;
    }


    //normal thinking
    /*public int findJudge(int N, int[][] trust) {
        int[] judgeCount = new int[N+1];
        Set<Integer> uniqueJudges = new HashSet<>();
        for(int i=0;i<trust.length;i++){
            judgeCount[trust[i][1]]++;
            uniqueJudges.add(trust[i][0]);
        }
        System.out.println("judgeCount---> "+ Arrays.toString(judgeCount));
        System.out.println("uniqueJudges---> "+ uniqueJudges);
        for(int i=1;i<=N;i++){
            if(judgeCount[i]==N-1 && !uniqueJudges.contains(i))
                return i;
        }
        return -1;

    }*/
}
