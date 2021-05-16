package com.prakash.leetcode.NewStart.Array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(" output--> "+ new FindAllNumbersDisappearedInAnArraySolution().findDisappearedNumbers(nums));
    }


}

class FindAllNumbersDisappearedInAnArraySolution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            list.add(i+1);
        System.out.println(" printing list --> "+ list);
        for(int i=0;i<nums.length;i++)
            list.set(nums[i]-1,0);

        System.out.println(" printing list --> "+ list);
        int nonEmpty = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i)!=0) {
                list.set(nonEmpty, list.get(i));
                nonEmpty++;
            }
        }
        return list.subList(0, nonEmpty);
    }
}