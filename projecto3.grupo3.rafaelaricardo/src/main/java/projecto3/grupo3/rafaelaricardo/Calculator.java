package projecto3.grupo3.rafaelaricardo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.annotation.processing.RoundEnvironment;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

@Named
@SessionScoped
public class Calculator implements Serializable {

	private static final long serialVersionUID = 1L;
	private String expression = "0";
	private boolean reset = false;

	@Inject
	private History calcHistory;

	private ArrayList<String> operators;
	@Inject
	private Statistics calcStatistics;

	private boolean percentageValid = false;

	private int brackets = 0;
	
	private boolean syCalcShow = false;
	private boolean histDiv = false;
	private boolean statDiv = false;
	
	private long startTime;
	private long endTime;
	
	private ArrayList<HistTime> histAndTime = new ArrayList<HistTime>();



	public boolean isHistDiv() {
		return histDiv;
	}

	public void toggleHist() {
		if (this.histDiv == false) {
			this.histDiv = true;
		} else {
			this.histDiv = false;
		}
	}

	public boolean isStatDiv() {
		return statDiv;
	}

	public void toggleStat() {
		if (this.statDiv == false) {
			this.statDiv = true;
		} else {
			this.statDiv = false;
		}
	}

	public boolean isSyCalcShow() {
		return syCalcShow;
	}

	public void setSyCalcShow(boolean syCalcShow) {
		this.syCalcShow = syCalcShow;
	}
	
	public void showSyCalc() {
		this.syCalcShow = true;
	}
	
	public void hideSyCalc() {
		this.syCalcShow = false;
	}

	public Calculator() {
		operators = new ArrayList<String>();
	}

