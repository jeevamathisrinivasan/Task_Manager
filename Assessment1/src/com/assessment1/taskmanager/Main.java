package com.assessment1.taskmanager;

import java.util.Scanner;

import com.assessment1.taskmanager.model.Task;
import com.assessment1.taskmanager.service.*;

public class Main {

	static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        TaskLinkedList list = new TaskLinkedList();

        while (true) {

            System.out.println("\n1.Add Task\n2.Delete Task\n3.Search Task\n4.Display All Tasks\n5.Reverse Task List\n6.Start Task Processing\n7.Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter ID:");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Name:");
                    String name = sc.nextLine();

                    System.out.println("Enter Priority:");
                    String priority = sc.nextLine();

                    list.addTask(new Task(id, name, priority, "PENDING"));
                    break;

                case 2:
                    System.out.println("Enter ID:");
                    list.deleteTask(sc.nextInt());
                    break;

                case 3:
                    System.out.println("Enter ID:");
                    Task t = list.searchTask(sc.nextInt());
                    if (t != null)
                        System.out.println("Found: " + t.getTaskName());
                    else
                        System.out.println("Not Found");
                    break;

                case 4:
                    list.displayTasks();
                    break;

                case 5:
                    list.reverseTasks();
                    break;

                case 6:
                    System.out.println("Starting Task Processing...");
                    TaskProcessor t1 = new TaskProcessor(list,"Worker-1");
                    TaskProcessor t2 = new TaskProcessor(list,"Worker-2");

                    t1.start();
                    t2.start();
                    
                    try {
                        t1.join();
                        t2.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("All tasks completed.");
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}