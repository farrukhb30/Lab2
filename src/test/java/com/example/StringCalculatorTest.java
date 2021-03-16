package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void addTestWithNoNumber() {
        String numbers = "";
        int expected = 0;
        int actual = 0;

        StringCalculator stringCalculator = new StringCalculator();
        actual = stringCalculator.add(numbers);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addTestWithOneNumber() {
        String numbers = "4";
        int expected = 4;
        int actual = 0;

        StringCalculator stringCalculator = new StringCalculator();
        actual = stringCalculator.add(numbers);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addTestWithTwoNumbers() {
        String numbers = "5,55";
        int expected = 60;
        int actual = 0;

        StringCalculator stringCalculator = new StringCalculator();
        actual = stringCalculator.add(numbers);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addTestWithMultipleNumbers() {
        String numbers = "5,55,10,20";
        int expected = 90;
        int actual = 0;

        StringCalculator stringCalculator = new StringCalculator();
        actual = stringCalculator.add(numbers);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addTestWithDiffSeparatorBetweenNumbers() {
        String numbers = "1" + '\n' + "2,3";

        int expected = 6;
        int actual = 0;

        StringCalculator stringCalculator = new StringCalculator();
        actual = stringCalculator.add(numbers);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addTestWithDiffSeparatorBetweenNumbersAndDelimiter() {
        String numbers = "//;" + '\n' + "1;2";
        int expected = 3;
        int actual = 0;

        StringCalculator stringCalculator = new StringCalculator();
        actual = stringCalculator.add(numbers);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addTestWithDiffSeparatorBetweenNumbersAndDelimiterChange() {
        String numbers = "//&" + '\n' + "1&2&9&7";
        int expected = 19;
        int actual = 0;

        StringCalculator stringCalculator = new StringCalculator();
        actual = stringCalculator.add(numbers);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addTestWithExceptionForNegativeNumbers() {

        RuntimeException runtimeException = null;
        String numbers = "2,5,-8,3,-7,3,-12,15";
        String expected = "negatives not allowed:[-8, -7, -12]";
        int actual = 0;
        try {
            StringCalculator stringCalculator = new StringCalculator();
            actual = stringCalculator.add(numbers);
        } catch (RuntimeException exception) {
            runtimeException = exception;
        }

        Assertions.assertNotNull(runtimeException);
        Assertions.assertEquals(expected, runtimeException.getMessage());
    }

    @Test
    void addTestIgnoringBiggerNumbers() {

        RuntimeException runtimeException = null;
        String numbers = "2,1001,65,7,3,4000,9,45,2100";
        int expected = 131;
        int actual = 0;
        try {
            StringCalculator stringCalculator = new StringCalculator();
            actual = stringCalculator.add(numbers);
        } catch (RuntimeException exception) {
            runtimeException = exception;
        }
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addTestIgnoringBiggerNumbersPlusNegativeNumbersAndDelimiters() {

        RuntimeException runtimeException = null;
        String numbers = "//[***]" + '\n' + "1***2***3";
        int expected = 6;
        int actual = 0;
        try {
            StringCalculator stringCalculator = new StringCalculator();
            actual = stringCalculator.add(numbers);
        } catch (RuntimeException exception) {
            runtimeException = exception;
        }
        Assertions.assertEquals(expected, actual);
    }
}
