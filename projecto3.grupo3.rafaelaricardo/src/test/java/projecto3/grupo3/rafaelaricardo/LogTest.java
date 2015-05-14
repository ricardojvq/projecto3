package projecto3.grupo3.rafaelaricardo;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LogTest extends TestCase {

	@Mock
	History calcHistory;
	@Mock
	Statistics calcStatistics;
	@InjectMocks
	private Calculator calc;

	@Override
	@Before
	public void setUp() {
	}

	@Test
	public void testExp1() {

		String expression = "log10(5)";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();
		double nr = Double.parseDouble(exprFinal);
		assertEquals(Math.log10(5), nr, 0d);

	}

	@Test
	public void testExp2() {
		String expression = "2log(e)";

		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();
		double nr = Double.parseDouble(exprFinal);
		assertEquals(2d, nr, 0d);
	}

}
