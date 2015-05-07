package projecto2.grupo4.ricardoricardo;

import java.text.DecimalFormat;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class HistTime {
	
	private String hist;
	private String time;
	
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
