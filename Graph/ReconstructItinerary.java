package com.prakash.leetcode.NewStart.Graph;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {

        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("EZE","TIA"),Arrays.asList("EZE","HBA"),Arrays.asList("AXA","TIA"),Arrays.asList("JFK","AXA"),Arrays.asList("ANU","JFK"),Arrays.asList("ADL","ANU"),Arrays.asList("TIA","AUA"),Arrays.asList("ANU","AUA"),Arrays.asList("ADL","EZE"),Arrays.asList("ADL","EZE"),Arrays.asList("EZE","ADL"),Arrays.asList("AXA","EZE"),Arrays.asList("AUA","AXA"),Arrays.asList("JFK","AXA"),
                Arrays.asList("AXA","AUA"),Arrays.asList("AUA","ADL"),Arrays.asList("ANU","EZE"),Arrays.asList("TIA","ADL"),Arrays.asList("EZE","ANU"),Arrays.asList("AUA","ANU"));
        System.out.println(" final itinerary --> "+ new ReconstructItinerarySoltuion().findItinerary(tickets));

    }


}

class ReconstructItinerarySoltuion{

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> results = new ArrayList<>();
        for(List<String> list : tickets){
            List<String> ls = map.getOrDefault(list.get(0), new ArrayList<>());
            ls.add(list.get(1));
            map.put(list.get(0), ls);
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            List<String> sortedList = entry.getValue();
            Collections.sort(sortedList);
        }
        System.out.println("map ---> "+ map);
        dfs(map, "JFK", results);
        return results;
    }

    public void dfs(Map<String, List<String>> map, String airport,List<String> results){
        List<String> existingList = map.get(airport);
        results.add(airport);

        System.out.println(" --------------------------- ");
        System.out.println(" airport ---> "+ airport);

        if(existingList!=null && existingList.size()>0){
            String connectingAirport = existingList.get(0);
            int indexToBeRemoved = 0;
            System.out.println(" results--->" + results);
            System.out.println(" connectingAirport ---> "+ connectingAirport);
            if(!map.containsKey(connectingAirport)){
                for(int i=1;i<existingList.size();i++){
                    if(map.containsKey(existingList.get(i))){
                        connectingAirport = existingList.get(i);
                        indexToBeRemoved = i;
                        break;
                    }
                }
            }
            existingList.remove(indexToBeRemoved);
            map.put(airport, existingList);
            dfs(map,connectingAirport, results);
        }
    }
}
