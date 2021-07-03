package com.prakash.leetcode.NewStart.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public static void main(String[] args) {

        int[] nums = {1,1};
        System.out.println("results --->  " + new PermutationsIISolution().permuteUnique(nums));

    }
}

class PermutationsIISolution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(list, nums,new boolean[nums.length], new ArrayList<>());
        return list;
    }
    public void backtracking(List<List<Integer>> list, int[] nums, boolean[] used, List<Integer> currentList){
        System.out.println(" ------------------- ");

        if(currentList.size()==nums.length){
            list.add(new ArrayList<>(currentList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            System.out.println(" i --->" + i);
            if(used[i] || (i>0 && nums[i]==nums[i-1] && !used[i-1])){
                System.out.println(" used[i] ---> "+ used[i]);
                if(i>0)
                    System.out.println(" used[i-1] ---> "+ used[i-1]);
                continue;
            }
            used[i] = true;
            currentList.add(nums[i]);
            backtracking(list, nums, used, currentList);
            currentList.remove(currentList.size() - 1);
            used[i] = false;

        }

    }
}