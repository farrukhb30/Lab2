package com.example;

public class StringCalculator {

    int add(String numbers) {

        String[] stringArray = numbers.split(",");
        int results = 0;

        if ((stringArray.length == 1) && !(numbers.isBlank())) {

            results = Integer.parseInt(stringArray[0]);
            return results;
        } else if ((stringArray.length > 0 && stringArray.length < 3) && !(numbers.isBlank())) {

            results = Integer.parseInt(stringArray[0]) + Integer.parseInt(stringArray[1]);
            return results;
        } else {
            return 0;
        }
    }

}
