package imran;

import java.util.TreeMap;

public class RomanNumerals {

    private TreeMap<Integer, String> romanNumeralsMap;

    public RomanNumerals() {
        romanNumeralsMap = new TreeMap<>();

        romanNumeralsMap.put(1, "I");
        romanNumeralsMap.put(4, "IV");
        romanNumeralsMap.put(5, "V");
        romanNumeralsMap.put(9, "IX");
        romanNumeralsMap.put(10, "X");
        romanNumeralsMap.put(40, "XL");
        romanNumeralsMap.put(50, "L");
        romanNumeralsMap.put(90, "LC");
        romanNumeralsMap.put(100, "C");
        romanNumeralsMap.put(400, "CD");
        romanNumeralsMap.put(500, "D");
        romanNumeralsMap.put(900, "DM");
        romanNumeralsMap.put(1000, "M");
    }

    public String getRomanNumeral(Integer number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number cannot be zero or less");
        }

        StringBuilder answer = new StringBuilder();

        Integer key = romanNumeralsMap.floorKey(number);

        if (number.equals(key)) {
            return romanNumeralsMap.get(key);
        }

        answer.append(romanNumeralsMap.get(key))
            .append(getRomanNumeral(number - key));

        return answer.toString();
    }
}
