package com.prakash.leetcode.NewStart.Array;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] intArray = {1,2,0};
        System.out.println(Arrays.toString(new SortColorsSolution().sortColors(intArray)));
    }

}

/*
1,2,0
1,0,2


 */

class SortColorsSolution {
    public int[] sortColors(int[] nums) {
       int zeroIndex = 0;
       int twoIndex = nums.length-1;
        for(int i=zeroIndex;i<=twoIndex;){
            if(nums[i]==0){
                swap(zeroIndex,i, nums);
                zeroIndex++;
                i++;
            }else if(nums[i]==2){
                swap(twoIndex,i, nums);
                twoIndex--;
            }else{
                i++;
            }
        }
        return nums;

    }
    public void swap(int fromIndex, int toIndex, int[] nums){
        int temp = nums[fromIndex];
        nums[fromIndex] = nums[toIndex];
        nums[toIndex] = temp;
    }
}
