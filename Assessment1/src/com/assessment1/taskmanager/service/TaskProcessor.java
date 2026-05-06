package com.assessment1.taskmanager.service;

import com.assessment1.taskmanager.model.Task;

public class TaskProcessor extends Thread {

    private TaskLinkedList list;

    public TaskProcessor(TaskLinkedList list,String name) {
    		super(name);
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {

            Task task = list.getNextPendingTask();

            if (task == null) 
            		break;

            System.out.println(getName()+ " processing Task ID: " + task.getTaskId());

            try {
                Thread.sleep(1000);
            } catch (Exception e) {}

            task.setStatus("COMPLETED");

            System.out.println(getName()+ " completed Task ID: " + task.getTaskId());
        }
    }
}
