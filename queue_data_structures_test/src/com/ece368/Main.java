package com.ece368;

public class Main {
    static Queue q = new Queue();
    public static void main(String[] args) {
	    System.out.println("Hello World!");
        q.printQueue();
        System.out.println("Status of insert 5= " + q.insert(5));
        q.printQueue();
        System.out.println("Status of insert 4= " + q.insert(4));
        q.printQueue();
        System.out.println("Status of insert 3= " + q.insert(3));
        q.printQueue();
        System.out.println("Status of remove = " + q.remove());
        q.printQueue();
        System.out.println("Status of insert 2= " + q.insert(2));
        q.printQueue();
        System.out.println("Status of insert 1= " + q.insert(1));
        q.printQueue();
        System.out.println("Status of insert 0= " + q.insert(0));
        q.printQueue();
        System.out.println("Status of insert 1= " + q.insert(1));
        q.printQueue();
        System.out.println("Status of remove = " + q.remove());
        q.printQueue();
        System.out.println("Status of remove = " + q.remove());
        q.printQueue();
        System.out.println("Status of insert 2= " + q.insert(2));
        q.printQueue();
        System.out.println("Status of insert 3= " + q.insert(3));
        q.printQueue();
    }
}
