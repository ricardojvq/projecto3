package projecto3.grupo3.rafaelaricardo;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class credValidation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private RegisteredUsers users; // Lista de utilizadores registados

	@Inject
	private LoggedUser loggedUser; // Utilizador corrente

	private String username; // String para validação de login
	private String password; // String para validação de login
	private String result = "";
	private boolean errorMsg = false;
	
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

	@SuppressWarnings("static-access")
	public String doLogin() {
		if (users.getUsers().containsKey(username)) {
			if (password.equals(users.getUsers().get(username))) {
				if (users.getLoggedUsers().contains(username)) {
					errorMsg = true;
					result = "Username já logado!";
				} else {
					errorMsg = false;
					loggedUser.setUsername(username);
					loggedUser.setLogged(true);
					faces.getCurrentInstance().getExternalContext().getSessionMap().put(LoggedUser.AUTH_KEY, username);
					users.getLoggedUsers().add(username);
					result = "/Authorized/calc1.xhtml?faces-redirect=true";
					username = "";
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
	
	@SuppressWarnings("static-access")
	public String doLogout() {
		faces.getCurrentInstance().getExternalContext().getSessionMap().remove(LoggedUser.AUTH_KEY);
		faces.getCurrentInstance().getExternalContext().invalidateSession();
		users.getLoggedUsers().remove(loggedUser.getUsername());
		return "/login.xhtml?faces-redirect=true";
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
		if (users.getUsers().containsKey(username)) {
			errorMsg = true;
			result = "Já existente!";
		} else {
			if (password != null) {
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
