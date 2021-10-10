package example;

public class CalculatorTest_Old {

    // 원하는 메소드만 테스트 + 실행 결과 값을 자동 Check하기 위해 JUnit 사용
    /*public static void main(String[] args) {
        example.Calculator cal = new example.Calculator();
        add(cal);
        subtract(cal);
        multiply(cal);
        divide(cal);
    }

    private static void add(example.Calculator cal) {
        System.out.println(cal.add(3,4));
    }

    private static void subtract(example.Calculator cal) {
        System.out.println(cal.subtract(5,4));
    }

    private static void multiply(example.Calculator cal) {
        System.out.println(cal.multiply(2,6));
    }

    private static void divide(example.Calculator cal) {
        System.out.println(cal.divide(8,4));
    }*/

    // 메소드 하나에서 프로덕션 코드의 여러 메소드를 동시에 테스트
    // -> 프로덕션 코드의 복잡도가 증가할수록 main 메소드를 유지하는데 부담이 되니 메소드별로 테스트 코드 분리
    /*public static void main(String[] args) {
        example.Calculator cal = new example.Calculator();
        System.out.println(cal.add(3,4));
        System.out.println(cal.subtract(5,4));
        System.out.println(cal.multiply(2,6));
        System.out.println(cal.divide(8,4));
    }*/
}
