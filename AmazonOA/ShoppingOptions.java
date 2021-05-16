package com.prakash.leetcode.NewStart.AmazonOA;

import java.util.ArrayList;
import java.util.List;

public class ShoppingOptions {
    public static void main(String[] args) {
        int[] productManagers = {2};
        int[] softwareEngineers = {3,4};
        int[] accountManagers = {2,5};
        int[] programManagers = {4,6};
        int budget = 12;
        System.out.println(" count ---> " + new ShoppingOptionsSolution().recruitmentCombinations(productManagers, softwareEngineers, accountManagers, programManagers, budget));
    }
}

class ShoppingOptionsSolution{
    int count;
    public int recruitmentCombinations(int[] productManagers, int[] softwareEngineers, int[] accountManagers, int[] programManagers, int budget) {
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> returnList = new ArrayList<>();

        List<Integer> combinations1 = new ArrayList<>();
        for(int val : productManagers)
            combinations1.add(val);
        list.add(combinations1);

        List<Integer> combinations2 = new ArrayList<>();
        for(int val : softwareEngineers)
            combinations2.add(val);
        list.add(combinations2);

        List<Integer> combinations3 = new ArrayList<>();
        for(int val : accountManagers)
            combinations3.add(val);
        list.add(combinations3);

        List<Integer> combinations4 = new ArrayList<>();
        for(int val : programManagers)
            combinations4.add(val);
        list.add(combinations4);

        List<Integer> combinations = new ArrayList<>();

        identifyRecruitmentCombinations(0, list, budget, combinations, returnList);
        System.out.println(" returnList ---> "+ returnList);
        return count;
    }

    public void identifyRecruitmentCombinations(int index, List<List<Integer>> list, int budget, List<Integer> combinations, List<List<Integer>> returnList){
        System.out.println(" index --> " + index);
        if(budget<0) return;
        if(index==list.size() && budget>=0) {
            returnList.add(new ArrayList<>(combinations));
            count++;
            return;
        }
        for(int val : list.get(index)){
            combinations.add(val);
            identifyRecruitmentCombinations(index+1, list, budget-val, combinations, returnList);
            combinations.remove(combinations.size()-1);
        }

    }
}