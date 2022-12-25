package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {
    Map map;
    Location location;

    @BeforeEach
    void setUp() {
        map = new Map(100, 200);

    }

    @Test
    void putLocation() {
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
        map.PutLocation(new Location("museum", 75, 4));

        // 2
        System.setOut(printStream.get(1));
        map.PutLocation(new Location("park", 33, 25));

        // 3
        System.setOut(printStream.get(2));
        map.PutLocation(new Location("garden", 58, 180));

        // 4
        System.setOut(printStream.get(3));
        map.PutLocation(new Location("home", 30, 49));

        // 5
        System.setOut(printStream.get(4));
        map.PutLocation(new Location("secret places", 555, 99));

        // 6
        System.setOut(printStream.get(5));
        map.PutLocation(new Location("phone store", 88, 88));

        assertEquals("", output.get(0).toString());
        assertEquals("", output.get(1).toString());
        assertEquals("new Location is out of bounder!\r\n", output.get(2).toString());
        assertEquals("new Location is overlap!\r\n", output.get(3).toString());
        assertEquals("new Location is out of bounder!\r\n", output.get(4).toString());
        assertEquals("", output.get(5).toString());

//        assertEquals("LOL", test);
    }

    @Test
    void showMapList() {
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
        map.showMapList();
        assertEquals("\nMap:\r\n" +
                "hospital (30, 50)\r\n" +
                "supermarket (50, 70)\r\n" +
                "supermarket (70, 30)\r\n\r\n", output.get(0).toString());


        // 2
        System.setOut(printStream.get(1));
        map.PutLocation(new Location("secret places", 66, 97));
        map.showMapList();
        assertEquals("\nMap:\r\n" +
                "hospital (30, 50)\r\n" +
                "supermarket (50, 70)\r\n" +
                "supermarket (70, 30)\r\n" +
                "secret places (66, 97)\r\n\r\n", output.get(1).toString());
    }
//
    @Test
    void findLocation() {
        ArrayList<String> actual = new ArrayList<>();

        actual.add(map.FindLocation(30, 50));  // 1
        actual.add(map.FindLocation(31, 49));  // 2
        actual.add(map.FindLocation(10, 10));  // 3
        actual.add(map.FindLocation(77, 52));  // 4

        map.PutLocation(new Location("mountain", 77, 52));
        actual.add(map.FindLocation(77, 52));  // 5

        assertEquals("hospital (30, 50)", actual.get(0));
        assertEquals("hospital (30, 50)", actual.get(1));
        assertEquals("Can't find this place!", actual.get(2));
        assertEquals("Can't find this place!", actual.get(3));
        assertEquals("mountain (77, 52)", actual.get(4));
    }
}