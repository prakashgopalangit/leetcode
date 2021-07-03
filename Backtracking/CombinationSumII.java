package com.prakash.leetcode.NewStart.Backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = {1,1,2,2};
        int target = 5;
        System.out.println("return list --->  " + new CombinationSumIISolution().combinationSum(candidates, target));
    }

}

class CombinationSumIISolution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        System.out.println(" sorted candidates ---> "+ Arrays.toString(candidates));
        backtracking(candidates, target, 0, list, new ArrayList<>());
        return list;
    }

    public void backtracking(int[] candidates, int target, int index, List<List<Integer>> list, List<Integer> currentList){
        System.out.println(" --------------------------- ");
        if(target==0)
            list.add(new ArrayList<>(currentList));

        for(int i=index;i<candidates.length;i++){
            if (i > index && candidates[i] == candidates[i-1]){

                System.out.println("i ---> "+ i);
                System.out.println("index ---> "+ index);
                System.out.println("candidates[i] ---> "+ candidates[i]);
                System.out.println("candidates[i-1] ---> "+ candidates[i-1]);
                continue;

            }
            if(target-candidates[i]>=0){
                currentList.add(candidates[i]);
                backtracking(candidates, target-candidates[i], i+1, list, currentList);
                currentList.remove(currentList.size()-1);
            }
        }


    }
}
