package com.prakash.leetcode.NewStart.Array;
//https://leetcode.com/problems/shuffle-the-array/

import java.util.Arrays;

public class ShuffleArray {
    public static void main(String[] args) {
        int[] intArray = {2,5,1,3,4,7};
        //expected output - [2,3,5,4,1,7]
        System.out.println(" return Array --> " + Arrays.toString(new ShuffleArraySolution().shuffle(intArray,3)));
    }

}

class ShuffleArraySolution {
    public int[] shuffle(int[] nums, int n) {
        if(nums.length<=0) return nums;
        int[] tempArray = new int[nums.length];
        int index = 0;
        for(int i=0;i<n;i++){
           tempArray[index++] = nums[i];
           tempArray[index++] = nums[i+n];
        }
        return tempArray;
    }
}