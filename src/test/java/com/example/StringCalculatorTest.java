package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringCalculatorTest {

    @Test
    @DisplayName("Testing method with no number")
    void addTestForNoNumber() {
        String numbers = "";
        int expected = 0;
        int actual = 0;

        StringCalculator stringCalculator = new StringCalculator();
        actual = stringCalculator.add(numbers);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testing method with one number")
    void addTestForOneNumber() {
        String numbers = "4";
        int expected = 4;
        int actual = 0;

        StringCalculator stringCalculator = new StringCalculator();
        actual = stringCalculator.add(numbers);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testing method with two numbers")
    void addTestForTwoNumbers() {
        String numbers = "5,55";
        int expected = 60;
        int actual = 0;

        StringCalculator stringCalculator = new StringCalculator();
        actual = stringCalculator.add(numbers);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testing method with more than two numbers")
    void addTestForMultipleNumbers() {
        String numbers = "5,55,10,20";
        int expected = 90;
        int actual = 0;

        StringCalculator stringCalculator = new StringCalculator();
        actual = stringCalculator.add(numbers);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testing the change in delimiter and should handle '\n'")
    void addTestForDelimiter() {
        String numbers = "1" + '\n' + "2,3";

        int expected = 6;
        int actual = 0;

        StringCalculator stringCalculator = new StringCalculator();
        actual = stringCalculator.add(numbers);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testing method for different delimiter and pattern for delimiter")
    void addTestForNumbersAndDelimiter() {
        String numbers = "//;" + '\n' + "1;2";
        int expected = 3;
        int actual = 0;

        StringCalculator stringCalculator = new StringCalculator();
        actual = stringCalculator.add(numbers);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testing method for new delimiter using pattern")
    void addTestNumbersAndDelimiterChange() {
        String numbers = "//&" + '\n' + "1&2&9&7";
        int expected = 19;
        int actual = 0;

        StringCalculator stringCalculator = new StringCalculator();
        actual = stringCalculator.add(numbers);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Negative numbers and should generate exception with numbers")
    void addTestExceptionForNegatives() {

        String numbers = "2,5,-8,3,-7,3,-12,15";
        String expected = "negatives not allowed:[-8, -7, -12]";

        StringCalculator stringCalculator = new StringCalculator();
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> stringCalculator.add(numbers))
                .withMessage("negatives not allowed:[-8, -7, -12]");
    }

    @Test
    @DisplayName("Ignoring bigger than 1000 numbers")
    void addTestForBigNumbers() {

        String numbers = "2,1001,65,7,3,4000,9,45,2100";
        StringCalculator stringCalculator = new StringCalculator();
        int expected = 131;
        int actual = stringCalculator.add(numbers);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Pattern using more than one character delimiter")
    void addTestMultiCharactersDelimiters() {

        String numbers = "//[***]" + '\n' + "1***2***3";
        StringCalculator stringCalculator = new StringCalculator();
        int expected = 6;
        int actual = stringCalculator.add(numbers);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Pattern using one character multiple delimiters")
    void addTestSingleCharacterAndMultiDelimiters() {

        String numbers = "//[*][%]" + '\n' + "1*2%3";
        StringCalculator stringCalculator = new StringCalculator();
        int expected = 6;
        int actual = stringCalculator.add(numbers);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Pattern using multiple characters and multiple delimiters")
    void addTestMultiCharactersAndMultiDelimiters() {

        String numbers = "//[***][%%%%%]" + '\n' + "1%%%%%2***3%%%%%7";
        StringCalculator stringCalculator = new StringCalculator();
        int expected = 13;
        int actual = stringCalculator.add(numbers);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Pattern using multiple characters and multiple delimiters of varying lengths")
    void addTestMultiCharactersAndMultiDelimitersLongerLengths() {

        String numbers = "//[***][%%%%%][&&&&&&&&&&&][**]" + '\n' + "5**1%%%%%2***3%%%%%7&&&&&&&&&&&4***5";
        int expected = 27;
        StringCalculator stringCalculator = new StringCalculator();
        int actual = stringCalculator.add(numbers);
        assertEquals(expected, actual);
    }
}
