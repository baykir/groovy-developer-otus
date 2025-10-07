package org.example

import org.example.model.Action
import org.example.model.Task
import org.example.service.ToDoListManager
import org.example.store.TaskStore

import java.time.LocalDate
import java.time.LocalDateTime

static void main(String[] args) {
    LocalDate today = LocalDate.now()
    Action action1 = new Action(1, "Wake up", //создание отдельного действия без привязки к задаче
            today.atTime(9, 0), today.atTime(10, 0))
    Action action2 = new Action(2, 'Eat breakfast',
            today.atTime(9, 30), today.atTime(10, 0))
//    println action1
//    println action2
//
    Task task = new Task(1, 'Morning routines', [action1], //создание дела с одной задачью
            today.atTime(8, 00), today.atTime(11, 00))
    println task
    task.addAction(action2) //добавление задачи в созданное дело
    println(task)
//    println(task.getTaskDescription())

//    Action action2 = new Action(3, 'Brush teeth',
//            today.atTime(21, 00), today.atTime(21, 15))
//    Action action3 = new Action(4, 'Have a supper',
//            today.atTime(21, 20), today.atTime(21, 30))
//    Action action4 = new Action(5, 'Go to sleep',
//            today.atTime(21,45), today.atTime(22,00))

    Task task1 = new Task(1, 'Evening routines', //создание пустого дела
            today.atTime(21,00), today.atTime(22,00))

    println task1

    Action action = new Action(1, task1, 'Brush teeth', //создание задачи с добавление в дело
            today.atTime(21, 15), today.atTime(21, 30))

    println task1

    task.deleteAction(action1)

    println(task)

    task.deleteTask(task)

    println task
//
//    TaskStore taskStore = new TaskStore()
//    ToDoListManager manager = new ToDoListManager(taskStore)
    //manager.
}