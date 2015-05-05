function teste() {
	if (document.getElementById("ecra").textContent != "0") {
		var screen = document.getElementById("ecra").textContent;
		if (screen.indexOf("N") > -1 || screen.indexOf("-Infinity") > -1) {
			document.getElementById("formCalc:equal").style.background = "red";
			document.getElementById("formCalc:equal").disabled = "disabled";
		} else {
			try {
				var a = math.eval(document.getElementById("ecra").textContent);
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