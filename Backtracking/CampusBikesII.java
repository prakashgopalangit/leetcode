package com.prakash.leetcode.NewStart.Backtracking;

public class CampusBikesII {

    public static void main(String[] args) {
;
        int[][] workers = {{0,0},{1,0},{2,0},{3,0},{4,0}};
        int[][] bikes = {{0,999},{1,999},{2,999},{3,999},{4,999},{5,999}};

        System.out.println("result --> " + new CampusBikesIISolution().assignBikes(workers, bikes));
    }
}

class CampusBikesIISolution {

    int min = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        backtracking(workers, bikes, 0, 0, new boolean[bikes.length]);
        return min;
    }

    public void backtracking(int[][] workers, int[][] bikes, int workerIndex, int sum, boolean[] used){

        System.out.println(" workerIndex --> "+ workerIndex);
        System.out.println(" sum  ----> " + sum);
        if(workerIndex==workers.length) {
            min = Math.min(min, sum);
            return;
        }

        for(int i=0;i<bikes.length;i++){
            if(used[i]) continue;
            used[i] = true;
            backtracking(workers, bikes, workerIndex+1, sum + distance(workers[workerIndex], bikes[i]), used) ;
            used[i] = false;

        }
    }

    public int distance(int[] worker, int[] bike){
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1]-bike[1]);

    }

}