package com.prakash.leetcode.NewStart.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;

        System.out.println("return list --->  " + new CombinationSumSolution().combinationSum(candidates, target));
    }

}

class CombinationSumSolution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(candidates, target, 0, list, new ArrayList<>());
        return list;
    }

    public void backtracking(int[] candidates, int target, int index, List<List<Integer>> list, List<Integer> currentList){
        if(target==0)
            list.add(new ArrayList<>(currentList));

        for(int i=index;i<candidates.length;i++){
            if(target-candidates[i]>=0){
                currentList.add(candidates[i]);
                backtracking(candidates, target-candidates[i], i, list, currentList);
                currentList.remove(currentList.size()-1);
            }
        }


    }
}
