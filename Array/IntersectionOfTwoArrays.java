package com.prakash.leetcode.NewStart.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] intArray1 = {4,9,5};
        int[] intArray2 = {9,4,9,8,4};
        IntersectionOfTwoArraysSolution sol = new IntersectionOfTwoArraysSolution();
        int[] returnArray = sol.intersection(intArray1, intArray2);
        System.out.println(Arrays.toString(returnArray));;

    }
}

class IntersectionOfTwoArraysSolution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] intArray = new int[set.size()];
        int k = 0;
        for(Integer val:set){
            intArray[k++]= val;
        }
        return intArray;
    }
}