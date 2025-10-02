package org.example.store

import org.example.model.Task

class TaskStore {

    List<Task> tasks = []

    def add(Task task) {
        tasks << task
    }

    def delete(Task task) {
        //tasks - task
        tasks.remove(task)
    }

    List<Task> findAll() {
        return tasks
    }

    Task findSpecific(int id){
        return tasks.find{it.id == id}
    }

}