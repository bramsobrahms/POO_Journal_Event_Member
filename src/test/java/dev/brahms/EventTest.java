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

}