package projecto3.grupo3.rafaelaricardo;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;

import mockit.integration.junit4.JMockit;

import org.easymock.EasyMock;
import org.easymock.TestSubject;
import org.jmock.Mock;
import org.jmock.cglib.MockObjectTestCase;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;



@RunWith(PowerMockRunner.class)
@PrepareForTest({FacesContext.class})
public class UserTest extends MockObjectTestCase {
	
	RegisteredUsers users;
	ConcurrentHashMap<String, String> unamePword;
	ArrayList<String> usersLogged;
	LoggedUser loggedU;
	credValidation cred;
	
	@Before
	public void setup() throws Exception {
		cred = new credValidation();
		cred.setUsers(new RegisteredUsers());
		cred.setLoggedUser(new LoggedUser());
	}
	
	
//	@Test
//	public void existentUser() {
//		cred.setUsername("ricardo");
//		cred.setPassword("123");
//		cred.newUser();
//		String result = cred.getResult();
//		assertEquals("Já existente!", result);
//	}
//	
//	@Test
//	public void invalidPassword() {
//		cred.setUsername("joao");
//		cred.setPassword("");
//		cred.newUser();
//		String result = cred.getResult();
//		assertEquals("Password inválida", result);
//	}
//	
//	@Test
//	public void newUserSuccess() {
//		cred.setUsername("joao");
//		cred.setPassword("abc");
//		cred.newUser();
//		String result = cred.getResult();
//		assertEquals("Utilizador criado com sucesso!", result);
//	}
	@Ignore
	@Test
	public void userLoginSuccess()  {
		FacesContext context = ContextMocker.mockFacesContext();
		ExternalContext ext = Mockito.mock(ExternalContext.class);
		HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
		HttpSession mockSession = Mockito.mock(HttpSession.class);
		Map<String, Object> sessionMap = new HashMap<String, Object>();
		Mockito.when(context.getExternalContext()).thenReturn(ext);
		Mockito.when(ext.getSessionMap()).thenReturn(sessionMap);
		cred.setUsername("ricardo");
		cred.setPassword("123");
		cred.setUsers(new RegisteredUsers());
		String result = cred.doLogin();
		assertEquals("/Authorized/calc1.xhtml?faces-redirect=true",result);
	}

}
