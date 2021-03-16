package com.example;

import java.util.ArrayList;

public class StringCalculator {


    private String numbers;

    int add(@org.jetbrains.annotations.NotNull String numbers) throws RuntimeException {
        this.numbers = numbers;

        ArrayList<String> allDelimiters = new ArrayList<>();
        allDelimiters.add(";");

        int results = 0;
        ArrayList<String> negativeNumberList = new ArrayList();
        String numbersAlterd = "";

        if (numbers.startsWith("//")) {

            int delimiterIndex = numbers.indexOf("//") + 2;

            if ((numbers.indexOf('[') == delimiterIndex)) {//looking for the delimiter which should starts with '['.

                allDelimiters.add(numbers.substring(numbers.indexOf('[') + 1, numbers.indexOf(']')));
                numbers = numbers.substring(numbers.indexOf(']') + 1);//delete rest of string after ']'.

            } else if (!(numbers.indexOf('[') == delimiterIndex)) {

                allDelimiters.add(numbers.substring(delimiterIndex, delimiterIndex + 1));
                numbers = numbers.substring(3);//deletes the string after 3rd position.
            }
        }
        numbers = numbers.substring(numbers.indexOf("n") + 1);

        for (String allDelimiter : allDelimiters) { //For loop to replace all the delimiters gathered with ',' .
            numbersAlterd = numbers.replace(allDelimiter.trim(), ",");
        }

        String[] stringArray = numbersAlterd.split("[;?\\n|,]+");

        if ((stringArray.length > 0) && !(numbersAlterd.isBlank())) {
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

}
