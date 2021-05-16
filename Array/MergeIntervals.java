package com.prakash.leetcode.NewStart.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{5,6}};
        //int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] returnedArray = new MergeIntervalsSolution().merge(intervals);
        for(int[] row: returnedArray)
            System.out.println(Arrays.toString(row));
    }
}

class MergeIntervalsSolution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1)
            return intervals;

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<Integer> list = new ArrayList<>();
        int x1 = intervals[0][0];
        int y1 = intervals[0][1];

        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]<=y1){
                y1 = Math.max(y1, intervals[i][1]);
            }else{
                list.add(x1);
                list.add(y1);
                x1 = intervals[i][0];
                y1 = intervals[i][1];
            }
        }
        list.add(x1);
        list.add(y1);

        System.out.println(" printing list ---> " + list);
        int[][] int2D = new int[list.size()/2][2];
        for(int i=0,j=0;i<=(list.size()-1);i=i+2,j++){
            System.out.println(" i value --> " + i);
            int2D[j][0] = list.get(i);
            int2D[j][1] = list.get(i+1);
        }

        return int2D;

    }
}