package projecto3.grupo3.rafaelaricardo;

public class Operator {

	private String name;
	private int number;
	private String percentage;
	
		
	public Operator(String name) {
		super();
		this.name = name;
		number=1;
		
	}

	public String getName() {
		return name;
	}

	public void setNumber() {
		this.number++;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void calcPercentage(double total) {
		Double p = ((number/total)*100);
		percentage = String.format("%.1f", p);
	}
	
	public String getPercentage(){
		return percentage;
	}
	
}
