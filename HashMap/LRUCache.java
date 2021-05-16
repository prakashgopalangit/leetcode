package com.prakash.leetcode.NewStart.HashMap;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {

        LRUCacheImplementation lrucImpl = new LRUCacheImplementation(2);
        lrucImpl.put(1,0);
        lrucImpl.put(2,2);
        System.out.println(" ===== before printing linkedlist =====");
        lrucImpl.printLinkedList(lrucImpl.head);
        System.out.println(lrucImpl.get(1));
        System.out.println(" ===== before printing linkedlist =====");
        lrucImpl.printLinkedList(lrucImpl.head);

        lrucImpl.put(3,3);
        System.out.println(lrucImpl.get(2));
        System.out.println(" ===== before printing linkedlist =====");
        lrucImpl.printLinkedList(lrucImpl.head);

        lrucImpl.put(4,4);
        System.out.println(" ===== before printing linkedlist =====");
        lrucImpl.printLinkedList(lrucImpl.head);

        System.out.println(lrucImpl.get(1));
        System.out.println(lrucImpl.get(3));
        System.out.println(lrucImpl.get(4));
        //lrucImpl.put(3,3);
        //System.out.println(lrucImpl.get(2));

    }


}




class LRUCacheImplementation {
    class Node{
        int val;
        int key;
        Node prev;
        Node next;

        Node(int val, int key){
            this.val = val;
            this.key = key;
        }

    }

    int capacity;
    Map<Integer, Node> valueMap;
    Node head;
    Node tail;

    public LRUCacheImplementation(int capacity) {
        this.capacity = capacity;
        valueMap = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }

    public int get(int key) {
        System.out.println("===== printing map ===== ");
        for(Map.Entry<Integer, Node> entry : valueMap.entrySet()){
            System.out.println("entry.getKey() ---> " + entry.getKey());
            System.out.println("entry.getValue() ---> " + entry.getValue());
        }


      if(valueMap.containsKey(key)){
          Node node = valueMap.get(key);
          removeNode(node);
          addToHead(node);
          return valueMap.get(key).val;
      }
      return -1;
    }

    public void put(int key, int value) {
        if (valueMap.containsKey(key)) {
          Node node = valueMap.get(key);
          node.val = value;
          removeNode(node);
          addToHead(node);
        } else{
            //System.out.println("valueMap.keySet().size()--> " + valueMap.keySet().size());
            //System.out.println("this.capacity--> " + this.capacity);
            if(valueMap.keySet().size()==this.capacity) {
                removeFromTail();
            }
            Node newNode = new Node(value, key);
            valueMap.put(key, newNode);
            addToHead(newNode);
        }
    }

    public void addToHead(Node node){
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
        //System.out.println(" addToHead node.val --> " + node.val);
        //System.out.println(" addToHead node.next.val --> " + node.next.val);
        //System.out.println(" addToHead node.prev.val --> " + node.prev.val);
    }

    public Node removeFromTail(){
        Node nodeToRemoved = tail.prev;
        valueMap.remove(nodeToRemoved.key, nodeToRemoved);
        nodeToRemoved.prev.next = tail;
        tail.prev = nodeToRemoved.prev;
        nodeToRemoved.next = null;
        nodeToRemoved.prev = null;
        return nodeToRemoved;
    }
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    static void printLinkedList(Node head){
        System.out.println(" Printing linkedlist ");
        Node curr = head;
        while(curr!=null){
            System.out.println(" curr val --->"+ curr.val);
            curr = curr.next;
        }
    }



}
