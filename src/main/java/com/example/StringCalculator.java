package com.example;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class StringCalculator {

    private String numbers;

    int add(@org.jetbrains.annotations.NotNull String numbers) throws RuntimeException {
        this.numbers = numbers;

        ArrayList<String> allDelimiters = new ArrayList<>();
        allDelimiters.add(";");
        int delimiterIndex = 0;
        int results = 0;

        ArrayList<String> negativeNumberList = new ArrayList();
        numbers = stringNumbersFormatter(numbers, allDelimiters);


        for (String allDelimiter : allDelimiters) { //For loop to replace all the delimiters gathered with ',' .
            numbers = numbers.replace(allDelimiter.trim(), ",");
        }

        return stringNumbersParser(numbers, negativeNumberList);
    }

    private int stringNumbersParser(@NotNull String numbers, ArrayList<String> negativeNumberList) {
        int results = 0;
        String[] stringArray = numbers.split("[;?\\n|,]+");

        if ((stringArray.length > 0) && !(numbers.isBlank())) {
            for (String stringArrayMember : stringArray) {
                if (!stringArrayMember.isBlank()) {
                    if (Integer.parseInt(stringArrayMember.trim()) < 0)
                        negativeNumberList.add(stringArrayMember.trim());
                    else if (Integer.parseInt(stringArrayMember.trim()) < 1001)
                        results += Integer.parseInt(stringArrayMember.trim());// trimming the string for unnecessary values!
                }
            }
        }

        if (!negativeNumberList.isEmpty())
            throw new RuntimeException("negatives not allowed:" + negativeNumberList);
        return results;
    }

    @NotNull
    private String stringNumbersFormatter(@NotNull String numbers, ArrayList<String> allDelimiters) {
        int delimiterIndex;
        if (numbers.startsWith("//")) {

            delimiterIndex = numbers.indexOf("//") + 2;

            if ((numbers.indexOf('[') == delimiterIndex)) {//looking for the delimiter which should starts with '['.
                do {
                    allDelimiters.add(numbers.substring(numbers.indexOf('[') + 1, numbers.indexOf(']')));
                    numbers = numbers.substring(numbers.indexOf(']') + 1);//delete string before ']'.
                } while (numbers.contains("["));

            } else if (!(numbers.indexOf('[') == delimiterIndex)) {

                allDelimiters.add(numbers.substring(delimiterIndex, delimiterIndex + 1));
                numbers = numbers.substring(3);//deletes the string after 3rd position.
            }
        }
        numbers = numbers.substring(numbers.indexOf("n") + 1);// retaining the numbers string after \n.
        return numbers;
    }

}
