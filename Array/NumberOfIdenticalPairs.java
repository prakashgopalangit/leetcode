package com.prakash.leetcode.NewStart.Array;
//https://leetcode.com/problems/number-of-good-pairs/discuss/731561/JavaC%2B%2BPython-Count


import java.util.Arrays;

public class NumberOfIdenticalPairs {

    public static void main(String[] args) {
        System.out.println(" No of pairs --> " + new NumberOfIdenticalPairsSolution().numIdenticalPairs(new int[]{1,2,1,2,1}));
    }
}

class NumberOfIdenticalPairsSolution{
    public int numIdenticalPairs(int[] A) {
        int res = 0, count[] = new int[101];
        for (int a: A) {
            System.out.println("     " );
            System.out.println("before ---> " + Arrays.toString(count));
            res += count[a]++;
            System.out.println(" res value --> " + res);
            System.out.println("after ---> " + Arrays.toString(count));


        }
        return res;
    }
}