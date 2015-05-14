package projecto3.grupo3.rafaelaricardo;

import junit.framework.TestCase;

import org.jmock.auto.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class) 
public class FactorialTest extends TestCase {

	@Mock History calcHistory;
	@Mock Statistics calcStatistics;
	@InjectMocks private Calculator calc;

	@Test
	public void factOfNumber() {
		calc.setExpression("15!");
		calc.getFactorial();
		String exp = calc.getExpression();
		assertEquals("1307674368000", exp);
	}

	@Test
	public void factOfNumberBiggerThanTwenty() {
		calc.setExpression("21!");
		calc.getFactorial();
		String exp = calc.getExpression();
		assertEquals("Numero muito grande", exp);
	}

	@Test
	public void factOfZero() {
		calc.setExpression("0!");
		calc.getFactorial();
		String exp = calc.getExpression();
		assertEquals("1", exp);
	}

	@Test
	public void factOfNull() {
		calc.setExpression("!");
		calc.getFactorial();
		String exp = calc.getExpression();
		assertEquals("1", exp);
	}

	@Test
	public void factOfOther() {
		calc.setExpression("cos()!");
		calc.getFactorial();
		String exp = calc.getExpression();
		assertEquals("Operacao Invalida", exp);
	}

	@Test
	public void factOfRealNumber() {
		calc.setExpression("2.5!");
		calc.getFactorial();
		String exp = calc.getExpression();
		assertEquals("Operacao Invalida", exp);
	}

}
