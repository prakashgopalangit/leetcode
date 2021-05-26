package com.prakash.leetcode.NewStart.Graph;

import java.util.*;

public class PathWithMaximumProbability {

    public static void main(String[] args) {

        int n = 10;
        int[][] edges = {{0,3},{1,7},{1,2},{0,9}};
        double[] succProb = {0.31,0.9,0.86,0.36};
        int start = 2;
        int end = 3;

        System.out.println(" maxProb --> "+ new PathWithMaximumProbabilitySolution().maxProbability(n, edges, succProb, start,end));
        System.out.println(" maxProb OLD --> "+ new PathWithMaximumProbabilitySolution().maxProbabilityOld(n, edges, succProb, start,end));

    }

}

class PathWithMaximumProbabilitySolution {
    public double maxProbabilityOld(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>((a,b) -> Double.compare(b[1],a[1]));
        for(int i=0;i<n;i++) {
            map.put(i, new HashMap<>());
        }
        for(int i=0;i<edges.length;i++){
            Map<Integer, Double> subMap = map.get(edges[i][0]);
            subMap.put(edges[i][1], succProb[i]);
            map.put(edges[i][0], subMap);

            Map<Integer, Double> subMap2 = map.get(edges[i][1]);
            subMap2.put(edges[i][0], succProb[i]);
            map.put(edges[i][1], subMap2);

        }
        System.out.println("map --->" +  map);

        pq.offer(new double[]{start, 1.0});

        Map<Integer, Double> helpMap = new HashMap<>();
        int i = 0;
        while(!pq.isEmpty()){
            double[] node = pq.poll();
            System.out.println("------------------ new node --------------------");
            System.out.println("node---> " + Arrays.toString(node));
            if(node[0]==end)
                return node[1];
            for(Integer neighbor : map.getOrDefault((int)node[0], new HashMap<>()).keySet()){
                double totalPro = node[1] * map.get((int)node[0]).get(neighbor);

                System.out.println(" neighbor ---> "+ neighbor);
                System.out.println(" totalPro ---> "+ totalPro);
                System.out.println(" helpMap.getOrDefault(neighbor, 0.0) ---> "+ helpMap.getOrDefault(neighbor, 0.0));
                if(totalPro > helpMap.getOrDefault(neighbor, 0.0).doubleValue()){
                    helpMap.put(neighbor, totalPro);
                    pq.offer(new double[]{neighbor, totalPro});
                }
                System.out.println(" helpMap ---> "+ helpMap);
            }

        }
        return 0.0;

    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int a = edges[i][0], b = edges[i][1];
            g.computeIfAbsent(a, l -> new ArrayList<>()).add(new int[]{b, i});
            g.computeIfAbsent(b, l -> new ArrayList<>()).add(new int[]{a, i});
        }
        for(Integer key : g.keySet()){
            System.out.println(" key value ---> "+ key);
            List<int[]> list = g.get(key);
            list.forEach(a -> {
                System.out.println("Value --->" +  Arrays.toString(a));
            });


        }
        double[] p = new double[n];
        p[start] = 1d;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(i -> -p[i]));
        pq.offer(start);
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (cur == end) {
                return p[end];
            }
            System.out.println(" p ---> "+ Arrays.toString(p));
            for (int[] a : g.getOrDefault(cur, Collections.emptyList())) {
                int neighbor = a[0], index = a[1];
                System.out.println("neighbor --> "+ neighbor);
                System.out.println("p[cur] * succProb[index] --> "+ p[cur] * succProb[index]);
                System.out.println("p[neighbor] --> "+ p[neighbor]);

                if (p[cur] * succProb[index] > p[neighbor]) {
                    p[neighbor] = p[cur] * succProb[index];
                    pq.offer(neighbor);
                }
            }
        }
        return 0d;
    }



}
