package projecto3.grupo3.rafaelaricardo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BasicTest {

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
	public void testDivision() {
		String expression = "1450.5/75.5";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();
		double nr = Double.parseDouble(exprFinal);
		assertThat(19.21192053, is(closeTo(nr, 0.00001)));
	}

	@Test
	public void testPlus() {
		String expression = "10+3";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();
		assertThat("13.0", equalTo(exprFinal));

	}

	@Test
	public void testMutliply() {
		String expression = "10*3";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();
		assertThat("30.0", equalTo(exprFinal));
	}

	@Test
	public void testMinus() {
		String expression = "10-3";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();
		assertThat("7.0", equalTo(exprFinal));
	}

	@Test
	public void testDivbyZero() throws Exception {
		String expression = "1 / 0";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();

		assertThat("Divisao por zero", equalTo(exprFinal));

	}

}
