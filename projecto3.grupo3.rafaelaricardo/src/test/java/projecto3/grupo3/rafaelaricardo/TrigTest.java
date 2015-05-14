package projecto3.grupo3.rafaelaricardo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TrigTest {
	@Mock
	History calcHistory;
	@Mock
	Statistics calcStatistics;

	@InjectMocks
	private Calculator calc;

	@Before
	public void setUp() {
	}

	@Test
	public void testExpression() throws Exception {
		final double x = 1.0, y = 2.0;

		String expression = "log10(1.0)-2.0*(sqrt(1.0^cos(2.0)))";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();
		double nr = Double.parseDouble(exprFinal);

		assertThat((Math.log10(x) - y * Math.sqrt(Math.pow(x, Math.cos(y)))),
				is(closeTo(nr, 0.00001)));
	}

	@Test
	public void testCos() throws Exception {
		String expression = "cos(PI)";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();
		double nr = Double.parseDouble(exprFinal);

		assertEquals(-1d, nr, 0d);
	}

	@Test
	public void testSen() throws Exception {
		String expression = "sin(PI)";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();
		double nr = Double.parseDouble(exprFinal);

		assertEquals(Math.sin(Math.PI), nr, 0d);
	}

	@Test
	public void testTan2() throws Exception {
		String expression = "tan(PI)";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();
		double nr = Double.parseDouble(exprFinal);

		assertEquals(Math.tan(Math.PI), nr, 0d);
	}

	@Test
	public void testCos2() {
		final double x = 0.5, y = 0.25;
		String expression = "2cos(0.5*0.25)";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();
		double nr = Double.parseDouble(exprFinal);

		assertEquals(2d * Math.cos(x * y), nr, 0d);
	}
}
