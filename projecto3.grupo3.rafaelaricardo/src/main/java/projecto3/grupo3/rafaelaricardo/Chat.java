package projecto3.grupo3.rafaelaricardo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Chat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int count = 0;
	
	private CopyOnWriteArrayList<Message> messages = new CopyOnWriteArrayList<Message>();

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(CopyOnWriteArrayList<Message> messages) {
		this.messages = messages;
	}
	
	public void sendMessage(Message msg) {
		messages.add(msg);
		
	}
	
	public int getCount() {
		return count;
	}
	
	public void sentMsg() {
		count++;
	}

}
