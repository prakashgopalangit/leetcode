package com.prakash.leetcode.NewStart.Array;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        //int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        //int[][] intervals = {{1,2},{1,2},{1,2}};
        //int[][] intervals = {{1,2},{2,3}};

        int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};
        System.out.println("must be removed intervals --> " + new NonOverlappingIntervalsSolution().eraseOverlapIntervals(intervals));
    }

}

class NonOverlappingIntervalsSolution{
    public int eraseOverlapIntervals(int[][] intervals) {
        int overlappingIntervals = 0;
        if(intervals.length<=1)
            return overlappingIntervals;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        int endInterval = intervals[0][1];


        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<endInterval)
                overlappingIntervals++;
            else
                endInterval = intervals[i][1];
        }
        return overlappingIntervals;
    }


}
