package com.prakash.leetcode.NewStart.Array;

//https://leetcode.com/problems/array-nesting/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayNesting {

    public static void main(String[] args) {
        int[] intArray = {5,4,0,3,1,6,2};
        System.out.println(" output ---> "+ new ArrayNestingSolution().arrayNesting(intArray));

    }

}


class ArrayNestingSolution {
    public int arrayNesting(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int longestLength = 0;
        for(int i=0;i<nums.length;i++){
            Set<Integer> set = new HashSet<>();
            int longestLen = findLongestLength(i, nums, set, map);
            map.put(nums[i], longestLen);
            longestLength = Math.max(longestLen, longestLength);
        }
        return longestLength;
    }

    public int findLongestLength(int startIndex, int[] nums, Set<Integer> set, Map<Integer, Integer> map){
        if(!set.contains(nums[startIndex])){
            if(map.containsKey(nums[startIndex])){
                return set.size()+map.get(nums[startIndex]);
            }
            set.add(nums[startIndex]);
            findLongestLength(nums[startIndex], nums, set, map);
        }
        return set.size();
    }
}
