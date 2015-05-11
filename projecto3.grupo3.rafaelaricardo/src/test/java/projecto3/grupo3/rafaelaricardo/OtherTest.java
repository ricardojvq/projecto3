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
	public void testPot() {
		String expression = "2^2";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();
		double nr = Double.parseDouble(exprFinal);

		// assertThat(Math.pow(2, 2), is(equalTo(exprFinal)));
		assertEquals(Math.pow(2, 2), nr, 0d);
	}
}
