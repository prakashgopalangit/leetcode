package com.prakash.leetcode.NewStart.Array;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people = {1,7,7,1};
        int limit = 9;
        System.out.println(" return value---> "+ new BoatsToSavePeopleSolution().numRescueBoats(people, limit));
    }
}

class BoatsToSavePeopleSolution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int totalBoats = 0;
        int small = 0;
        int heavy = people.length-1;
        while(small<=heavy){
            totalBoats++;
            System.out.println("people[small] --> " + people[small]);
            System.out.println("people[heavy] --> " + people[heavy]);
            if(people[small] + people[heavy]<= limit)
                small++;
            heavy--;
        }
        return totalBoats;
    }
}
