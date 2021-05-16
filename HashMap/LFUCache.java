package com.prakash.leetcode.NewStart.HashMap;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    public static void main(String[] args) {

        LFUCacheImplementation lfuImpl = new LFUCacheImplementation(0);
        /*lfuImpl.put(1,1);
        lfuImpl.put(2,2);
        lfuImpl.printLinkedList(lfuImpl.minFrequencyMap.get(1).head);
        System.out.println("lfuImpl.get(1)---> " + lfuImpl.get(1));
        lfuImpl.printLinkedList(lfuImpl.minFrequencyMap.get(2).head);
        lfuImpl.printLinkedList(lfuImpl.minFrequencyMap.get(1).head);
        lfuImpl.put(3,3);
        lfuImpl.printLinkedList(lfuImpl.minFrequencyMap.get(2).head);
        lfuImpl.printLinkedList(lfuImpl.minFrequencyMap.get(1).head);
        System.out.println("lfuImpl.get(2)---> " + lfuImpl.get(2));
        System.out.println("lfuImpl.get(3)---> " + lfuImpl.get(3));
        lfuImpl.printLinkedList(lfuImpl.minFrequencyMap.get(2).head);
        lfuImpl.put(4,4);
        lfuImpl.printLinkedList(lfuImpl.minFrequencyMap.get(2).head);
        lfuImpl.printLinkedList(lfuImpl.minFrequencyMap.get(1).head);
        System.out.println("lfuImpl.get(1)---> " + lfuImpl.get(1));

        System.out.println("lfuImpl.get(3)---> " + lfuImpl.get(3));
        lfuImpl.printLinkedList(lfuImpl.minFrequencyMap.get(3).head);
        System.out.println("lfuImpl.get(1)---> " + lfuImpl.get(4));
        lfuImpl.printLinkedList(lfuImpl.minFrequencyMap.get(2).head);*/


        //["LFUCache","put","put","get","put","get","get","put","get","get","get"]
        //[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]


    }
}


class LFUCacheImplementation{

    int capacity;
    int minimumFrequency;
    Map<Integer, Node> valueMap;
    Map<Integer, LFUDoublyLinkedList> minFrequencyMap;

    class Node{
        int key;
        int val;
        int frequency;
        Node prev;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    class LFUDoublyLinkedList{
        Node head;
        Node tail;
        int listSize;

        LFUDoublyLinkedList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }
        void add(Node node){
            Node temp = head.next;
            temp.prev = node;
            head.next = node;
            node.next = temp;
            node.prev = head;
            listSize++;
        }
        void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            listSize--;
        }

        Node removeFromTail(){
            Node lastNode = tail.prev;
            remove(lastNode);
            return lastNode;
        }



    }


    public LFUCacheImplementation(int capacity){
        this.capacity = capacity;
        valueMap = new HashMap<>();
        minFrequencyMap = new HashMap<>();
    }
    public int get(int key) {
        if(valueMap.containsKey(key)){
            Node existingNode = valueMap.get(key);
            updateNode(existingNode);
            return existingNode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if(valueMap.containsKey(key)){
            Node existingNode = valueMap.get(key);
            existingNode.val = value;
            updateNode(existingNode);
        }else{
          if(valueMap.size()==this.capacity){
                LFUDoublyLinkedList exisingLFUDoublyLinkedList = minFrequencyMap.get(minimumFrequency);
                Node removedNode = exisingLFUDoublyLinkedList.removeFromTail();
                valueMap.remove(removedNode.key, removedNode);
                if(exisingLFUDoublyLinkedList.listSize==0)
                    minFrequencyMap.remove(minimumFrequency);
            }
            Node newNode = new Node(key, value);
            newNode.frequency = 1;
            minimumFrequency = 1;
            LFUDoublyLinkedList lfuDoublyLinkedList = minFrequencyMap.getOrDefault(1, new LFUDoublyLinkedList());
            lfuDoublyLinkedList.add(newNode);
            minFrequencyMap.put(1, lfuDoublyLinkedList);
            valueMap.put(key, newNode);
        }
    }
    public void updateNode(Node node) {
        LFUDoublyLinkedList existingList = minFrequencyMap.get(node.frequency);
        existingList.remove(node);
        if (node.frequency==minimumFrequency && existingList.listSize == 0) {
            minFrequencyMap.remove(node.frequency);
            minimumFrequency++;
        }
        node.frequency++;
        LFUDoublyLinkedList lfuDoublyLinkedList = minFrequencyMap.getOrDefault(node.frequency, new LFUDoublyLinkedList());
        lfuDoublyLinkedList.add(node);
        minFrequencyMap.put(node.frequency, lfuDoublyLinkedList);
    }

    public void printLinkedList(Node head){
        System.out.println(" Printing linkedlist ");
        Node curr = head;
        while(curr!=null){
            System.out.println(" curr val --->"+ curr.val);
            curr = curr.next;
        }
    }



}


