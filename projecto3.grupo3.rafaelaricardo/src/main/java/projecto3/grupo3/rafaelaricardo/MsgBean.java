package projecto3.grupo3.rafaelaricardo;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MsgBean {
	
	@Inject
	private Chat chat;
	
	@Inject
	private LoggedUser logUser;
	
	private Message msg;
	
	public MsgBean() {
		msg = new Message();
	}
	
	public void sendMsg(ActionEvent ae) {
		msg.setUsername(logUser.getUsername());
		msg.setDate();
		int count1 = chat.getCount();
		chat.sendMessage(msg);
		int count2 = chat.getCount();
		if (count1 != count2) {
			msg.setMessage("");
		}
	}
	
	public void logoutMsg() {
		msg.setUsername("Exit");
		msg.setDate();
		msg.setMessage("( *** "+logUser.getUsername()+" abandonou a sala ***)");
		chat.sendMessage(msg);
	}
	
	public void timedOut() {
		msg.setUsername("Timed out");
		msg.setDate();
		msg.setMessage("( *** Sessão de "+logUser.getUsername()+" expirou ***)");
		chat.sendMessage(msg);
	}
	
	public void setMessage(String message) {
		msg.setMessage(message);
	}
	
	public String getMessage() {
		return msg.getMessage();
	}
	

}
