package com.example;

import java.util.ArrayList;

public class StringCalculator {

    int add(String numbers) throws RuntimeException {

        String newDelimiter = " ";
        int results = 0;
        ArrayList<String> negativeNumberList = new ArrayList();

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
                if (!stringArrayMember.isBlank()) {

                    if (Integer.parseInt(stringArrayMember) < 0)
                        negativeNumberList.add(stringArrayMember);
                    else if (Integer.parseInt(stringArrayMember) < 1001)
                        results += Integer.parseInt(stringArrayMember);
                }
            }
        }

        if (!negativeNumberList.isEmpty())
            throw new RuntimeException("negatives not allowed:" + negativeNumberList);
        return results;
    }

}
