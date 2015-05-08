package projecto3.grupo3.rafaelaricardo;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class RegisteredUsers implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ConcurrentHashMap<String,String> users;
	private ConcurrentSkipListSet<String> loggedUsers;
	
	public RegisteredUsers() {
		users = new ConcurrentHashMap<String, String>();
		loggedUsers = new ConcurrentSkipListSet<String>();
		users.put("ricardo", "123");
		users.put("rafaela", "456");
	}

	public ConcurrentHashMap<String, String> getUsers() {
		return users;
	}

	public void setUsers(ConcurrentHashMap<String, String> users) {
		this.users = users;
	}

	public ConcurrentSkipListSet<String> getLoggedUsers() {
		return loggedUsers;
	}

	public void setLoggedUsers(ConcurrentSkipListSet<String> loggedUsers) {
		this.loggedUsers = loggedUsers;
	}

}
