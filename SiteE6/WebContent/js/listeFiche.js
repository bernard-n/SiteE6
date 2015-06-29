var requete;
function Charge(valeur){
	if(valeur == "Recherche :"){
		document.getElementById("btn").innerHTML = "Recherche";
		document.getElementById("titre").innerHTML = "Toutes les fiches :";
		document.getElementById("recherche").innerHTML = "";
		document.location.href="ListeFicheSituation";
	}else
	{
		document.getElementById("btn").innerHTML = "Toutes les fiches";
		document.getElementById("titre").innerHTML = "Recherche :";
		document.getElementById("recherche").innerHTML = "<table><tr><td>Type Situation : <input type='text' text='ff' id='type' onkeyup='Resultat(this.id,this.value)'></input></td><td>Compétences : <input type='text' text='ff' id='competence' onkeyup='Resultat(this.id,this.value)'></input></td></tr></table><div id='resultat'></div>";
	}
}
function doc(valeur){
	document.getElementById('pdf').src=valeur;
	document.getElementById('light').style.display='block';
	document.getElementById('fade').style.display='block';
}
function doc2(valeur){
	src = document.getElementById(valeur).value;
	alert(src);
	document.getElementById('pdf').src=src;
	document.getElementById('light').style.display='block';
	document.getElementById('fade').style.display='block';
}
function Resultat(id,valeur){
//	alert("id : " + id + "\n" + "valeur :" + valeur);
	url = "./ListeFicheSituation?action="+id+"&valeur="+valeur;
	if(window.XMLHttpRequest) {
		requete = new XMLHttpRequest();
		}else if (window.ActiveXObject){
		requete = new ActiveXObeject("Microsoft.XMLHTTP");
		}
	requete.open("GET", url, true);
	requete.onreadystatechange = majIHM;
	requete.send(null);
	function majIHM() {
	
		if (requete.readyState == 4) {
			if (requete.status == 200) {
				document.getElementById("resultat").innerHTML = requete.responseText;
			}
		else
			alert("pb dans ajax");
		}
	}
}
function recupUnFiche(valeur){
	url = "./ListeFicheSituation?action=recupUnFiche&valeur="+valeur;
	if(window.XMLHttpRequest) {
		requete = new XMLHttpRequest();
		}else if (window.ActiveXObject){
		requete = new ActiveXObeject("Microsoft.XMLHTTP");
		}
	requete.open("GET", url, true);
	requete.onreadystatechange = majIHM;
	requete.send(null);
	function majIHM() {
	
		if (requete.readyState == 4) {
			if (requete.status == 200) {
				document.getElementById("listeFiche").innerHTML = requete.responseText;
			}
		else
			alert("pb dans ajax");
		}
	}
}
function recupFiches(name,id){
	url = "./ListeFicheSituation?action="+name+"&id="+id;
	if(window.XMLHttpRequest) {
		requete = new XMLHttpRequest();
		}else if (window.ActiveXObject){
		requete = new ActiveXObeject("Microsoft.XMLHTTP");
		}
	requete.open("GET", url, true);
	requete.onreadystatechange = majIHM;
	requete.send(null);
	function majIHM() {
	
		if (requete.readyState == 4) {
			if (requete.status == 200) {
				document.getElementById("listeFiche").innerHTML = requete.responseText;
			}
		else
			alert("pb dans ajax");
		}
	}
}