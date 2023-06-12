package me.belk.demojsp;

import java.time.LocalDateTime;

public class Event {
    private String name;
    private LocalDateTime start;

    public void setName(String name) {
        this.name = name;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStart() {
        return start;
    }
}
