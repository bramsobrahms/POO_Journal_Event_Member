package dev.brahms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void testConstructor() {

        Event event = new Event("Concert", "2023-04-24T18:30", 30d);

        assertEquals("Concert", event.getText());
        assertEquals("2023-04-24T18:30", event.getDateEvent().toString());
        assertEquals(30d, event.getPrice());

    }

    @Test
    void testConstructorWithoutPrice() {
        Event event = new Event("Party", "2022-04-24T18:30");

        assertEquals("Party", event.getText());
        assertEquals("2022-04-24T18:30", event.getDateEvent().toString());
        assertEquals(0d, event.getPrice());
    }

}