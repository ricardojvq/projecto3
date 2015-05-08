package projecto2.grupo4.ricardoricardo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class RegisteredUsers implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ConcurrentHashMap<String,String> users;
	private ArrayList<String> loggedUsers = new ArrayList<>();
	
	public RegisteredUsers() {
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

	public ArrayList<String> getLoggedUsers() {
		return loggedUsers;
	}

	public void setLoggedUsers(ArrayList<String> loggedUsers) {
		this.loggedUsers = loggedUsers;
	}
	
	public void addToLogged(String u) {
		loggedUsers.add(u);
	}
	
	
	
	

}
