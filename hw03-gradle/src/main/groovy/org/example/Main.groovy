package org.example

import org.example.model.Action
import org.example.service.ToDoListManager
import org.example.store.TaskStore

import java.time.LocalDate
import java.time.LocalDateTime

static void main(String[] args) {
    LocalDate today = LocalDate.now()
    Action action = new Action(1, "Wake up", today.atTime(9, 0),
            today.atTime(10, 0))
    println action

    TaskStore taskStore = new TaskStore()
    ToDoListManager manager = new ToDoListManager(taskStore)
    //manager.
}