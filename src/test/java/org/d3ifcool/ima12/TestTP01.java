package org.d3ifcool.ima12;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTP01 {

    private static final String[] INPUT = {
            "2\n1 2\n3 4",
			"3\n1 2 3\n4 5 6\n7 8 9"
    };
    private static final String[] OUTPUT = {
            "2 1\n4 3",
			"3 2 1\n6 5 4\n9 8 7"
    };

    @Test
    public void testTP() {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        for (int i = 0; i < INPUT.length; i++) {
            System.setIn(new ByteArrayInputStream(INPUT[i].getBytes()));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(bos));

            TP01.main(null);

            assertEquals(OUTPUT[i] + "\n", bos.toString());
        }

        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}
