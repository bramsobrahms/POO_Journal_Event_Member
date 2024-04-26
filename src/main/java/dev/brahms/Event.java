package dev.brahms;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Event {

    private String text;
    private LocalDateTime dateEvent;
    private double price;
    private ArrayList<Member> members;

    public Event(String text, LocalDateTime dateEvent, double price) {
        this.text = text;
        this.dateEvent = dateEvent;
        this.price = price;
        this.members = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(LocalDateTime dateEvent) {
        this.dateEvent = dateEvent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }
}
