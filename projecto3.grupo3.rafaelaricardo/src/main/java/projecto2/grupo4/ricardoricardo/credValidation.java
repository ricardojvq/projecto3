package projecto2.grupo4.ricardoricardo;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named
@ApplicationScoped
public class credValidation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ConcurrentHashMap<String,String> users;
	
	private String username;
	private String password;
	private String result = "";
	private boolean errorMsg = false;

	public credValidation() {
		users = new ConcurrentHashMap<String, String>();
		users.put("ricardo", "123");
		users.put("rafaela", "456");
	}

	public ConcurrentHashMap<String, String> getUsers() {
		return users;
	}

	public void setUsers(ConcurrentHashMap<String, String> users) {
		this.users = users;
	}

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
		if (users.containsKey(username)) {
			if (password.equals(users.get(username))) {
				errorMsg = false;
				result = "calc1.xhtml?faces-redirect=true";
				username = "";
				password = "";
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
	
	public void doLogout() {
		
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
		if (users.containsKey(username)) {
			errorMsg = true;
			result = "Já existente!";
		} else {
			if (password != null) {
				users.put(username, password);
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
