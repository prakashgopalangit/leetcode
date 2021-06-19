package com.prakash.leetcode.NewStart.Graph;

import java.util.*;

public class OpenTheLock {

    public static void main(String[] args) {

        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";

        System.out.println(" minimum no of locks ---> "+ new OpenTheLockSolution().openLock(deadends, target));

    }
}

class OpenTheLockSolution {
    public int openLock(String[] deadends, String target) {
        int minimumTurns = 0;
        Set<String> visited = new HashSet<String>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                System.out.println(" size ---> "+ size);
                String lock = queue.poll();
                if(visited.contains(lock)) continue;
                if(lock.equalsIgnoreCase(target)) return minimumTurns;
                for(int j=0;j<lock.length();j++){
                    String incremented = lock.substring(0,j) + (lock.charAt(j)=='9'?0: lock.charAt(j)-'0'+1) + lock.substring(j+1);
                    System.out.println(" incremented ---> "+ incremented);
                    if(!visited.contains(incremented))
                        queue.offer(incremented);
                    String decremented = lock.substring(0,j) + (lock.charAt(j)=='0'? 9: lock.charAt(j)-'0' - 1) + lock.substring(j+1);
                    System.out.println(" decremented ---> "+ decremented);
                    if(!visited.contains(decremented))
                        queue.offer(decremented);
                }
                visited.add(lock);
            }
            minimumTurns++;
        }
        return -1;
    }
}
