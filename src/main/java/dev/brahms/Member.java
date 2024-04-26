package dev.brahms;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a member, extending the Person class.
 */
public class Member extends Person{

    /** The login username of the member. */
    private String login;
    /** The password of the member. */
    private String password;
    /** The email address of the member. */
    private String email;
    /** The amount of money the member has. */
    private double money;
    /** The status of the member. */
    private Status status;
    /** The list of events the member is registered for. */
    private ArrayList<Event> events;

    /**
     * Constructs a member with the specified details.
     *
     * @param firstname The first name of the member.
     * @param lastname The last name of the member.
     * @param gender The gender of the member ('m' for male, 'f' for female, 'o' for other).
     * @param login The login username of the member.
     * @param password The password of the member.
     * @param email The email address of the member.
     */
    public Member(String firstname, String lastname, char gender, String login, String password, String email) {
        super(firstname, lastname, gender);
        this.login = login;
        this.password = password;
        this.email = email;
        this.money = 0d;
        this.status = Status.MEMBER;
        this.events = new ArrayList<>();
    }


    /**
     * Constructs a member with the specified details and default password and email.
     *
     * @param firstname The first name of the member.
     * @param lastname The last name of the member.
     * @param gender The gender of the member ('m' for male, 'f' for female, 'o' for other).
     * @param login The login username of the member.
     */
    public Member(String firstname, String lastname, char gender, String login) {
        this(firstname, lastname, gender, login, null, null );
    }

    /**
     * Gets the login username of the member.
     *
     * @return The login username of the member.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login username of the member.
     *
     * @param login The login username to set.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets the password of the member.
     *
     * @return The password of the member.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the member.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email address of the member.
     *
     * @return The email address of the member.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the member.
     *
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the amount of money the member has.
     *
     * @return The amount of money the member has.
     */
    public double getMoney() {
        return money;
    }

    /**
     * Sets the amount of money the member has.
     *
     * @param money The amount of money to set.
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * Gets the status of the member.
     *
     * @return The status of the member.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the status of the member.
     *
     * @param status The status to set.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Gets the list of events the member is registered for.
     *
     * @return The list of events the member is registered for.
     */
    public ArrayList<Event> getEvents() {
        return events;
    }

    /**
     * Sets the list of events the member is registered for.
     *
     * @param events The list of events to set.
     */
    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    /**
     * Returns a string representation of the member including their name, status, and registered events.
     *
     * @return A string representation of the member.
     */
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
