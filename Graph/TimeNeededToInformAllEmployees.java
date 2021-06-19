package com.prakash.leetcode.NewStart.Graph;

import java.util.ArrayList;
import java.util.List;

public class TimeNeededToInformAllEmployees {

    public static void main(String[] args) {
        int n = 4;
        int headId = 2;
        int[] manager = {3,3,-1,2};
        int[] informTime = {0,0,162,914};


        System.out.println(" inform time ---> "+ new TimeNeededToInformAllEmployeesSolution().numOfMinutes(n, headId, manager, informTime));
    }

}

class TimeNeededToInformAllEmployeesSolution{

    public int numOfMinutes(int n, int headId, int[] manager, int[] informTime) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(new ArrayList<>());
        for(int i=0;i<manager.length;i++) {
            if(manager[i]!=-1)
                list.get(manager[i]).add(i);
        }
        for(List<Integer> innerList : list){
            System.out.println(" innerList---> "+innerList);
        }
        return dfs(list, headId, informTime);
    }

    public int dfs(List<List<Integer>> list, int headId, int[] informTime){
        int localInformTime = 0;
        for(int subOrdinate : list.get(headId)){
            localInformTime = Math.max(localInformTime, dfs(list, subOrdinate, informTime));
        }
        return informTime[headId] + localInformTime;
    }
}
