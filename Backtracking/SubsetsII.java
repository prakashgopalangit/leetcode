package com.prakash.leetcode.NewStart.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println("final result ---> " + new SubsetsIISolution().subsets(nums));
    }

}

class SubsetsIISolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(list, nums, 0, new ArrayList<>());
        return list;
    }

    public void backtracking(List<List<Integer>> list, int[] nums, int index, List<Integer> currentList){
        list.add(new ArrayList<>(currentList));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            currentList.add(nums[i]);
            backtracking(list, nums, i+1,currentList);
            currentList.remove(currentList.size()-1);

        }
    }

}
