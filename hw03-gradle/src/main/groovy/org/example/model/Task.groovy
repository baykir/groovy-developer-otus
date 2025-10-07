package org.example.model

import java.time.LocalDateTime

class Task {
    private int id
    private String name
    private List <Action> actions = []
    private LocalDateTime start
    private LocalDateTime end

    String getTaskName(){
        return name
    }

    Task(int id, String name, LocalDateTime start, LocalDateTime end) {
        this.id = id
        this.start = start
        this.end = end
        this.name = name
    }

    Task(int id, String name, List<Action> actions, LocalDateTime start, LocalDateTime end) {
        this.id = id
        this.name = name
        this.start = start
        this.end = end
        this.actions = actions
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
        return "Task $name $start $end has ${actions.size()} actions: \n" +
                "\t"+ "${actions.name}"
    }

}
