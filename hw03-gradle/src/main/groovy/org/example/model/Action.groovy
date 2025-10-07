package org.example.model

import java.time.LocalDateTime

class Action {
    private int id
    private Task task
    private String name
    private LocalDateTime startDateTime, endDateTime

    Action(int id, String name, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.id = id
        this.name = name
        this.startDateTime = startDateTime
        this.endDateTime = endDateTime
    }

    Action(int id, Task task, String name, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.id = id
        task.addAction(this)
        this.name = name
        this.startDateTime = startDateTime
        this.endDateTime = endDateTime
    }

    String getName() {
        return name
    }

    @Override
    String toString(){
        return "Action $name begin at: $startDateTime, end at: $endDateTime"
    }
}
