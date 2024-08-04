package org.example.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));   // Output: 3
        System.out.println(romanToInt("IV"));    // Output: 4
        System.out.println(romanToInt("IX"));    // Output: 9
        System.out.println(romanToInt("LVIII")); // Output: 58
        System.out.println(romanToInt("MCMXCIV")); // Output: 1994

        System.out.println(romanToInt_useHashMap("III"));   // Output: 3
        System.out.println(romanToInt_useHashMap("IV"));    // Output: 4
        System.out.println(romanToInt_useHashMap("IX"));    // Output: 9
        System.out.println(romanToInt_useHashMap("LVIII")); // Output: 58
        System.out.println(romanToInt_useHashMap("MCMXCIV")); // Output: 1994
    }

    public static int romanToInt_useHashMap(String s) {
        Map<Character, Integer> romanToValue = new HashMap<>();
        romanToValue.put('I', 1);
        romanToValue.put('V', 5);
        romanToValue.put('X', 10);
        romanToValue.put('L', 50);
        romanToValue.put('C', 100);
        romanToValue.put('D', 500);
        romanToValue.put('M', 1000);

        int total = 0;
        int i = 0;
        while (i < s.length()) {
            int currentValue = romanToValue.get(s.charAt(i));
            if (i + 1 < s.length() && romanToValue.get(s.charAt(i+1)) > currentValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            i++;
        }
        return total;
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
