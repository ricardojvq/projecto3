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

	@Inject
	private RegisteredUsers regUsers;

	private Message msg;

	public MsgBean() {
		msg = new Message();
	}

	public void sendMsg(ActionEvent ae) {
		msg.setUsername(logUser.getUsername());
		msg.setDate();
		chat.sendMessage(msg);
	}

	public void logoutMsg(String uname) {
		msg.setUsername("AVISO");
		msg.setDate();
		msg.setMessage("( *** " + uname + " abandonou a sala ***)");
		chat.sendMessage(msg);
		if (regUsers.getLoggedUsers().size() == 0) {
			chat.getMessages().clear();
		}
	}

	public void timedOut() {
		msg.setUsername("AVISO");
		msg.setDate();
		msg.setMessage("( *** Sessão de " + logUser.getUsername()
				+ " expirou ***)");
		chat.sendMessage(msg);
	}

	public void setMessage(String message) {
		msg.setMessage(message);
	}

	public String getMessage() {
		return msg.getMessage();
	}

	public void loginMsg(String username) {
		msg.setUsername("AVISO");
		msg.setDate();
		msg.setMessage("( *** " + username + " entrou na sala *** )");
		chat.sendMessage(msg);
	}

}
