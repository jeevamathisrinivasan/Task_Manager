package com.assessment1.taskmanager.model;

/**
 * Node represents a single element in the linked list.
 * It holds task data and a reference to the next node.
 */ 

public class Node {
	
    private Task task; 
    private Node next; 

    public Node(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

