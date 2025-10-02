package org.example.model

import java.time.LocalDateTime

class Action {
    private int id
    private String description
    private LocalDateTime starDateTime, endDateTime

    Action(int id, String description, LocalDateTime starDateTime, LocalDateTime endDateTime) {
        this.id = id
        this.description = description
        this.starDateTime = starDateTime
        this.endDateTime = endDateTime
    }

    @Override
    String toString(){
        return "Action $description begin at: $starDateTime, end at: $endDateTime"
    }
}
