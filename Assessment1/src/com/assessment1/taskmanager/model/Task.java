package com.assessment1.taskmanager.model;

/**
 * Task class represents a single task in the system.
 * It follows encapsulation by keeping fields private
 * and exposing only required getters/setters.
 */

public class Task {

    private int taskId;
    private String taskName;
    // Priority of task: HIGH, MEDIUM, LOW
    private String priority;
    // Current status: PENDING, IN_PROGRESS, COMPLETED
    private String status;

    public Task(int taskId, String taskName, String priority, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Only status is allowed to change because
     * it represents the lifecycle of the task.
     * Other fields remain constant to maintain data integrity.
     */
    public void setStatus(String status) {
        this.status = status;
    }

}