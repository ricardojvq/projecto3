var expr = document.getElementById("ecra").textContent;
var lastOperator = expr.charAt(expr.length-1);

function plus() {
	var expr = document.getElementById("ecra").textContent;
	var lastOperator = expr.charAt(expr.length-1);
    if (lastOperator == "+") {
				document.getElementById("formCalc:plus").style.color = "darkgray";
				document.getElementById("formCalc:plus").disabled = "disabled";
    }
}

function multiply() {
	var expr = document.getElementById("ecra").textContent;
	var lastOperator = expr.charAt(expr.length-1);
    if (lastOperator == "*") {
				document.getElementById("formCalc:multiply").style.color = "darkgray";
				document.getElementById("formCalc:multiply").disabled = "disabled";
    }
}

function divide() {
	var expr = document.getElementById("ecra").textContent;
	var lastOperator = expr.charAt(expr.length-1);
    if (lastOperator == "/") {
				document.getElementById("formCalc:divide").style.color = "darkgray";
				document.getElementById("formCalc:divide").disabled = "disabled";
    }
}
    
        