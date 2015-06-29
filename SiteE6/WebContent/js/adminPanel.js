var requete;

function add() {
	
	var action = arguments[0];
	var url = "";
	switch(action) {
	case "addListeActivite":
        url = "./Test?action="+action+"&idFiche="+arguments[1]+"&idActivite="+arguments[2]+"&listeCompetence="+arguments[3]+"&listeTache="+arguments[4];
        break;
	case "addType":
        url = "./Test?action="+action+"&libelleType="+arguments[1];
        break;
    case "addTache":
        url = "./Test?action="+action+"&libelleTache="+arguments[1];
        break;
    case "addCompetence":
        url = "./Test?action="+action+"&idCompetence="+arguments[1]+"&libelleCompetence="+arguments[2]+"&idActivite="+arguments[3];
        break;
	case "addActivite":
	    url = "./Test?action="+action+"&idActivite="+arguments[1]+"&libelleActivite="+arguments[2];
	    break;
	case "addEtat":
	    url = "./Test?action="+action+"&libelleEtat="+arguments[1];
	    break;
	}
   // alert(url);
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
function ajouteMultiple(valeur,idLabel){
	if(valeur != "Par défaut")
	{
		var labelListe = document.getElementById(idLabel).innerHTML;
		if(labelListe == ""){
			document.getElementById(idLabel).innerHTML += valeur;

		}else
		{
			var tabValeur = new Array();
			tabValeur = labelListe.split(";");
			var trouve = false; 
			for (var i=0; i<tabValeur.length; i++) {
				 if(tabValeur[i] == valeur){
					 trouve = true;
				 }
			}
			if(trouve == false){
				document.getElementById(idLabel).innerHTML += ";" + valeur;
			}

		}
	}
	
	//alert("valeur arrivé : " + valeur + " valeur totale : " + document.getElementById("listeActiviteLabel").innerHTML);
}