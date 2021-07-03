package com.prakash.leetcode.NewStart.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println("final result ---> " + new SubsetsSolution().subsets(nums));


    }

}

class SubsetsSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(list, nums, 0, new ArrayList<>());
        return list;
    }

    public void backtracking(List<List<Integer>> list, int[] nums, int index, List<Integer> currentList){
        list.add(new ArrayList<>(currentList));
        for(int i=index;i<nums.length;i++){
         currentList.add(nums[i]);
         backtracking(list, nums, i+1,currentList);
         currentList.remove(currentList.size()-1);

        }
    }

}
