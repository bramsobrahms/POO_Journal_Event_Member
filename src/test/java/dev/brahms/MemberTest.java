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

}