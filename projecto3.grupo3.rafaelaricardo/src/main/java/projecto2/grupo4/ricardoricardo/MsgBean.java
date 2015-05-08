package projecto2.grupo4.ricardoricardo;

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
		chat.sentMsg();
		msg.setUsername(logUser.getUsername());
		msg.setDate();
		chat.sendMessage(msg);
		for (Message m:chat.getMessages()) {
			System.out.println(m.getMessage());
		}
	}
	
	public void setMessage(String message) {
		msg.setMessage(message);
	}
	
	public String getMessage() {
		return msg.getMessage();
	}
	

}
