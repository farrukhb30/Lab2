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
        String numbers = "1"+'\n'+"2,3";

        int expected = 6;
        int actual = 0;

        StringCalculator stringCalculator = new StringCalculator();
        actual = stringCalculator.add(numbers);

        Assertions.assertEquals(expected, actual);
    }

}
