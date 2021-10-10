package practice;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator cal;
    private final String customSeparatorStr = "//;\\n1;2;3";
    private final String defaultSeparatorStr = "1,2,3";
    private final String allSeparatorStr = "//@\\n1,2:3@4";
    private final String undefinedSeparatorStr = "//@\\n1,2:3@4#5";

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setup() {
        cal = new Calculator();
    }

    @Test
    // Custom 구분자만 존재
    public void addTestWithOnlyCustomSeparator() {
        assertEquals(6, cal.add(customSeparatorStr));
    }

    @Test
    // 콤마 구분자만 존재
    public void addTestWithOnlyCommaSeparator() {
        assertEquals(6, cal.add(defaultSeparatorStr));
    }

    @Test
    // 콜론 구분자만 존재
    public void addTestWithOnlyColonSeparator() {
        assertEquals(6, cal.add(defaultSeparatorStr));
    }

    @Test
    // Default 구분자(콜론, 콤마)만 존재
    public void addTestWithOnlyDefaultSeperator() {
        assertEquals(6, cal.add(defaultSeparatorStr));
    }

    @Test
    // 모든 구분자(Custom + Default) 존재
    public void addTestWithAllSeperator() {
        assertEquals(10, cal.add(allSeparatorStr));
    }

    @Test
    // 선언되지 않은 구분자가 있을 경우
    public void addTestWithUndefinedSeperator() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Value is not number");

        assertEquals(6, cal.add(undefinedSeparatorStr));
    }

    @Test
    // Default 구분자(콜론, 콤마)만 존재
    public void createSeparatorTestWithOnlyDefaultSeperator() {
        String result = ",|:";
        assertEquals(result, cal.createSeparator(defaultSeparatorStr));
    }

    @Test
    // Custom 구분자만 존재
    public void createSeparatorTestWithOnlyCustomSeparator() {
        String result = ",|:|;";
        assertEquals(result, cal.createSeparator(customSeparatorStr));
    }

    @Test
    // 모든 구분자(Custom + Default) 존재
    public void checkCustomSeparatorTestWithAllSeperator() {
        assertTrue(cal.checkCustomSeparator(allSeparatorStr));
    }

    @Test
    // Default 구분자(콜론, 콤마)만 존재
    public void checkCustomSeparatorTestWithOnlyDefaultSeperator() {
        assertFalse(cal.checkCustomSeparator(defaultSeparatorStr));
    }

    @Test
    // 모든 구분자(Custom + Default) 존재
    public void getCustomSeparatorTestWithAllSeperator() {
        assertEquals("@", cal.getCustomSeparator(allSeparatorStr));
    }

    @Test
    // Default 구분자(콜론, 콤마)만 존재
    public void getCustomSeparatorTestWithOnlyDefaultSeperator() {
        assertEquals("", cal.getCustomSeparator(defaultSeparatorStr));
    }

    @Test
    // Default 구분자(콜론, 콤마)만 존재
    public void splitParamTestWithOnlyDefaultSeperator() {
        int[] stdArr = {1,2,3};
        List<Integer> resultList =  cal.splitParam(defaultSeparatorStr, ",|:");
        int[] resultArr = resultList.stream().mapToInt(i->i).toArray();

        assertArrayEquals(stdArr, resultArr);
    }

    @Test
    // 모든 구분자(Custom + Default) 존재
    public void splitParamTestWithAllSeperator() {
        int[] stdArr = {1,2,3,4};
        List<Integer> resultList =  cal.splitParam(allSeparatorStr, ",|:|@");
        int[] resultArr = resultList.stream().mapToInt(i->i).toArray();

        assertArrayEquals(stdArr, resultArr);
    }

    @Test
    // 선언되지 않은 구분자가 있을 경우
    public void splitParamTestWithUndefinedSeperator() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Value is not number");

        int[] stdArr = {1,2,3,4,5};
        List<Integer> resultList =  cal.splitParam(undefinedSeparatorStr, ",|:|@");
    }

    @Test
    // 음수인 경우
    public void checkMinusValTestWithMinusNum() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Value is Minus");

        cal.checkMinusVal(-1);
    }

    @Test
    // 양수인 경우
    public void checkMinusValTestWithPlusNum() {
        cal.checkMinusVal(0);
    }

    @Test
    // 숫자인 경우
    public void checkNumberTestWithNumber() {
        cal.checkNumber("3");
    }

    @Test
    // 숫자가 아닌 경우
    public void checkNumberTestWithString() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Value is not number");

        cal.checkNumber("3@4");
    }
}
