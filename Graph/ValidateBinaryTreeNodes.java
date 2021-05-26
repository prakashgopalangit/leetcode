package com.prakash.leetcode.NewStart.Graph;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinaryTreeNodes {
    public static void main(String[] args) {
        int n = 3;
        int[] leftChild = {1,-1,-1};
        int[] rightChild = {-1,-1,1};
        System.out.println(" return value ---> "+ new ValidateBinaryTreeNodesSolution().validateBinaryTreeNodes(n, leftChild, rightChild));
    }


}

class ValidateBinaryTreeNodesSolution {
    int visitedNodeCounter = 0;
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
      List<List<Integer>> adjList = new ArrayList<>();
      int[] inDegree = new int[n+1];
      boolean[] visited = new boolean[n];
      for(int i=0;i<n;i++) {
          adjList.add(new ArrayList<>());
          adjList.get(i).add(leftChild[i]);
          adjList.get(i).add(rightChild[i]);
          if(leftChild[i]!=-1)
            inDegree[leftChild[i]]++;
          if(rightChild[i]!=-1)
            inDegree[rightChild[i]]++;
      }

      int root = -1;
      for(int i=0;i<n;i++){
          if(inDegree[i]==0){
              root = i;
              break;
          }
      }
      System.out.println(" root ---> "+ root);
      if(root==-1) return false;

      if(!dfs(adjList, visited, root))
          return false;
        System.out.println( "adjList ---> "+ adjList);
      System.out.println(" visitedNodeCounter ---> "+ visitedNodeCounter);

      return visitedNodeCounter == n;
    }

    public boolean dfs(List<List<Integer>> adjList, boolean[] visited, int node){
        if(visited[node])
            return false;
        visited[node] = true;
        visitedNodeCounter++;
        for(int neighbor : adjList.get(node)){
           if(neighbor!=-1 && !dfs(adjList, visited, neighbor)){
               return false;
           }
        }
        return true;
    }
}
