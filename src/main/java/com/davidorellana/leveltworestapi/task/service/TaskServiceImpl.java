package com.davidorellana.leveltworestapi.task.service;

import com.davidorellana.leveltworestapi.task.data.Task;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TaskServiceImpl implements TaskServiceI {

    private final HashMap<Integer, Task> taskData = new HashMap<>();

    @Override
    public HashMap<Integer, Task> allTasks() {
        return taskData;
    }

    @Override
    public Task createTask(Task task) {
        Integer keyTask = task.getId();
        return taskData.put(keyTask, task);
    }

    @Override
    public Task findTaskById(Integer idTask) {
        return taskData.get(idTask);
    }

    @Override
    public Task updateTask(Integer idTask, Task task) {
        return taskData.replace(idTask, task);
    }

    @Override
    public Task deleteTaskById(Integer idTask) {
        return taskData.remove(idTask);
    }
}
