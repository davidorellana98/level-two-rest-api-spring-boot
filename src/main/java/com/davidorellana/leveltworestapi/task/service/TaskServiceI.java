package com.davidorellana.leveltworestapi.task.service;

import com.davidorellana.leveltworestapi.task.data.Task;

import java.util.HashMap;

public interface TaskServiceI {

    HashMap<Integer, Task> allTasks();

    Task createTask(Task task);

    Task findTaskById(Integer idTask);

    Task updateTask(Integer idTask, Task task);

    Task deleteTaskById(Integer idTask);
}
