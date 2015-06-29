var requete;

function add(action,params) {
	alert(action +" " + params);
	var url;
	switch(action) {
    case "addTache":
    	
    	var tableau=params.split(";");
        url = "./Test?action="+action+"&idTache="+tableau[0]+"&libelle="+tableau[0];
        break;
	}
	if(window.XMLHttpRequest) {
		requete = new XMLHttpRequest();
		}else if (window.ActiveXObject){
		requete = new ActiveXObeject("Microsoft.XMLHTTP");
		}
	requete.open("GET", url, true);
	requete.onreadystatechange = majIHM;
	requete.send(null);
}
function majIHM() {

	if (requete.readyState == 4) {
		if (requete.status == 200) {
			document.getElementById("competence").innerHTML = requete.responseText;
		}
	else
		alert("pb dans ajax");
	}
}