package com.prakash.leetcode.NewStart.Graph;

import java.util.*;

public class KeysAndRooms {

    public static void main(String[] args) {

        List<Integer> ls=new ArrayList<>();
        ls.add(1);
        ls.add(3);
        List<Integer> ls1=new ArrayList<>();
        ls1.add(3);
        ls1.add(0);
        ls1.add(1);
        List<Integer> ls2=new ArrayList<>();
        ls2.add(2);
        List<Integer> ls3=new ArrayList<>();
        ls3.add(0);

        List<List<Integer>> rooms=new ArrayList<>();
        rooms.add(ls);
        rooms.add(ls1);
        rooms.add(ls2);
        rooms.add(ls3);



        System.out.println(" boolean value --> "+ new KeysAndRoomsSolution().canVisitAllRooms(rooms));
    }

}

class KeysAndRoomsSolution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        //[[1,3],[3,0,1],[2],[0]]
        int N = rooms.size();
        boolean[] visited = new boolean[N];
        int entriesToRoom = 1;
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        for(Integer key : rooms.get(0)){
            queue.offer(key);

        }
        System.out.println("visited ---> "+ Arrays.toString(visited));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int key = queue.poll();
                System.out.println(" ---------------------- ");
                System.out.println(" key ---> "+ key);
                if(!visited[key]){

                    visited[key] = true;
                    System.out.println("visited ---> "+ Arrays.toString(visited));
                    entriesToRoom++;
                    System.out.println("entriesToRoom ---> "+ entriesToRoom);
                    for(Integer nextRoomKey : rooms.get(key)){
                        queue.offer(nextRoomKey);
                    }
                }
            }
        }
        return entriesToRoom==N;
    }
}
