package com.example;

public class StringCalculator {

    int add(String numbers) {

        String[] stringArray = numbers.replace(",", "\n").split("\n");
        int results = 0;

        if ((stringArray.length > 0) && !(numbers.isBlank())) {

            for (String stringArrayMember : stringArray) {

                results = results + Integer.parseInt(stringArrayMember);
            }

            return results;

        } else {

            return 0;
        }
    }

}
