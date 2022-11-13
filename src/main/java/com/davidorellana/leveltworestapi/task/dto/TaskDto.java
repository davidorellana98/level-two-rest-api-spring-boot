package com.davidorellana.leveltworestapi.task.dto;

import com.davidorellana.leveltworestapi.task.data.Status;

import java.util.Calendar;

public class TaskDto {

    private String name;
    private String description;
    private Status status;
    private String assignedTo;
    private Calendar dueDate;
    private Boolean created;

    public TaskDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getCreated() {
        return created;
    }

    public void setCreated(Boolean created) {
        this.created = created;
    }
}
