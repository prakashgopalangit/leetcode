package com.prakash.leetcode.NewStart.AmazonInterviewQuestions;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    public static void main(String[] args) {
        int[] sticks = {3354,4316,3259,4904,4598,474,3166,6322,8080,9009};
        //int[] sticks = {2,4,3};
        System.out.println("output--> " + new MinimumCostToConnectSticksSolution().connectSticks(sticks));
    }
}
class MinimumCostToConnectSticksSolution{
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int totalCost = 0;
        for(int stick:sticks)
            pq.offer(stick);
        while(pq.size()>1){
            int stick1 = pq.poll();
            int stick2 = pq.poll();
            int cost = stick1+stick2;
            totalCost += cost;
            pq.offer(cost);
        }
        return totalCost;
    }
}
