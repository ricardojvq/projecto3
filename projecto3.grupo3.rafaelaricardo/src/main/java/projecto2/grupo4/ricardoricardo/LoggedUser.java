package projecto2.grupo4.ricardoricardo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;



@Named
@SessionScoped
public class LoggedUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
