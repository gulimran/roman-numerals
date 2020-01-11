package imran;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Theories.class)
public class RomanNumeralsTest {

    @DataPoints
    public static Set<Map.Entry<Integer, String> > data = testDataSet();

    private RomanNumerals classToTest;

    @Before
    public void setup() {
        classToTest = new RomanNumerals();
    }

    @Theory
    public void shouldGenerateExpectedRomanNumeralForGivenInteger(Map.Entry<Integer, String> entry) {
        assertThat(classToTest.getRomanNumeral(entry.getKey()), is(entry.getValue()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnEmptyString_WhenGivenInputIsZero() {
        classToTest.getRomanNumeral(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnEmptyString_WhenGivenInputIsNegative() {
        classToTest.getRomanNumeral(-26);
    }

    private static Set<Map.Entry<Integer, String>> testDataSet() {
        Map<Integer, String> dataSetMap = new HashMap<>();
        dataSetMap.put(1, "I");
        dataSetMap.put(3, "III");
        dataSetMap.put(4, "IV");
        dataSetMap.put(8, "VIII");
        dataSetMap.put(9, "IX");
        dataSetMap.put(10, "X");
        dataSetMap.put(27, "XXVII");
        dataSetMap.put(40, "XL");
        dataSetMap.put(49, "XLIX");
        dataSetMap.put(50, "L");
        dataSetMap.put(75, "LXXV");
        dataSetMap.put(90, "LC");
        dataSetMap.put(95, "LCV");
        dataSetMap.put(123, "CXXIII");
        dataSetMap.put(167, "CLXVII");
        dataSetMap.put(400, "CD");
        dataSetMap.put(680, "DCLXXX");
        dataSetMap.put(955, "DMLV");
        dataSetMap.put(1184, "MCLXXXIV");
        dataSetMap.put(3756, "MMMDCCLVI");

        return dataSetMap.entrySet();
    }
}
