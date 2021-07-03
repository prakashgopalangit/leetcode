package com.prakash.leetcode.NewStart.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public static void main(String[] args) {

        System.out.println(" final List ---> "+ new CombinationSum3Solution().combinationSum3(3,9));

    }
}

class CombinationSum3Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(list, k, n, new ArrayList<>(), 1);
        return list;
    }

    public void backtracking(List<List<Integer>> list, int k, int n, List<Integer> currentList, int index){
        if(n<0)
            return;
        if(k==0 && n ==0)
            list.add(new ArrayList<>(currentList));
        for(int i=index;i<10;i++){
            currentList.add(i);
            backtracking(list, k-1, n-i, currentList, i+1);
            currentList.remove(currentList.size()-1);
        }
    }
}
