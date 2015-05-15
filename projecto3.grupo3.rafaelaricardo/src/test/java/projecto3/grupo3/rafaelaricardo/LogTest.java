package projecto3.grupo3.rafaelaricardo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
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

	@Test
	public void lnE() {
		String e = "log(e)";
		calc.setExpression(e);
		calc.getResult();
		String eFinal = calc.getExpression();
		assertThat("1.0",equalTo(eFinal));
	}

	@Test
	public void logTest() {
		String e = "log(log10(e)+3*9/2.5)";
		calc.setExpression(e);
		calc.getResult();
		double dFinal = Double.parseDouble(calc.getExpression());
		assertThat(2.41897,is(closeTo(dFinal,0.00001)));
	}

}
