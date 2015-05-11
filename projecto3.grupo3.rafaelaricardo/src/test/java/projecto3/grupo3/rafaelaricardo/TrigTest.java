package projecto3.grupo3.rafaelaricardo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;

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
	public void testExpressionBuilder16() throws Exception {
		final double x = 1.0, y = 2.0;

		String expression = "log10(1.0)-2.0*(sqrt(1.0^cos(2.0)))";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();
		double nr = Double.parseDouble(exprFinal);
		assertThat((Math.log10(x) - y * Math.sqrt(Math.pow(x, Math.cos(y)))),
				is(closeTo(nr, 0.00001)));
	}

}
