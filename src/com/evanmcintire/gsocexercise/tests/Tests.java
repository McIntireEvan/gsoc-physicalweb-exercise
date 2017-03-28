package com.evanmcintire.gsocexercise.tests;

import com.evanmcintire.gsocexercise.GSOCExercise;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * Contains JUnit tests for this exercise
 */
public class Tests {
    /**
     * Tests using the given input stream
     */
    public static String testQueue(InputStream stream) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.setIn(stream);
        System.setOut(new PrintStream(output));
        GSOCExercise.queueInput();

        return output.toString();
    }

    /**
     * Simple test that uses given sample data
     */
    @Test
    public void testQueue1() {
        FileInputStream input = null;

        try {
            input = new FileInputStream("src/com/evanmcintire/gsocexercise/tests/queue1.in");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String output = testQueue(input);

        assertEquals((fileAsString("src/com/evanmcintire/gsocexercise/tests/queue1.out")), output);

        System.out.println(output.length());
    }

    /**
     * Tests using the given input stream
     */
    public static String testMedian(InputStream stream) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.setIn(stream);
        System.setOut(new PrintStream(output));
        GSOCExercise.runningMedian();

        return output.toString();
    }

    @Test
    public void testMedian1() {
        FileInputStream input = null;

        try {
            input = new FileInputStream("src/com/evanmcintire/gsocexercise/tests/median1.in");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String output = testMedian(input);

        assertEquals((fileAsString("src/com/evanmcintire/gsocexercise/tests/median1.out")), output);

        System.out.println(output.length());
    }

    public static String fileAsString(String file) {
        StringBuffer result = new StringBuffer();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            Scanner fileScanner = new Scanner(buffer);

            while (fileScanner.hasNextLine()) {
                result.append(fileScanner.nextLine() + "\n");
            }

            fileScanner.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return result.toString();
    }
}
