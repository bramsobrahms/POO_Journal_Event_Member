package dev.brahms;

import java.util.ArrayList;

public class Journal {

    private ArrayList<Event> events;

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "events=" + events +
                '}';
    }
}
