package calculator;

import calculator.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CaculatorTest {

    private Calculator cal;

    // @Before 메소드는 각 테스트 메소드가 실행되기 전에 동작
    // Caculator의 상태 값이 바껴 다음 테스트 메소드에 영향을 주지 않도록 인스턴스를 매 테스트마다 생성
    // @RunWith, @Rule 같은 어느테이션을 확장해서 사용할 수 있도록 @Before를 사용하는 습관 갖기
    @Before
    public void setup() {
        cal = new Calculator();
        System.out.println("before");
    }

    @Test
    public void add() {
        assertEquals(9, cal.add(6,3));
        System.out.println("add");
    }

    @Test
    public void subtract() {
        assertEquals(1, cal.subtract(5,4));
        System.out.println("subtract");
    }

    @Test
    public void multiply() {
        assertEquals(12, cal.multiply(2,6));
        System.out.println("multiply");
    }

    @Test
    public void divide() {
        System.out.println("divide");
        assertEquals(2, cal.divide(8,4));
    }

    @After
    public void teardown() {
        System.out.println("teardown");
    }
}
