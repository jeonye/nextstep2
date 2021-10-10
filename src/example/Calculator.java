package example;

public class Calculator {
    int add(int i, int j) {
        return i+j;
    }

    int subtract(int i, int j) {
        return i-j;
    }

    int multiply(int i, int j) {
        return i*j;
    }

    int divide(int i, int j) {
        return i/j;
    }

    // 테스트 코드의 경우 테스트 단계에서만 필요하기 때문에 테스트 코드는 CalculatorTest.java로 이동(프로덕션 코드와 테스트 코드 분리)
    /*public static void main(String[] args) {
        example.Calculator cal = new example.Calculator();
        System.out.println(cal.add(3,4));
        System.out.println(cal.subtract(5,4));
        System.out.println(cal.multiply(2,6));
        System.out.println(cal.divide(8,4));
    }*/
}
