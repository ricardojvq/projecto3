package projecto3.grupo3.rafaelaricardo;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomaTest extends TestCase {
	
	@Mock History calcHistory;
	@Mock Statistics calcStatistics;
	@InjectMocks private Calculator calc;
	
	@Before
	public void setUp() {
		
	}

	@Test
	public void testGetExpression() {
		String expression = "10+3";
		calc.setExpression(expression);
		calc.getResult();
		String exprFinal = calc.getExpression();
		assertThat("13.0", equalTo(exprFinal));
	}

}
