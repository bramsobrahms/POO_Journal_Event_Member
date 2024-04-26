package dev.brahms;

import dev.brahms.Exception.InsufficientBalanceException;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Represents an event that can be registered by members.
 */
public class Event implements Registrable{

    /** The name or description of the event. */
    private String text;
    /** The date and time of the event. */
    private LocalDateTime dateEvent;
    /** The price of the event. */
    private double price;
    /** The list of members registered for the event. */
    private ArrayList<Member> members;

    /**
     *  Constructs by default
     */
    public Event() {}

    /**
     * Constructs an event with the specified text, date, and price.
     *
     * @param text The name or description of the event.
     * @param dateEvent The date and time of the event in the format "yyyy-MM-dd'T'HH:mm".
     * @param price The price of the event.
     */
    public Event(String text, String dateEvent, double price) {
        this.text = text;
        this.dateEvent = LocalDateTime.parse(dateEvent);
        this.price = price;
        this.members = new ArrayList<>();
    }

    /**
     * Constructs an event with the specified text and date.
     *
     * @param text The name or description of the event.
     * @param dateEvent The date and time of the event in the format "yyyy-MM-dd'T'HH:mm".
     */
    public Event(String text, String dateEvent) {
        this.text = text;
        this.dateEvent = LocalDateTime.parse(dateEvent);
        this.price = 0d;
        this.members = new ArrayList<>();
    }

    /**
     * Gets the text of the event.
     *
     * @return The text of the event.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text of the event.
     *
     * @param text The text to set.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets the date and time of the event.
     *
     * @return The date and time of the event.
     */
    public LocalDateTime getDateEvent() {
        return dateEvent;
    }

    /**
     * Sets the date and time of the event.
     *
     * @param dateEvent The date and time to set.
     */
    public void setDateEvent(LocalDateTime dateEvent) {
        this.dateEvent = dateEvent;
    }

    /**
     * Gets the price of the event.
     *
     * @return The price of the event.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the event.
     *
     * @param price The price to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the list of members registered for the event.
     *
     * @return The list of members registered for the event.
     */
    public ArrayList<Member> getMembers() {
        return members;
    }

    /**
     * Sets the list of members registered for the event.
     *
     * @param members The list of members to set.
     */
    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    /**
     * Registers a person for the event.
     *
     * @param p The person to register.
     * @throws InsufficientBalanceException If the person is not a member or does not have enough money.
     */
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