	public void key(ActionEvent event) {
		if (reset) {
			this.expression = "0";
			reset = false;
		}
		if (this.expression.equals("0")) {
			this.expression = "";
		}
		String add = "";
		String op = "";
		switch(event.getComponent().getId()) {
		case "AC": {
			this.expression = "0";
			break;
		} case "moreLess": { 
			negative();
			break;
		} case "percent": {
			startTime = System.nanoTime();
			this.expression += "%";
			String exprTemp = this.expression;
			getPercentage();
			if (percentageValid) { 
				op = "%";
				endTime = System.nanoTime();
				histAndTime.add(new HistTime(exprTemp, this.totalTime()));
				calcHistory.addToHistory(exprTemp);
			}
			break;
		} case "divide": {
			add = "/"; 
			op = "/";
			break;
		} case "multiply": {
			add = "*";
			op = "*";
			break;
		} case "plus": {
			add = "+";
			op = "+";
			break;
		} case "minus": {
			add = "-";	
			op = "-";
			break;
		} case "equal": {
			this.getResult();
			break;
		} case "del": {
			if (this.expression.length() > 1) {
				this.expression = this.expression.substring(0, expression.length()-1);
			} else if (this.expression.length() == 1) {
				this.expression = "0";
			} else {
				this.expression = "0";
			}
			break;
		} case "dot": {
			add = ".";
			break;
		} case "zero": {
			if (this.expression.length() > 0) {
				add = "0";
			} else {
				add = "0";
			}
			break;
		} case "one": {
			add = "1";
			break;
		} case "two": {
			add = "2";
			break;
		} case "three": {
			add = "3";
			break;
		} case "four": {
			add = "4";
			break;
		} case "five": {
			add = "5";
			break;
		} case "six": {
			add = "6";
			break;
		} case "seven": {
			add = "7";
			break;
		} case "eight": {
			add = "8";
			break;
		} case "nine": {
			add = "9";
			break;
		} case "sen": {
			add = "sin(";
			break;
		} case "cos": {
			add = "cos(";
			break;
		} case "tan": {
			add = "tan(";
			break;
		} case "asen": {
			add = "asin(";
			break;
		} case "acos": {
			add = "acos(";
			break;
		} case "atan": {
			add = "atan(";
			break;
		} case "ln": {
			add = "log(";
			break;
		} case "log": {
			add = "log10(";
			break;
		} case "factor": {
			this.addToExpression("!");
			getFactorial();
			break;
		} case "pot2": {
			add = "^2";
			break;
		} case "raiz2": {
			add = "sqrt(";
			break;
		} case "euler": {
			add = "e";
			break;
		} case "openP": {
			add = "(";
			break;
		} case "closeP": {
			add = ")";
			break;
		} case "modulo": {
			add = "abs(";
			break;
		} case "pi": {
			add = "PI";
			break;
		}
		}
		this.addToExpression(add);
		if (!op.equals("")) {
			operators.add(op);
		}
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public void addToExpression(String e) {
		this.expression += e;
	}

	public void negative() {
		String[] exp = expression.split("[-+*/]");
		if (expression.length() > 0) {
			int i = expression.indexOf(exp[exp.length-1]); // índice do último número (depois do operador)
			String last = exp[exp.length-1]; // último número
			if (i == 0) {
				expression = "-" + expression;
			} else if (i == 1 && expression.charAt(0) == '-') {
				expression = expression.substring(1);
			} else {
				if (expression.substring(i-1, i).equals("-")) {
					if (expression.substring(i-2, i-1).equals("+") || expression.substring(i-2, i-1).equals("*") || expression.substring(i-2, i-1).equals("/")) {
						expression = expression.substring(0, i-1) + last;
					} else {
						expression = expression.substring(0, i-1) + "+" + last;
					}
				} else {
					Double r = Double.parseDouble(last);
					Double f = r * -1;
					int ind = expression.indexOf(last);
					expression = expression.substring(0, ind) + Double.toString(f);
				}
			}
		} else {
			this.expression = "0";
		}
	}

	public void getPercentage() {
		String[] exp = expression.split("[-+*/]");
		String per = "";
		int indArray = 0;
		Double result = 0.0;
		for (String s:exp) {
			if (s.contains("%")) {
				per = s.substring(0, s.length()-1);
				break;
			}
			indArray++;
		}
		int i = expression.indexOf(per + "%");
		if (i == 0) {
			Double num = Double.parseDouble(per);
			Double percentage = num/100;
			expression = Double.toString(percentage);
			percentageValid = true;
		} else {
			double num1 = Double.parseDouble(exp[indArray-1]);
			double num2 = Double.parseDouble(per);
			if (expression.charAt(i-1) == '+') {
				result = num1 + (num1*num2)/100;
			} else if (expression.charAt(i-1) == '-') {
				result = num1 - (num1*num2)/100;
			} else if (expression.charAt(i-1) == '*') {
				result = (num1*num2)/100;
			} else {
				if (num2==0) {
					expression = "Erro: Divisao por zero!";
					result = 0.0;
				} else {
					result = (num1*100)/num2;
				}
			}
			if (result == 0.0) {
				// Do nothing
			} else {
				String r = Double.toString(result);
				int indDireita = expression.indexOf(exp[indArray-1]);
				expression = expression.substring(0, indDireita) + r;
				percentageValid = true;
			}
		}
	}

	public void getFactorial() {
		String fact;
		String[] expSplit = expression.split("[-+*/]");
		int index = -1;
		for (String s:expSplit) {
			index++;
			if (s.contains("!")) {
				String temp = s.substring(0,s.length()-1);
				long dTemp = Long.parseLong(temp);
				if (dTemp <= 1) {
					fact = "1";
				} else {
					long factTemp = 1;
					for (long i = dTemp; i > 1; i--) {
						factTemp *= i;
					}
					BigInteger bigResult = BigInteger.valueOf(factTemp);
					fact = bigResult.toString();
					expression = expression.replace(expSplit[index],fact);
				}
				break;
			}
		}
	}

	public void getResult() {
		startTime = System.nanoTime();
		if (expression.contains("!")) {
			getFactorial();
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(') brackets++;
			if (expression.charAt(i) == ')') brackets--;
		}
		if(brackets==0){
			double euler = Math.E;
			double pi = Math.PI;
			expression = expression.replaceAll("PI", Double.toString(pi));
			expression = expression.replaceAll("e", Double.toString(euler));

			Expression e = new ExpressionBuilder(expression)
			.build();
			try {
				String expr = this.expression;
				double result = e.evaluate();
				BigDecimal bigResult = BigDecimal.valueOf(result);
				expression = bigResult.toString();
				endTime = System.nanoTime();
				histAndTime.add(new HistTime(expr, this.totalTime()));
				calcHistory.addToHistory(expr);
				calcStatistics.addStatistics(operators);
			} catch (ArithmeticException ae) {
				expression = "Divisao por zero";
				this.reset = true;
			} catch (IllegalArgumentException ia) {
				expression = "Operacao invalida";
				this.reset = true;
			}
			operators.clear();
		}else{
			expression = "Operacao invalida";
			brackets=0;
		}

	}
	
	

	public ArrayList<HistTime> getHistAndTime() {
		return histAndTime;
	}

	public ArrayList<String> getCalcHistory() {
		return calcHistory.getHistoricocalculadora();
	}

	public void setCalcHistory(History calcHistory) {
		this.calcHistory = calcHistory;
	}

	public ArrayList<Operator> getCalcStatistics() {
		return calcStatistics.getStatistics();
	}

	public void setCalcStatistics(Statistics calcStatistics) {
		this.calcStatistics = calcStatistics;
	}

	public void reuse(ActionEvent ae) {
		expression = (String)ae.getComponent().getAttributes().get("reut");
	}
	
	public String totalTime() {
		long dif = endTime - startTime;
		double ms = (double)(dif/1000000.0);
		String f = String.format("%.2f",ms);
		return f+" ms";
	}



}
