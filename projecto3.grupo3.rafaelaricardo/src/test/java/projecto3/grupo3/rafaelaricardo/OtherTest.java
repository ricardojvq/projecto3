package projecto3.grupo3.rafaelaricardo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OtherTest {
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
	public void testNegSQRT() {
		String expression = "sqrt(-1)";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();

		assertThat("Operacao invalida", equalTo(exprFinal));

	}

	@Test
	public void testPotSQRT() {
		String expression = "sqrt(2^2)";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();
		double nr = Double.parseDouble(exprFinal);

		assertEquals(2, nr, 0d);
	}

	@Test
	public void testEuler() {

		String expression = "7.2973525698*e";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();
		double nr = Double.parseDouble(exprFinal);

		assertEquals(7.2973525698 * Math.E, nr, 0d);
	}

	@Test
	public void testAbs() {
		String expression = "abs(-5000000)";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();
		double nr = Double.parseDouble(exprFinal);

		assertEquals(5000000.0, nr, 0d);

	}

}
