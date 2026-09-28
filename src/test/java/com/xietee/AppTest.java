package com.xietee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit 5 (Jupiter) test for {@link App}.
 *
 * Location matters: src/test/java is the test source root, and the JUnit
 * dependency in pom.xml is declared with <scope>test</scope>, so these
 * imports only resolve inside src/test/java.
 */
class AppTest {
    @Test
    void testAdd() {
        assertEquals(5, App.add(2, 3));
    }
}
