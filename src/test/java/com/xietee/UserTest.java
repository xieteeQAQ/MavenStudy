package com.xietee;

import com.xietee.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    void equalsShouldCompareContent() {
        User u1 = new User("xietee", 18);
        User u2 = new User("xietee", 18);
        assertEquals(u1, u2);
        assertEquals(u1.hashCode(), u2.hashCode());
    }
}
