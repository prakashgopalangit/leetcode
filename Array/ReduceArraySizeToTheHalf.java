package com.prakash.leetcode.NewStart.Array;

import java.util.*;

public class ReduceArraySizeToTheHalf {

    public static void main(String[] args) {
        //[8, 9, 9, 14, 18, 19, 19, 22, 38, 38, 54, 58, 63, 68, 77, 92]

        int[] arraySort = {9,77,63,22,92,9,14,54,8,38,18,19,38,68,58,19};
        //Arrays.sort(arraySort);
        //System.out.println(Arrays.toString(arraySort));



        //int[] intArray = {1000,1000,3,7};
        System.out.println(" output--> " + new ReduceArraySizeToTheHalfSolution().minSetSize(arraySort));
    }

}




class ReduceArraySizeToTheHalfSolution{

    public int minSetSize(int[] arr) {
        int min = 0;
        int totalLen = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int val : arr){
            map.put(val, map.getOrDefault(val,0)+1);
        }
        if(map.size()==1) return 1;
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(entry);
        }
        for(int i=0;i<pq.size();i++){
            Map.Entry<Integer,Integer> entry = pq.poll();
            System.out.println(" entry.key "+ entry.getKey());
            System.out.println(" entry.value "+ entry.getValue());
            if(totalLen-entry.getValue()<=arr.length/2){
                return ++min;
            }else{
                totalLen = totalLen-entry.getValue();
                min++;
            }

        }
        return min;
    }


}
