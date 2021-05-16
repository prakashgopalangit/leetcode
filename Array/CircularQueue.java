package com.prakash.leetcode.NewStart.Array;

public class CircularQueue {
    
}

class MyCircularQueue {
    int[] elementArray;
    int front;
    int rear;
    int capacity;
    int runningCapacity;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        capacity = k;
        elementArray = new int[capacity];
        runningCapacity = 0;
        front = 0;
        rear = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull())
            return false;
        rear = (rear+1)%capacity;
        elementArray[rear] = value;
        runningCapacity++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty())
            return false;
        front = (front+1)%capacity;
        runningCapacity--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(!isEmpty())
            return elementArray[front];
        return -1;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(!isEmpty())
            return elementArray[rear];
        return -1;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(runningCapacity==0)
            return true;
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(runningCapacity==capacity)
            return true;
        return false;
    }
}
