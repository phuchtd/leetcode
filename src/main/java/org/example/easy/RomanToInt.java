package org.example.easy;

import java.util.Arrays;
import java.util.List;

public class RomanToInt {
    public static void main(String[] args) {
        int case1 = romanToInt("III");
        System.out.println("III: " + case1);

        int case2 = romanToInt("LVIII");
        System.out.println("LVIII:" + case2);

        int case3 = romanToInt("MCMXCIV");
        System.out.println("MCMXCIV: " + case3);
    }

    public static int romanToInt(String s) {
        List<String> symbols = Arrays.asList(s.split(""));
        int number = 0;
        for (int i=0; i<symbols.size(); i++) {
            Roman roman1 = Roman.valueOf(symbols.get(i));
            if (i < symbols.size() -1) {
                Roman roman2 = Roman.valueOf(symbols.get(i+1));
                if (roman1.getPriority() < roman2.getPriority()) {
                    Roman roman = Roman.valueOf(symbols.get(i) + symbols.get(i+1));
                    number += roman.getValue();
                    i = i+1;
                    continue;
                }
            }
            number += roman1.getValue();
        }
        return number;
    }

    enum Roman {
        I(0, 1),
        V(1, 5),
        X(2, 10),
        L(3, 50),
        C(4, 100),
        D(5, 500),
        M(6, 1000),
        IV(-1, 4),
        IX(-1, 9),
        XL(-1, 40),
        XC(-1, 90),
        CD(-1, 400),
        CM(-1, 900);
        private int value;
        private int priority;

        private Roman(int priority, int value) {
            this.priority = priority;
            this.value = value;
        }
        public int getValue() {
            return value;
        }

        public int getPriority() {
            return priority;
        }
    }
}
