package dev.brahms;

import dev.brahms.Exception.InsufficientBalanceException;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Event implements Registrable{

    private String text;
    private LocalDateTime dateEvent;
    private double price;
    private ArrayList<Member> members;

    public Event() {}

    public Event(String text, String dateEvent, double price) {
        this.text = text;
        this.dateEvent = LocalDateTime.parse(dateEvent);
        this.price = price;
        this.members = new ArrayList<>();
    }

    public Event(String text, String dateEvent) {
        this.text = text;
        this.dateEvent = LocalDateTime.parse(dateEvent);
        this.price = 0d;
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

    @Override
    public void register(Person p) {

        if( !(p instanceof Member)) {
            throw new InsufficientBalanceException("This person doesn't have a member");
        }

        Member member = (Member) p;

        if( member.getMoney() < this.price) {
            throw new InsufficientBalanceException("This person doesn't have enough money");
        }

        this.members.add(member);
        member.getEvents().add(this);

    }
}
