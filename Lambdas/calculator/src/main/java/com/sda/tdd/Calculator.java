package com.sda.tdd;

//cerinta: Vezi OneNote JavaAdvance-4 (TDD)

import java.util.List;

public class Calculator {

    public int add(String s) {
        if ("".equals(s)) {
            return 0;
        }

        String[] split = s.split(",|\n");
        int sum = 0;
        for (String temp : split) {
            int value = Integer.parseInt(temp);
            if (value < 0) {
                throw new IllegalArgumentException("negatives not allowed");
            }
            sum += Integer.valueOf(temp);
        }

        return sum;
    }

    public long product(List<String> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        long product = 1;
        for (String temp : numbers) {
            long value = Long.parseLong(temp);
            if (value > 19) {
                System.out.println("Numarul " + temp + " nu este suportat.");
//                varianta 1:
//                continue;
            } /*varianta 2:*/ else {
                product *= value;
            }
        }

        return product;
    }
}
