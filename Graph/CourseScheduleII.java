package com.prakash.leetcode.NewStart.Graph;

import java.util.*;

public class CourseScheduleII {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

        System.out.println(" int[] --->" + Arrays.toString(new CourseScheduleSolutionII().canFinish(numCourses, prerequisites)));
    }

}

class CourseScheduleSolutionII {
    public int[] canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegree = new int[numCourses];
        int[] courseArray = new int[numCourses];
        int courseIndex = 0;
        for(int[] prereq : prerequisites) {
            List<Integer> list = map.getOrDefault(prereq[1], new ArrayList<>());
            list.add(prereq[0]);
            map.put(prereq[1], list);
            inDegree[prereq[0]]++;
        }
        System.out.println("inDegree --->  " + Arrays.toString(inDegree));
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                courseArray[courseIndex++] = i;
            }
        }
        System.out.println("queue --->  " + queue);
        System.out.println("prerequisites --->  " + prerequisites.length);
        while(!queue.isEmpty()){
            int preq = queue.poll();
            if(map.containsKey(preq)){
                for(Integer course : map.get(preq)){
                    inDegree[course]--;
                    if(inDegree[course]==0) {
                        queue.offer(course);
                        courseArray[courseIndex++] = course;
                    }
                }
            }
            System.out.println("queue --->  " + queue);
        }
        return courseIndex==numCourses?courseArray:new int[0];
    }
}
