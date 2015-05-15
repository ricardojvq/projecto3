package projecto3.grupo3.rafaelaricardo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class CredValidation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private RegisteredUsers users; // Lista de utilizadores registados

	@Inject
	private LoggedUser loggedUser; // Utilizador corrente

	@Inject
	private MsgBean msgBean;

	private String username; // String para validação de login
	private String password; // String para validação de login
	private String result = "";
	private boolean errorMsg = false;

	HttpSession session;

	@ManagedProperty("#{loggedUser}")
	FacesContext faces;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String doLogin() {
		synchronized (users.getLoggedUsers()) {
			if (users.getUsers().containsKey(username)) {
				if (password.equals(users.getUsers().get(username))) {
					if (users.getLoggedUsers().contains(username)) {
						errorMsg = true;
						result = "Utilizador com sessão iniciada e activa!";
					} else {
						errorMsg = false;
						loggedUser.setUsername(username);
						loggedUser.setLogged(true);
						users.getLoggedUsers().add(loggedUser.getUsername());
						msgBean.loginMsg(username);
						this.setFacesContext();
						result = "/Authorized/calc1.xhtml?faces-redirect=true";
						password = "";
					}
				} else {
					result = "Password inválida";
					errorMsg = true;
				}
			} else {
				result = "Username inexistente";
				errorMsg = true;
			}
			return result;
		}
	}

	public void setFacesContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ext = context.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("uname", username);
		ext.getSessionMap().put(LoggedUser.AUTH_KEY, username);
	}

	public void invalidateSession() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ext = context.getExternalContext();
		ext.invalidateSession();
	}

	public String doLogout() {
		String uname = loggedUser.getUsername();
		invalidateSession();
		synchronized (users.getLoggedUsers()) {
			users.getLoggedUsers().remove(
					users.getLoggedUsers().indexOf(loggedUser.getUsername()));
		}
		msgBean.logoutMsg(uname);
		return "/login.xhtml?faces-redirect=true";
	}

	@SuppressWarnings("static-access")
	public void timeOut() {
		msgBean.timedOut();
		faces.getCurrentInstance().getExternalContext().getSessionMap()
		.remove(LoggedUser.AUTH_KEY);
		faces.getCurrentInstance().getExternalContext().invalidateSession();
		users.getLoggedUsers().remove(loggedUser.getUsername());
		try {
			faces.getCurrentInstance().getExternalContext()
			.redirect("/Projecto3/login.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void timedOut() {
		users.getLoggedUsers().remove(loggedUser.getUsername());
	}

	public boolean isErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(boolean errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getResult() {
		return result;
	}

	public void newUser() {
		synchronized (users.getUsers()) {

			if (users.getUsers().containsKey(username)) {
				errorMsg = true;
				result = "Já existente!";
			} else {
				if (password != null && !password.equals("")) {
					users.getUsers().put(username, password);
					username = "";
					password = "";
					errorMsg = true;
					result = "Utilizador criado com sucesso!";
				} else {
					errorMsg = true;
					result = "Password inválida";
				}
			}
		}
	}

	public ArrayList<String> usersOnline() {
		return users.getLoggedUsers();
	}

	public void setUsers(RegisteredUsers u) {
		this.users = u;

	}

	public void setLoggedUser(LoggedUser lu) {
		this.loggedUser = lu;
	}

	public void setLoggedUsers(ArrayList<String> lUsers) {
		this.users.setLoggedUsers(lUsers);
	}

}
