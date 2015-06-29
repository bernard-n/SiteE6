<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="assets/css/style.css" />
<link rel="stylesheet" href="styles/codemirror.css" />
<script src="js/codemirror.js"></script>
<script src="js/javascript.js"></script>
<script src="js/htmlmixed.js"></script>
<script src="js/vbscript.js"></script>
<script src="js/xml.js"></script>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.scrollex.min.js"></script>
<script src="assets/js/jquery.scrolly.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/init.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Try It Yourself !</title>
<jsp:include page="menu.jsp" />
</head>
<body>
</br>
<center><h1>Web Editeur :</h1></center>
<table>
<tr>
<td >Code HTML :
</td>
</tr>
<tr>
<td colspan=2>
<form><textarea style="resize:none" rows="12" id="code2" name="code">
<!DOCTYPE html>
<html>
<head>
</head>
<body>
</body>
</html>
</textarea></form>
</td>
<td rowspan =3 ></br><button onclick="change(editor.getValue(),editor2.getValue());">Try !</button>

<div id="resultat">
</br>
<h1>Resultat :</h1>
</div>
</td>
</tr>
<tr>
<td colspan=2>
<h1>Code JAVASCRIPT :</h1>
<form><textarea style="resize:none" rows="12" id="code" name="code">
</textarea></form>
</td>
</tr>
</table>
<script>

var editor = CodeMirror.fromTextArea(document.getElementById("code"), {
    lineNumbers: true,
    styleActiveLine: true,
    matchBrackets: true,
    extraKeys: {"Ctrl-Q": "toggleComment"}

  });


//Define an extended mixed-mode that understands vbscript and
// leaves mustache/handlebars embedded templates in html mode
var mixedMode = {
  name: "htmlmixed",
  scriptTypes: [{matches: /\/x-handlebars-template|\/x-mustache/i,
                 mode: null},
                {matches: /(text|application)\/(x-)?vb(a|script)/i,
                 mode: "vbscript"}]
};
var editor2 = CodeMirror.fromTextArea(document.getElementById("code2"), {
  mode: mixedMode,
  selectionPointer: true,
  lineNumbers: true
});
function change(valeurS,valeur){
	console.log("html : " + valeur + " - js : " + valeurS);
	var resultat = document.getElementById('resultat');
	document.getElementById('resultat').innerHTML = "</br><h1>Resultat :</h1></br>" + valeur;
	var scr = document.createElement("script");
	scr.text = valeurS;
	resultat.appendChild(scr);
}
function activeJQuery(){
	var html ="<!DOCTYPE html><html><head></head><body></body></html>";	
	
	var active = document.getElementById("active");
	if(active.className == "button fit special"){
		active.className = "button fit";
		active.innerHTML = "Desactiver JQuery !";
		var scriptJ = document.createElement("script");
		scriptJ.setAttribute("id","importJQUERY");
		scriptJ.src = "http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js";
		document.getElementById("resultat").appendChild(scriptJ);

	}else{
		var scriptJ = document.getElementById("importJQUERY");
		document.getElementById("resultat").removeChild(scriptJ);
		active.className = "button fit special";
		active.innerHTML = "Activer JQuery !";
	}
		
}
</script>
</body>
</html>