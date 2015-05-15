package projecto3.grupo3.rafaelaricardo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class HistTime implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hist;
	private String time;

	public HistTime() {	}

	public HistTime(String h, String t) {
		this.hist = h;
		this.time = t;
	}

	public String getHist() {
		return hist;
	}

	public void setHist(String hist) {
		this.hist = hist;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
