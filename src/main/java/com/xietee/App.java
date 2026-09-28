package com.xietee;

import com.xietee.model.User;
import org.apache.commons.lang3.StringUtils;

public class App {
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("Hello Maven!");
        System.out.println("2 + 3 = " + add(2, 3));

        System.out.println(StringUtils.reverse("hello"));

        User user = new User("you", 18);
        System.out.println(user);
    }
}
