package com.prakash.leetcode.NewStart.BinarySearch;

public class BinarySeachRecursiveAscendingAndDescending {

    public static void main(String[] args) {
        int[] ascendingInput = {1,2,3,4,5,6,7};
        int ascendingTarget = 6;
        int[] descendingInput = {7,6,5,4,3,2,1};
        int descendingTarget = 5;

        //System.out.println("ascendingTarget(6) index " + new BinarySeachRecursiveAscendingAndDescendingSolution().binarySearch(ascendingInput, ascendingTarget, 0, ascendingInput.length-1));
        System.out.println("descendingTarget(5) index " + new BinarySeachRecursiveAscendingAndDescendingSolution().binarySearch(descendingInput, descendingTarget, 0,descendingInput.length-1));

    }
}


class BinarySeachRecursiveAscendingAndDescendingSolution {
    public int binarySearch(int[] input, int target, int left, int right){
        while(left <= right){
            int mid = left + (right-left)/2;
            if(input[mid] == target)
                return mid;
            if(target<input[mid])
                return binarySearch(input, target, mid+1,right);
            else
                return binarySearch(input, target, left, mid-1);
        }
        return -1;
    }
}