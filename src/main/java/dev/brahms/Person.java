package dev.brahms;

/**
 * Represents a person with a first name, last name, and gender.
 */
public class Person {

    /** The first name of the person. */
    private String firstname;

    /** The last name of the person. */
    private String lastname;
    /** The gender of the person. */
    private char gender;

    /**
     * Constructs a person with the specified details.
     *
     * @param firstname The first name of the person.
     * @param lastname The last name of the person.
     * @param gender The gender of the person ('m' for male, 'f' for female, 'o' for other).
     */
    public Person(String firstname, String lastname, char gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
    }

    /**
     * Gets the first name of the person.
     *
     * @return The first name of the person.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the first name of the person.
     *
     * @param firstname The first name to set.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets the last name of the person.
     *
     * @return The last name of the person.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the last name of the person.
     *
     * @param lastname The last name to set.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets the gender of the person.
     *
     * @return The gender of the person ('m' for male, 'f' for female, 'o' for other).
     */
    public char getGender() {
        return gender;
    }

    /**
     * Sets the gender of the person.
     *
     * @param gender The gender to set ('m' for male, 'f' for female, 'o' for other).
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

}
