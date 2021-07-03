package com.prakash.leetcode.NewStart.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        System.out.println("results --->  " + new PermutationsSolution().permute(nums));

    }
}

class PermutationsSolution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(list, nums, new ArrayList<>());
        return list;
    }
    public void backtracking(List<List<Integer>> list, int[] nums, List<Integer> currentList){
        if(currentList.size()==nums.length){
            list.add(new ArrayList<>(currentList));
            return;
        }


        for(int i=0;i<nums.length;i++){
            if(currentList.contains(nums[i])) continue;

            currentList.add(nums[i]);
            backtracking(list, nums, currentList);
            currentList.remove(currentList.size()-1);
        }

    }
}