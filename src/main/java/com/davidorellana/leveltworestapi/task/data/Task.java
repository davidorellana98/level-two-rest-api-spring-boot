package com.davidorellana.leveltworestapi.task.data;

import com.davidorellana.leveltworestapi.task.dto.TaskDto;

import java.util.Calendar;

public class Task {

    private Integer id;
    private String name;
    private String description;
    private Status status;
    private String assignedTo;
    private Calendar dueDate;
    private Boolean created;
    private static Integer idIncrement = 1;

    public Task(TaskDto taskDto) {
        this.id = idIncrement++;
        this.name = taskDto.getName();
        this.description = taskDto.getDescription();
        this.status = taskDto.getStatus();
        this.assignedTo = taskDto.getAssignedTo();
        this.dueDate = taskDto.getDueDate();
        this.created = taskDto.getCreated();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
