package projecto3.grupo3.rafaelaricardo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

	private String message;
	private String username;
	private String date;

	@Override
	public String toString() {
		return "[" + date + "] " + username + ": " + message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDate() {
		return date;
	}

	public void setDate() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date data = new Date();
		this.date = dateFormat.format(data);
	}

}
