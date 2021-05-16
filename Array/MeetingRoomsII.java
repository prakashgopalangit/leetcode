package com.prakash.leetcode.NewStart.Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(" minimum no of rooms needed ---> " + new MeetingRoomsIISolution().minMeetingRooms(intervals));

    }
}

class MeetingRoomsIISolution{

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
        pq.offer(intervals[0][1]);
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=pq.peek())
                pq.poll();
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }
}
