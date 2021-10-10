package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Calculator.
 */
public class Calculator {

    private final String patternStr = "[\\/][\\/](.*?)[\\\\n]";

    /**
     * Add int.
     * 전달하는 문자를 구분자로 분리한 후 각 숫자의 합을 구해 반환한다.
     *
     * @param param the param
     * @return the int
     */
    public int add(String param) {
        System.out.println("[add] input : " + param);

        int totalVal = 0;

        // 1. 구분자 문자열 생성(정규식 포맷)
        String separator = createSeparator(param);

        // 2. 대상 값 조회
        List<Integer> valList = splitParam(param, separator);

        for(Integer val : valList) {
            // 3. 음수 여부 확인
            checkMinusVal(val);

            // 4. 값 더하기
            totalVal += val;
        }

        System.out.println("[add] output : " + totalVal);

        return totalVal;
    }

    /**
     * Create separator string.
     * 구분자 문자열 생성(정규식 포맷)
     *
     * @param param the param
     * @return the string
     */
    public String createSeparator(String param) {
        System.out.println("[createSeparator] input : " + param);

        // 콤마와 콜론은 Default -> 정규식으로 Split하기 위해 구분자를 OR(|)로 연결
        String separator = ",|:";

        // Custom 구분자가 있을 경우 Custom 구분자도 추가
        if(checkCustomSeparator(param)) {
            String customSeparator = getCustomSeparator(param);
            separator += "|" + customSeparator;
        }

        System.out.println("[createSeparator] output : " + separator);

        return separator;
    }

    /**
     * Check custom separator boolean.
     * Custom 구분자 존재 여부 확인
     *
     * @param param the param
     * @return the boolean
     */
    public boolean checkCustomSeparator(String param) {
        System.out.println("[checkCustomSeparator] input : " + param);

        boolean customSeparatorFlag = false;
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(param);

        if (matcher.find()) {  // 일치하는 게 있을 경우
            customSeparatorFlag = true;
        }

        System.out.println("[checkCustomSeparator] output : " + customSeparatorFlag);

        return customSeparatorFlag;
    }

    /**
     * Gets custom separator.
     * Custom 구분자 조회
     *
     * @param param the param
     * @return the custom separator
     */
    public String getCustomSeparator(String param) {
        System.out.println("[getCustomSeparator] input : " + param);

        String customSeparator = "";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(param);

        if (matcher.find()) {  // 일치하는 게 있을 경우
            customSeparator = matcher.group(1);
            System.out.println(matcher.group(1));
        }

        System.out.println("[getCustomSeparator] output : " + customSeparator);

        return customSeparator;
    }

    /**
     * Split param list.
     * 구분자를 기준으로 숫자 조회
     *
     * @param param     the param
     * @param separator the separator
     * @return the list
     */
    public List<Integer> splitParam(String param, String separator) {
        System.out.println("[splitParam] input : " + param + " , " + separator);
        String paramStr = param;

        // Custom 문자열이 있을 경우 Custom 문자열 관련 구문 제거
        if(checkCustomSeparator(param)) {
            int idx = param.indexOf("n");
            paramStr = param.substring(idx+1);
        }

        System.out.println("[splitParam] paramStr : " + paramStr);

        List<Integer> valList = new ArrayList<Integer>();
        String[] strArr = paramStr.split(separator);

        for(String str : strArr) {
            // 숫자 타입인지 확인
            checkNumber(str);
            valList.add(Integer.parseInt(str));
        }

        System.out.println("[splitParam] output : " + valList.toString());

        return valList;
    }

    /**
     * Check minus val.
     * 음수 여부 확인
     *
     * @param num the num
     */
    public void checkMinusVal(int num) {
        System.out.println("[checkMinusVal] input : " + num);

        // 값이 음수인 경우 RuntimeException 발생
        if(num < 0) {
            throw new RuntimeException("Value is Minus");
        }
    }

    /**
     * Check number.
     * 숫자 여부 확인
     *
     * @param inVal the inVal
     */
    public void checkNumber(String inVal) {
        System.out.println("[checkNumber] input : " + inVal);

        boolean numFlag = inVal.chars().allMatch( Character::isDigit);

        // 숫자가 아닌 경우 Exception 발생
        if (!numFlag) {
            throw new RuntimeException("Value is not number");
        }
    }

}
