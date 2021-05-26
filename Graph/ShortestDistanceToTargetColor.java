package com.prakash.leetcode.NewStart.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestDistanceToTargetColor {
    public static void main(String[] args) {
        int[] colors = {2,1,2,2,1};
        int[][] queries = {{1,1},{4,3},{1,3},{4,2},{2,1}};
        System.out.println(" result ---> "+ new ShortestDistanceToTargetColorSolution().shortestDistanceColor(colors, queries));
    }
}


class ShortestDistanceToTargetColorSolution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer>> colorMap = new HashMap<>();
        for(int i=0;i<colors.length;i++){
            List<Integer> subList = colorMap.getOrDefault(colors[i], new ArrayList<>());
            subList.add(i);
            colorMap.put(colors[i], subList);
        }
        for(int[] query:queries)
            if(colorMap.containsKey(query[1]))
                list.add(binarySearch(query[0], colorMap.get(query[1])));
            else
                list.add(-1);

        return list;
    }

    public int binarySearch(int index, List<Integer> list){
        System.out.println("----------------------------");
        System.out.println("index --->  "+ index);
        int left = 0;
        int right = list.size()-1;
        while(left<right){
            int mid = (left + (right-left))/2;
            if(list.get(mid)<index){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        System.out.println("left --->  "+ left);
        System.out.println("right --->  "+ right);

        if(left - 1 >= 0) {
            System.out.println("index - list.get(left - 1)  --->  " + (index - list.get(left - 1)));
            System.out.println("index - list.get(left)  --->  " + (index - list.get(left)));
            System.out.println("list.get(left) - index  --->  " + (list.get(left) - index));
        }
        if(left - 1 >= 0 && Math.abs(index - list.get(left - 1)) < Math.abs(index - list.get(left)))
            return Math.abs(index-list.get(left-1));
        else
            return Math.abs(index-list.get(left));
    }
}
