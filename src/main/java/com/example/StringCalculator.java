package com.example;

public class StringCalculator {

    int add(String numbers) {

        String newDelimiter = " ";
        int results = 0;

        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("//") + 2;
            newDelimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
            numbers = numbers.substring(3, numbers.length());
        }

        String[] stringArray = numbers.replace(",", "\n")
                .replace(";", "\n")
                .replace(newDelimiter, "\n")
                .split("\n");

        if ((stringArray.length > 0) && !(numbers.isBlank())) {

            for (String stringArrayMember : stringArray) {
                if(!stringArrayMember.isBlank())
                results += Integer.parseInt(stringArrayMember);

            }
        }
        return results;
    }

}
