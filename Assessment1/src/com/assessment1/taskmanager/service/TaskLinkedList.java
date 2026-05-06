package com.assessment1.taskmanager.service;

import com.assessment1.taskmanager.model.*;

public class TaskLinkedList {

    private Node head;

    // Add Task
    public synchronized void addTask(Task task) {
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
        } 
        else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }

        System.out.println("Task Added Successfully.");
    }

    // Delete Task
    public synchronized void deleteTask(int taskId) {

        if (head == null) 
        		return;

        if (head.getTask().getTaskId() == taskId) {
            head = head.getNext();
            return;
        }

        Node temp = head;

        while (temp.getNext() != null) {
            if (temp.getNext().getTask().getTaskId() == taskId) {
                temp.setNext(temp.getNext().getNext());
                return;
            }
            temp = temp.getNext();
        }
    }

    // Search Task
    public Task searchTask(int taskId) {
        Node temp = head;

        while (temp != null) {
            if (temp.getTask().getTaskId() == taskId) {
                return temp.getTask();
            }
            temp = temp.getNext();
        }
        return null;
    }

    // Display All Tasks
    public void displayTasks() {
        Node temp = head;

        if (temp == null) {
            System.out.println("No tasks available");
            return;
        }
        
        System.out.println("Task List :");

        while (temp != null) {
            Task t = temp.getTask();
            System.out.println(t.getTaskId() + " - " +
                    t.getTaskName() + " - " +
                    t.getPriority() + " - " +
                    t.getStatus());
            temp = temp.getNext();
        }
    }

    // Reverse Task List
    public void reverseTasks() {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        head = prev;
        System.out.println("List Reversed");
    }

    // To get Task Count
    public int getTaskCount() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    // Thread Safe Method
    public synchronized Task getNextPendingTask() {
        Node temp = head;

        while (temp != null) {
            if (temp.getTask().getStatus().equals("PENDING")) {
                temp.getTask().setStatus("IN_PROGRESS");
                return temp.getTask();
            }
            temp = temp.getNext();
        }
        return null;
    }
}