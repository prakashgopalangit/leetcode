package com.prakash.leetcode.NewStart.Graph;

import java.nio.IntBuffer;
import java.util.*;

public class ShortestPathWithAlternatingColors {

    public static void main(String[] args) {
        int n= 5;
        int[][] redEdges = {{2,2},{0,1},{0,3},{0,0},{0,4},{2,1},{2,0},{1,4},{3,4}};
        int[][] blueEdges = {{1,3},{0,0},{0,3},{4,2},{1,0}};

        System.out.println("shortestPathArray -->" + Arrays.toString(new ShortestPathWithAlternatingColorsSolution().shortestAlternatingPaths(n, redEdges, blueEdges)));
    }

}

class ShortestPathWithAlternatingColorsSolution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Map<Integer, Map<String, List<Integer>>> map = new HashMap<>();
        int[] shortestPathArray = new int[n];
        int index = 0;
        shortestPathArray[index++] = 0;
        for(int[] redEdge : red_edges){
            if(redEdge[0]==redEdge[1])
                continue;
            if(redEdge[0]==0)
                shortestPathArray[redEdge[1]] = 1;
            Map<String, List<Integer>> subMap = null;
            if(map.containsKey(redEdge[0]))
                subMap = map.get(redEdge[0]);
            else
                subMap = new HashMap<>();
            List<Integer> list = subMap.getOrDefault("RED", new ArrayList<>());
            list.add(redEdge[1]);
            subMap.put("RED", list);
            map.put(redEdge[0], subMap);
        }

        for(int[] blueEdge : blue_edges){
            if(blueEdge[0]==blueEdge[1])
                continue;
            if(blueEdge[0]==0)
                shortestPathArray[blueEdge[1]] = 1;
            Map<String, List<Integer>> subMap = null;
            if(map.containsKey(blueEdge[0]))
                subMap = map.get(blueEdge[0]);
            else
                subMap = new HashMap<>();
            List<Integer> list = subMap.getOrDefault("BLUE", new ArrayList<>());
            list.add(blueEdge[1]);
            subMap.put("BLUE", list);
            map.put(blueEdge[0], subMap);
        }
        System.out.println(" full Map ---> "+ map);
        System.out.println(" shortestPathArray --> " + Arrays.toString(shortestPathArray));
        String[] strArray = {"RED", "BLUE"};
        for(int i=1;i<n;i++){
            if(shortestPathArray[i]==0) {
                System.out.println(" i value --> "+ i);
                shortestPathArray[i] = findShortestColoredPath(map, 0, i, null, strArray, null);

            }
        }
        return shortestPathArray;

    }

    public int findShortestColoredPath(Map<Integer, Map<String, List<Integer>>> map, int startIndex, int target, String color, String[] colorArray, Set<String> visited){
        System.out.println("startIndex --->  " + startIndex);
        int min = Integer.MAX_VALUE;
        if(map.containsKey(startIndex)) {
            if(color==null) {
                for (String colorArr : colorArray) {
                    visited = new HashSet<>();
                    List<Integer> neigbors = map.get(startIndex).get(colorArr);
                    System.out.println(" colorArr --> "+ colorArr);
                    System.out.println("neigbors---> " + neigbors);
                    System.out.println("visited ---> "+ visited);

                    if (neigbors != null) {
                        for (int neigbor : neigbors) {
                            if(visited.contains(neigbor+"~"+colorArr))
                                break;
                            visited.add(neigbor+"~"+colorArr);

                            if (neigbor == target) return 0;
                            System.out.println("neigbor --->  " + neigbor);
                            int shortest = findShortestColoredPath(map, neigbor, target, colorArr.equalsIgnoreCase("RED") ? "BLUE" : "RED", colorArray, visited);
                            if (shortest != -1) {
                                min = Math.min(min, shortest + 1);
                                System.out.println(" min value inside ---> "+ min + " colorArr ---> "+ colorArr);
                            }
                        }
                    }
                }
            }else {
                System.out.println(" coming inside else part");
                if(visited==null)
                    visited = new HashSet<>();
                List<Integer> neigbors = map.get(startIndex).get(color);
                if (neigbors != null) {
                    for (int neigbor : neigbors) {
                        if(visited.contains(neigbor+"~"+color)) return -1;

                        visited.add(neigbor+"~"+color);
                        if (neigbor == target) return 0;
                        int shortest = findShortestColoredPath(map, neigbor, target, color.equalsIgnoreCase("RED") ? "BLUE" : "RED", colorArray, visited);
                        if (shortest != -1) {
                            min = Math.min(min, shortest + 1);
                        }
                    }
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
