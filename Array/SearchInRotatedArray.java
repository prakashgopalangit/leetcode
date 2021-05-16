package com.prakash.leetcode.NewStart.Array;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] intArray = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(" target index --> " + new SearchInRotatedArraySolution().search(intArray,target));
    }
}


class SearchInRotatedArraySolution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            System.out.println("left --> " + left);
            System.out.println("right --> " + right);
            int mid = left +(right-left)/2;
            System.out.println("mid --> " + mid);
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>=nums[left]){
                if(target >=nums[left] && target <= nums[mid])
                    right = mid-1;
                else
                    left = mid+1;
            }else{
                if(target>= nums[mid] && target<=nums[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
        }
        return -1;

    }
}
