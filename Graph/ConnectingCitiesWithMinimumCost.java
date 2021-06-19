package com.prakash.leetcode.NewStart.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ConnectingCitiesWithMinimumCost {

    public static void main(String[] args) {
        int n = 3;
        int[][] connections = {{1,2,5},{1,3,6},{2,3,1}};
        System.out.println(" minimum cost ---> "+ new ConnectingCitiesWithMinimumCostSolution().minimumCost(n, connections));
    }
}

class ConnectingCitiesWithMinimumCostSolution {
    public int minimumCost(int N, int[][] connections) {
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0;i<=N;i++)
            list.add(new ArrayList<int[]>());
        for(int i=0;i<connections.length;i++){
            list.get(connections[i][0]).add(new int[]{connections[i][1], connections[i][2]});
            list.get(connections[i][1]).add(new int[]{connections[i][0], connections[i][2]});
        }

        for(List<int[]> element : list){
            System.out.println(" element ---> "+ Arrays.deepToString(element.toArray()));
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        pq.offer(new int[]{1, 0});
        int cost = 0;
        int numberOfNodeVisited = 0;
        boolean[] visited = new boolean[N+1];
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            if(!visited[node[0]]) {
                visited[node[0]] = true;
                System.out.println(" node[0] ---> " + node[0]);
                System.out.println(" node[1] cost ---> " + node[1]);
                cost += node[1];
                numberOfNodeVisited++;
                for (int[] neighbor : list.get(node[0])) {
                    if (!visited[neighbor[0]]) {
                        pq.offer(neighbor);
                    }
                }
            }
        }

        System.out.println("numberOfNodeVisited ---> "+ numberOfNodeVisited);
        System.out.println("visited ---> "+ Arrays.toString(visited));
        return numberOfNodeVisited==N?cost:-1;
    }
}