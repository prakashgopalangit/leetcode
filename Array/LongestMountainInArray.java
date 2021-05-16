package com.prakash.leetcode.NewStart.Array;

public class LongestMountainInArray {

    public static void main(String[] args) {
        //int[] intArray = {0,1,2,3,4,5,4,3,2,1,0};
        //int[] intArray = {2,1,4,7,3,2,5};
        int[] intArray = {2,2,2};
        System.out.println( "longestMountain ---> " + new LongestMountainInArraySolution().longestMountain(intArray));
    }
}

class LongestMountainInArraySolution {
    public int longestMountain(int[] A) {
        int longestSubArray = 0;
        if(A.length<3)
            return longestSubArray;
        int i=0;
        while(i<A.length-1){
            int localLongest=0;
            boolean highPoint = false;
            boolean lowPoint2 = false;

            while(i<A.length-1 && A[i]>=A[i+1]){
                i++;
            }
            while(i<A.length-1 && A[i]<A[i+1]){
                localLongest++;
                i++;
                highPoint = true;
            }
            while(i<A.length-1 && A[i]>A[i+1]){
                localLongest++;
                i++;
                lowPoint2 = true;
            }
            if(highPoint && lowPoint2 && localLongest>0){
                longestSubArray = Math.max(longestSubArray, localLongest+1);
            }
        }
        return longestSubArray;
    }
}
