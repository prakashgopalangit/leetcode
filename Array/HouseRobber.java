package com.prakash.leetcode.NewStart.Array;

public class HouseRobber {

    public static void main(String[] args) {
        int[] houses = {2,7,9,3,1};
        System.out.println(" total robbing ---> "+ new HouseRobberSolution().rob(houses));

    }

}

class HouseRobberSolution{

    public int rob(int[] nums) {
        int prevRobbed = 0;
        int prevNotRobbed = 0;
        for(int i=0;i<nums.length;i++){

            int currentHouseRob = prevNotRobbed + nums[i];
            int currentHouseNotRob = Math.max(prevRobbed, prevNotRobbed);

            prevNotRobbed = currentHouseNotRob;
            prevRobbed = currentHouseRob;
        }
        return Math.max(prevRobbed, prevNotRobbed);

    }

}
