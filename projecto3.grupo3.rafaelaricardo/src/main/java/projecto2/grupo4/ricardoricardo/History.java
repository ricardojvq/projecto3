package projecto2.grupo4.ricardoricardo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
public class History implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> historicocalculadora;
	private ArrayList<String> temposcalculadora;
	
	private ArrayList<HistTime> histTime;
	

	public History() {
		historicocalculadora = new ArrayList<String>();
		temposcalculadora = new ArrayList<String>();
	}
	
	public void addToHistory(String e) {
		historicocalculadora.add(e);
	}

	public ArrayList<String> getHistoricocalculadora() {
		return historicocalculadora;
	}

	public void setHistoricocalculadora(ArrayList<String> historicocalculadora) {
		this.historicocalculadora = historicocalculadora;
	}
	
	public void addToTimes(String e) {
		temposcalculadora.add(e);
	}

	public ArrayList<String> getTemposcalculadora() {
		return temposcalculadora;
	}

	public void setTemposcalculadora(ArrayList<String> temposcalculadora) {
		this.temposcalculadora = temposcalculadora;
	}
	
	public void addToHistTime(String h, String t) {
		HistTime ht = new HistTime(h,t);
		histTime.add(ht);
	}
	
	public ArrayList<HistTime> getHistTime() {
		return histTime;
	}

	public void setHistTime(ArrayList<HistTime> histTime) {
		this.histTime = histTime;
	}
	
	
	
	
	
	

}
