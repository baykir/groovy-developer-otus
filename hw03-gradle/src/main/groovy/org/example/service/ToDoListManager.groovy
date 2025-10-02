package org.example.service

import org.example.model.Action
import org.example.model.Task
import org.example.store.TaskStore

class ToDoListManager {
    TaskStore taskStore

    ToDoListManager(TaskStore taskStore) {
        this.taskStore = taskStore
    }

    def addTask(Task task) {
        checkIntersections(task)
        taskStore.add(task)
        println "Task ${task} is added"
    }

    //TODO: add remove task method

    def showAllTasks() {
        def tasks = taskStore.findAll()
        if (tasks.isEmpty()){
            println "Tasks list is empty"
        } else {
            //TODO: show found tasks
        }
    }

    def addAction(taskId, Action action) {
        def task = taskStore.findSpecific(taskId)
        //todo проверить action на валидность по времени с другими action
        task.addAction(action)
        println "$action is added"
    }

    def showBusyTime(start, end) {
        return []
    }

    private checkIntersections(Task task) {
        // todo
    }
    // todo
}