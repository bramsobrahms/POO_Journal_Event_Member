package dev.brahms;

import java.util.ArrayList;
import java.util.Iterator;

public class Member extends Person{

    private String login;
    private String password;
    private String email;
    private double money;
    private Status status;
    private ArrayList<Event> events;

    public Member(String firstname, String lastname, char gender, String login, String password, String email) {
        super(firstname, lastname, gender);
        this.login = login;
        this.password = password;
        this.email = email;
        this.money = 0d;
        this.status = Status.MEMBER;
        this.events = new ArrayList<>();
    }

    public Member(String firstname, String lastname, char gender, String login) {
        this(firstname, lastname, gender, login, null, null );
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {

        StringBuilder strBuild = new StringBuilder();

        strBuild.append(super.getFirstname()).append(" ")
                .append(super.getLastname()).append(" - ")
                .append(status).append("\n");

        Iterator<Event> iterEvent = events.iterator();
        while (iterEvent.hasNext()) {
            Event event = iterEvent.next();
            strBuild.append("- ").append(event.getText()).append("\n");
        }
        return strBuild.toString();
    }
}
