package com.example;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StringCalculator {

    private String numbers;

    int add(@org.jetbrains.annotations.NotNull String numbers) throws RuntimeException {
        this.numbers = numbers;

        ArrayList<String> allDelimiters = new ArrayList<>();
        ArrayList<String> negativeNumberList = new ArrayList();
        allDelimiters.add(";");
        int delimiterIndex = 0;
        int results = 0;

        numbers = stringNumbersFormatter(numbers, allDelimiters);

        Comparator<String> stringLengthComparator = new Comparator<String>() {
            @Override
            public int compare(String string1, String string2) {
                return Integer.compare(string2.length(), string1.length());
            }//sorting all delimiters based on their length meaning '***' comes first and '**' comes later in the list.
        };
        Collections.sort(allDelimiters, stringLengthComparator);

        for (String allDelimiter : allDelimiters) { //For loop to replace all the delimiters gathered with ',' .
            numbers = numbers.replace(allDelimiter.trim(), ",");
        }
        return stringNumbersParser(numbers, negativeNumberList);
    }

    private int stringNumbersParser(@NotNull String numbers, ArrayList<String> negativeNumberList) {
        int results = 0;
        String[] stringArray = numbers.split("[;?\\n|,]+");

        var abc = Arrays.stream(stringArray)
                .mapToInt(t -> Integer.parseInt(t.substring(0,1)));
        

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
