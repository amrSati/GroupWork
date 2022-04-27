package edu.cds.stringandtextio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void parseHex() {
        assertEquals(165, Main.parseHex("A5"));
        assertEquals(Integer.parseInt("FAA", 16), Main.parseHex("FAA"));
        assertEquals(Integer.parseInt("ABC", 16), Main.parseHex("ABC"));
        assertEquals(Integer.parseInt("10A", 16), Main.parseHex("10A"));
    }

    @Test
    void parseBinary() {
        assertEquals(17, Main.parseBinary("10001"));
        assertEquals(Integer.parseInt("11111111", 2), Main.parseBinary("11111111"));
    }
}