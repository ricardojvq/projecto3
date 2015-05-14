package projecto3.grupo3.rafaelaricardo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Statistics implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Operator> stats;

	public Statistics() {
		stats = new ArrayList<>();
	}

	public void addStatistics(ArrayList<String> operators) { // Adiciona novos
																// operadores ao
																// Array e
																// contabiliza e
																// actualiza as
																// estat�sticas

		for (String o : operators) {
			String name = o;
			boolean cond = true;
			Operator op;
			if (stats.size() == 0) {
				op = new Operator(name);
				stats.add(op);
			} else {
				for (Operator s : stats) {
					if (s.getName().equals(name)) {
						s.setNumber();
						cond = false;
						break;
					}
				}
				if (cond) {
					op = new Operator(name);
					stats.add(op);
				}
			}

			double total = 0;
			for (Operator s : stats) { // Calcula o total de todos os operadores
										// utilizados
				total += s.getNumber();
				System.out.println("Total:" + total);
			}
			for (Operator s : stats) { // Calcula a percentagem de
										// utiliza��o de cada operador no
										// Array
				s.calcPercentage(total);
			}

		}
	}

	public ArrayList<Operator> getStatistics() {
		return stats;
	}

}
