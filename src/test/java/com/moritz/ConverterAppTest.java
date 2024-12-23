package com.moritz;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConverterAppTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final ByteArrayInputStream originalIn = new ByteArrayInputStream(new byte[0]);

    @BeforeAll
    public static void setUpClass() {
        // Ensures the global environment is ready for testing
        System.setOut(new PrintStream(outContent));
        assertNotNull(System.out, "System.out should not be null at the beginning of tests.");
    }

    @AfterAll
    public static void tearDownClass() {
        // Clean up global resources
        System.setOut(originalOut);
        System.setIn(System.in);
    }

    @BeforeEach
    public void setUpStreams() {
        // Redirects output stream for each test
        outContent.reset();
    }

    @AfterEach
    public void restoreStreams() {
        // Ensures the output stream is reset after each test
        System.setOut(originalOut);
        System.setIn(System.in);
    }

    @Test
    public void testLifecycleInitialization() {
        // Verify that the lifecycle setup is working correctly
        assertNotNull(outContent, "Output content stream should be initialized.");
        assertEquals("", outContent.toString(), "Output content should be empty before tests.");
    }

    @Test
    public void testCelsiusToFahrenheitConversion() {
        String input = "1\n100\n0\n"; // Option 1 for Celsius to Fahrenheit, input 100, then exit
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ConverterApp.main(new String[]{});

        assertTrue(outContent.toString().contains("Ergebnis: 212.0\n"),
                   "Conversion from Celsius to Fahrenheit failed.");
    }

    @Test
    public void testFahrenheitToCelsiusConversion() {
        String input = "2\n212\n0\n"; // Option 2 for Fahrenheit to Celsius, input 212, then exit
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ConverterApp.main(new String[]{});

        assertTrue(outContent.toString().contains("Ergebnis: 100.0"),
                   "Conversion from Fahrenheit to Celsius failed.");
    }

    @Test
    public void testFootToMeterConversion() {
        String input = "4\n1\n0\n"; // Option 4 for Foot to Meter, input 1, then exit
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ConverterApp.main(new String[]{});

        assertTrue(outContent.toString().contains("Ergebnis: 0.3048"),
                   "Conversion from Foot to Meter failed.");
    }

    @Test
    public void testExitProgram() {
        String input = "0\n"; // Option 0 to exit
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ConverterApp.main(new String[]{});

        assertTrue(outContent.toString().contains("Das Programm wird beendet!"),
                   "Program did not exit as expected.");
    }
}
