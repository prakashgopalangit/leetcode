package com.prakash.leetcode.NewStart.Array;

import java.util.PriorityQueue;

public class SeatReservationManager {
    public static void main(String[] args) {

        SeatManager sm = new SeatManager(5);
        System.out.println("sm.reserve()--> " + sm.reserve());
        System.out.println("sm.reserve()--> " + sm.reserve());
        sm.unreserve(1);
        System.out.println("sm.reserve()--> " + sm.reserve());


    }
}


class SeatManager {
    PriorityQueue<Integer> pq;

    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        for(int i=1;i<=n;i++)
            pq.offer(i);
    }

    public int reserve() {
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}
