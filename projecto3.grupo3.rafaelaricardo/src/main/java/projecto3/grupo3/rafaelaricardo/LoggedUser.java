package projecto3.grupo3.rafaelaricardo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class LoggedUser implements Serializable {

	public static final String AUTH_KEY = "username";

	private static final long serialVersionUID = 1L;

	private String username;
	private boolean logged = false;

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
