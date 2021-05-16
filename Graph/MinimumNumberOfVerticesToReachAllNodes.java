package com.prakash.leetcode.NewStart.Graph;

import java.util.*;

public class MinimumNumberOfVerticesToReachAllNodes {

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> list =Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(0,2),
                Arrays.asList(2,5),
                Arrays.asList(3,4),
                Arrays.asList(4,2));
        System.out.println(" List<Integer> ----> "+ new MinimumNumberOfVerticesToReachAllNodesSolution().findSmallestSetOfVertices(n, list));
    }


}



class MinimumNumberOfVerticesToReachAllNodesSolution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] reach = new int[n];
        List<Integer> results = new ArrayList<>();
        for(List<Integer> list : edges){
            reach[list.get(1)] = 1;
        }
        for(int i=0;i<n;i++){
            if(reach[i]==0)
                results.add(i);
        }
        return results;

    }
}

/** didnt work out **/
/*class MinimumNumberOfVerticesToReachAllNodesSolution{
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> results = new ArrayList<>();
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));
        int[] vertices = new int[n];
        for(List<Integer> list : edges){
            List<Integer> ls = map.getOrDefault(list.get(0), new ArrayList<>());
            ls.add(list.get(1));
            map.put(list.get(0), ls);
        }
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet())
            pq.offer(new int[]{entry.getKey(), entry.getValue().size()});

        System.out.println("map---> " + map);
        System.out.println("pq ---> " + Arrays.deepToString(pq.toArray()));

        int[]  val = {0,0};
        for(int i=0;i<pq.size();i++){
            val = pq.poll();
            System.out.println(" val ---> "+ Arrays.toString(val));
            if(vertices[val[0]]!=1){
                vertices[val[0]] = 1;
                results.add(val[0]);
                dfs(map, val[0], results, vertices);
            }
        }
        return results;
    }

    public void dfs(Map<Integer, List<Integer>> map, int index, List<Integer> results, int[] vertices){
        System.out.println("index ---> " + index);
        System.out.println("vertices---> " + Arrays.toString(vertices));
        for(Integer vertex : map.get(index)){
            if(vertices[vertex]!=1){
                vertices[vertex] = 1;
            }
            System.out.println("vertex ---> " + vertex);
            if(map.containsKey(vertex))
                dfs(map, vertex, results, vertices);
        }

    }


}*/
