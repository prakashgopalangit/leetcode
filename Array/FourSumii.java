package com.prakash.leetcode.NewStart.Array;

//https://leetcode.com/problems/4sum-ii/

import java.util.HashMap;
import java.util.Map;

public class FourSumii {
    public static void main(String[] args) {
        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = { 0, 2};

        System.out.println("Result --> " + new FourSumiiSolution().fourSumCount(A,B,C,D));

    }

}

class FourSumiiSolution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int sum = A[i]+B[j];
                sumMap.put((A[i]+B[j]), sumMap.getOrDefault(sum,0)+1);
            }
        }

        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                if(sumMap.containsKey(-1*(C[i]+D[j]))){
                    result += sumMap.get(-1*(C[i]+D[j]));
                }

            }
        }
        return result;
    }
}