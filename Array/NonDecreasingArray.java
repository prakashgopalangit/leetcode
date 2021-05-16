package com.prakash.leetcode.NewStart.Array;

public class NonDecreasingArray {

    public static void main(String[] args) {
        int[] nums = {2,3,1,5,4};
        System.out.println(" boolean value ---> "+ new NonDecreasingArraySolution().checkPossibility(nums));
    }

}
class NonDecreasingArraySolution {
    public boolean checkPossibility(int[] nums) {
        int prevMax = 0;
        int left = 0;
        int right = 1;
        int decreasingCounter = 0;
        while(right<nums.length){
            if(nums[right]<nums[left]){
                decreasingCounter++;
                if(nums[right]>=prevMax)
                    left++;
            }else{
                prevMax = nums[left];
                left= right;
            }
            if(decreasingCounter>1)
                return false;
            right++;
        }
        return true;
    }
}
