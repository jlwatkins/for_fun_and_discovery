package com.ece368;

/**
 * Created by Joseph on 9/22/2015.
 */
class Queue {
    //CONSTANTS
    public static final int MAX_SIZE = 4;
    public static final int ERROR_EMPTY = -1;
    public static final int ERROR_FULL = -2;
    public static final int OK = 0;

    //The Queue -- change to any type (make sure to change elements as well)
    private int items[] = new int[MAX_SIZE];
    //idx to keep track of the front and back of the queue
    private int front_idx = 0;
    private int rear_idx = ERROR_EMPTY;

    public boolean isFull() {
        return (rear_idx == ERROR_FULL);
    }

    public boolean isEmpty() {
        return (rear_idx == ERROR_EMPTY);
    }

    /**
     * Adds an element to the end of queue.
     * Returns Queue.OK (0) if the element was added successfully
     * Returns Queue.ERROR_FULL (-2) if the queue is full
     */
    public int insert(int element) {
        if(this.isFull()) return ERROR_FULL;

        //Make sure the queue is not full
        if(this.isEmpty()) { //If this is empty we need to do special things
            this.items[front_idx] = element;
            this.rear_idx = this.front_idx;
        }
        else { //Move rear to next spot and then check if we are full if not keep going
            this.rear_idx = (this.rear_idx + 1) % Queue.MAX_SIZE;
            this.items[rear_idx] = element;

            //Check if this filled up the array
            if (((rear_idx + 1) % MAX_SIZE) == (front_idx % MAX_SIZE)) {
                rear_idx = ERROR_FULL;

            }
        }

        return Queue.OK;
    }

    /**
     * Removes and returns an element to the front of queue.
     * Returns the value of the element being removed
     * Returns Queue.ERROR_EMPTY (-1) if the queue is empty
     */
    public int remove() {
        //Make sure the queue is not empty
        if(this.isEmpty()) return Queue.ERROR_EMPTY;

        //if we were full before we aren't any longer
        if(this.isFull())
            rear_idx = (front_idx - 1) % MAX_SIZE;

        //keep track of value and then move front idx
        int element_being_removed = this.items[this.front_idx];
        this.front_idx = (this.front_idx + 1) % Queue.MAX_SIZE;

        if(this.front_idx % MAX_SIZE == this.rear_idx % MAX_SIZE)
            this.rear_idx = ERROR_EMPTY;

        return element_being_removed;
    }

    public void printQueue() {
        System.out.println("Printing Queue... rear=" + this.rear_idx + " front=" + this.front_idx);
        if(isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        int goUntil = front_idx, i = 0;
        if(isFull()) {
            System.out.print(items[front_idx] + " ");
            i = (front_idx + 1) % MAX_SIZE;
            goUntil = (front_idx + MAX_SIZE) % MAX_SIZE;
        } else {
            goUntil = (rear_idx + 1) % MAX_SIZE;
            i = (front_idx % MAX_SIZE);
        }

        while(i != goUntil) {
            System.out.print(items[i] + " ");
            i = (i + 1) % MAX_SIZE;
        }

        System.out.println();
    }
}