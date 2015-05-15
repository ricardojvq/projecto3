package projecto3.grupo3.rafaelaricardo;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MsgBeanTest extends TestCase {

	@Mock 
	LoggedUser loggedUserMock;

	@Spy
	Chat chat;

	@InjectMocks
	private MsgBean msgBeanTest;

	@Override
	@Before
	public void setUp() {

	}

	@Before public void initMocks() {
		MockitoAnnotations.initMocks(this);

	}


	@Test
	public void testSendMsg() {
		msgBeanTest.setMessage("teste");
		msgBeanTest.sendMsg();
		assertEquals("teste", chat.getMessages().get(chat.getMessages().size() -1).getMessage());


	}

}
