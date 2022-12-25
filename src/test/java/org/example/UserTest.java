package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    Map map;
    User user;
    UserDB userDB;

    @BeforeEach
    void setUp() {
        userDB.OnInitialized();
    }

    @Test
    void isLogIn() {
        ArrayList<ByteArrayOutputStream> output = new ArrayList<>();
        ArrayList<PrintStream> printStream = new ArrayList<>();

        for (int idx = 0; idx < 10; idx++) {
            output.add(new ByteArrayOutputStream());
        }

        for (ByteArrayOutputStream outputStream: output) {
            printStream.add(new PrintStream(outputStream, true));
        }

        // 1
        System.setOut(printStream.get(0));
        new User("joe", "1234").isLogIn();

        // 2
        System.setOut(printStream.get(1));
        new User("kirito", "1234").isLogIn();

        // 3
        System.setOut(printStream.get(2));
        new User("cindy", "3456").isLogIn();

        // 4
        System.setOut(printStream.get(3));
        new User("joe", "asd123").isLogIn();

        assertEquals("Login Success\r\n", output.get(0).toString());
        assertEquals("Login failed!\nPlease login again!\r\n", output.get(1).toString());
        assertEquals("Login Success\r\n", output.get(2).toString());
        assertEquals("Login failed!\nPlease login again!\r\n", output.get(3).toString());
    }

}