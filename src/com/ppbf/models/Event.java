package com.ppbf.models;

public class Event {

    public String eventName;

    public Event(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return "Event{" + "eventName='" + eventName + '\'' + '}';
    }
}
