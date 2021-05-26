package com.prakash.leetcode.NewStart.Graph;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};

        System.out.println(" boolean --->" + new CourseScheduleSolution().canFinish(numCourses, prerequisites));
    }

}

class CourseScheduleSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        int count = 0;
        for(int[] prereq : prerequisites) {
            List<Integer> list = map.getOrDefault(prereq[1], new ArrayList<>());
            list.add(prereq[0]);
            map.put(prereq[1], list);
            inDegree[prereq[0]]++;
        }
        System.out.println("inDegree --->  " + Arrays.toString(inDegree));
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
            if(inDegree[i]==0)
                queue.offer(i);

        System.out.println("queue --->  " + queue);
        System.out.println("prerequisites --->  " + prerequisites.length);
        while(!queue.isEmpty()){
            int preq = queue.poll();
            count++;
            if(map.containsKey(preq)){
                for(Integer course : map.get(preq)){
                    inDegree[course]--;
                    if(inDegree[course]==0)
                        queue.offer(course);
                }
            }
        }

        return count==numCourses;
    }
}
