package projecto3.grupo3.rafaelaricardo;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
// @PrepareForTest({FacesContext.class,HttpSession.class})
public class UserTest extends TestCase {

	@SuppressWarnings("unused")
	private RegisteredUsers users;
	private ArrayList<String> usersLogged = new ArrayList<String>();
	private credValidation cred;

	@Before
	public void setup() throws Exception {
		cred = new credValidation();
		cred.setUsers(new RegisteredUsers());
		cred.setLoggedUser(new LoggedUser());
	}

	@Test
	public void existentUser() {
		cred.setUsername("ricardo");
		cred.setPassword("123");
		cred.newUser();
		String result = cred.getResult();
		assertEquals("Já existente!", result);
	}

	@Test
	public void invalidPassword() {
		cred.setUsername("joao");
		cred.setPassword("");
		cred.newUser();
		String result = cred.getResult();
		assertEquals("Password inválida", result);
	}

	@Test
	public void newUserSuccess() {
		cred.setUsername("joao");
		cred.setPassword("abc");
		cred.newUser();
		String result = cred.getResult();
		assertEquals("Utilizador criado com sucesso!", result);
	}

	@Test
	public void userLoginAlreadyLogged() {
		usersLogged.add("ricardo");
		cred.setLoggedUsers(usersLogged);
		cred.setUsername("ricardo");
		cred.setPassword("123");
		String result = cred.doLogin();
		assertEquals("Username já logado!", result);

	}

	@Test
	public void userLoginWrongPw() {
		usersLogged.add("ricardo");
		cred.setLoggedUsers(usersLogged);
		cred.setUsername("ricardo");
		cred.setPassword("000");
		String result = cred.doLogin();
		assertEquals("Password inválida", result);

	}

	@Test
	public void userLoginUnexistent() {
		cred.setUsername("abel");
		String result = cred.doLogin();
		assertEquals("Username inexistente", result);

	}

	// @Test
	// public void userLoginSuccess() throws Exception {
	// FacesContext context = ContextMocker.mockFacesContext();
	// ExternalContext ext = Mockito.mock(ExternalContext.class);
	// HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
	// HttpSession mockSession = new MockHttpSession();
	// Map<String, Object> sessionMap = new HashMap<String, Object>();
	// Mockito.when(context.getExternalContext()).thenReturn(ext);
	// Mockito.when(ext.getSessionMap()).thenReturn(sessionMap);
	// Mockito.when(mockRequest.getSession()).thenReturn(mockSession);
	// cred.setUsername("ricardo");
	// cred.setPassword("123");
	// cred.setUsers(new RegisteredUsers());
	// String result = cred.doLogin();
	// assertEquals("/Authorized/calc1.xhtml?faces-redirect=true",result);
	// }

}
