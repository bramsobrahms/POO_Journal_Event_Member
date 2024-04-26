package dev.brahms;

import java.util.ArrayList;

public class Member {

    private String login;
    private String password;
    private String email;
    private double money;
    private Status status;
    private ArrayList<Event> events;

    public Member(String login, String password, String email, double money, Status status) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.money = money;
        this.status = status;
        this.events = new ArrayList<>();
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
        return "Member{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", money=" + money +
                ", status=" + status +
                ", events=" + events +
                '}';
    }
}
