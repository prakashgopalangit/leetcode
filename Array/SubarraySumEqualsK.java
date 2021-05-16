package com.prakash.leetcode.NewStart.Array;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[]  nums = {1,2,3};
        int k=2;
        System.out.println(" output ---> " + new SubarraySumEqualsKSolution().subarraySum(nums,k));
    }
}

class SubarraySumEqualsKSolution {
    public int subarraySum(int[] nums, int k) {
        int[] dp = new int[nums.length+1];
        int count=0;
        for(int i=0;i<nums.length;i++){
            dp[i+1] = dp[i] + nums[i];
        }
        for(int  j=0;j<dp.length;j++){
            if(dp[j]>=k){
                count++;
            }
        }
        return count;
    }
}
