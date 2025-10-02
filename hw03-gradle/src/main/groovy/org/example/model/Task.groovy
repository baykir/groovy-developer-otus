package org.example.model

import java.time.LocalDateTime

class Task {
    private int id
    private String task
    private List <Action> actions = []
    private LocalDateTime start
    private LocalDateTime end

    //TODO: add description getter

    Task(int id, String task, List<Action> actions, LocalDateTime start, LocalDateTime end) {
        this.id = id
        this.task = task
        this.start = start
        this.end = end
    }

    void addAction(Action action) {
        //TODO: validate time. Action должны быть во временном отрезке Task (между start и end)
        actions.add(action)
    }

    void deleteAction(Action action) {
        actions.remove(action)
    }

    @Override
    String toString(){
        return "Task $start $end has ${actions.size()}"
    }

}
