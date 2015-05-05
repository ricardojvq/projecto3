function fact() {
	if (document.getElementById("ecra").textContent != "0") {
		var expr = document.getElementById("ecra").textContent;
		var fact = "";
		if (expr.indexOf("!") > -1) {
			for (var i = 0; i < expr.length; i++) {
				if (expr.charCodeAt(i) > 47 && expr.charCodeAt(i) < 58) {
					fact += expr.charAt(i);
				} else if (expr.charAt(i) == "!") {
					break;
				} else {
					fact = "";
				}
			}
			if (Number(fact) > 20) {
				alert("Factorial muito grande!");
				document.getElementById("formCalc:equal").style.background = "red";
				document.getElementById("formCalc:equal").disabled = "disabled";
			}
		}
	}
}

function bracket() {
	var expr = document.getElementById("ecra").textContent;
	var brackets = 0;
	for (var i = 0; i < expr.length; i++) {
		if (expr.charAt(i) == "(") brackets++;
		else if (expr.charAt(i) == ")") brackets--;
	}

	if (brackets <= 0) {
		document.getElementById("formCalc:closeP").style.color = "gray";
		document.getElementById("formCalc:closeP").disabled = "disabled";
	}
}

function realNumberFact() {
	var expTemp = "";
	var exp = document.getElementById("ecra").textContent;
	if (exp.indexOf("!") > -1) {
		for (var i = 0; i < exp.length; i++) {
			if (exp.charCodeAt(i) > 47 && exp.charCodeAt(i) < 58 || exp.charAt(i) == ".") {
				expTemp += exp.charAt(i);
			} else if (exp.charAt(i) == "!") {
				break;
			} else {
				expTemp = "";
			}
			if (expTemp.length > 0) {
				if (expTemp.indexOf(".") > -1) {
					document.getElementById("formCalc:equal").style.background = "red";
					document.getElementById("formCalc:equal").disabled = "disabled";
				}
			}
		}
	}
}

function validF() {
	var exp = document.getElementById("ecra").textContent;
	var regex = /([\+\-\*\/])/;
	var expStrings = exp.split(regex);
	var len = expStrings.length;
	var conta = len - 1;
	var last = expStrings[conta];
	if (last > 20) {
		document.getElementById("formCalc:factor").style.background = "darkgrey";
		document.getElementById("formCalc:factor").style.color = "silver";
		document.getElementById("formCalc:factor").disabled = "disabled";
	
	}
}