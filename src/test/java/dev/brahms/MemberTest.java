package dev.brahms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void testConstructor() {

        Member member = new Member("Bob", "Sull", 'h', "bob");

        assertEquals("Bob", member.getFirstname());
        assertEquals("Sull", member.getLastname());
        assertEquals('h', member.getGender());
        assertEquals("bob", member.getLogin());

    }

    @Test
    void testToString() {

        Member member = new Member("Bob", "Sull", 'h', "bob");
        Status status_vip = Status.VIP;
        member.setStatus(status_vip);

        Event event1 = new Event("Concert", "2023-04-24T18:30", 30d);
        Event event2 = new Event("Party", "2022-04-24T18:30");
        member.getEvents().add(event1);
        member.getEvents().add(event2);


        String result = "Bob Sull - VIP\n" +
                "- Concert\n" +
                "- Party\n";

        assertEquals(result, member.toString());
    }

}