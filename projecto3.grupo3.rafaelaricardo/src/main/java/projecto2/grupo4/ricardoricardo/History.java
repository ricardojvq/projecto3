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
	
	public History() {
		historicocalculadora = new ArrayList<String>();
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
	
	
	
	

}
