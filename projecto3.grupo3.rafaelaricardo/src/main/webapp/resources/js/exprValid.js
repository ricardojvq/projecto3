function teste() {
	if (document.getElementById("formCalc:ecra").textContent != "0") {
		var screen = document.getElementById("formCalc:ecra").textContent;
		if (screen.indexOf("N") > -1 || screen.indexOf("-Infinity") > -1) {
			document.getElementById("formCalc:equal").style.background = "red";
			document.getElementById("formCalc:equal").disabled = "disabled";
		} else {
			try {
				var a = math.eval(document.getElementById("formCalc:ecra").textContent);
				document.getElementById("formCalc:equal").style.background = "green";
			} catch(SyntaxError) {
				document.getElementById("formCalc:equal").style.background = "red";
				document.getElementById("formCalc:equal").disabled = "disabled";
			}
		}
	} else {
		document.getElementById("formCalc:equal").disabled = "disabled";
	}

}