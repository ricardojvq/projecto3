package projecto3.grupo3.rafaelaricardo;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import junit.framework.TestCase;

import org.jmock.auto.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PercentageTest extends TestCase {

	@Mock
	History calcHistory;
	@Mock
	Statistics calcStatistics;
	@InjectMocks
	private Calculator calc;

	@Test(expected = java.lang.NumberFormatException.class)
	public void exceptionPercentageTest() {
		String expr = "cos(3)%";
		calc.setExpression(expr);
		calc.getPercentage();
	}

	@Test
	public void percentageTest() {
		String expr = "3%";
		calc.setExpression(expr);
		calc.getPercentage();
		String eFinal = calc.getExpression();
		assertEquals("3% é 0.03", "0.03", eFinal);
	}

	@Test
	public void percentageOfPercentage() {
		String e = "0.09 + 9%";
		calc.setExpression(e);
		calc.getPercentage();
		double dFinal = Double.parseDouble(calc.getExpression());
		assertThat(0.09809,is(closeTo(dFinal, 0.00001)));
	}

}
