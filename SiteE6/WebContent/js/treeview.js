var requete;
function Detail(valeur){
	var sId = "Competence" + valeur;
	if(document.getElementById(sId).innerHTML.length > 0){
		document.getElementById(sId).innerHTML = "";
//		document.getElementById(valeur).style.backgroundColor = "#fff";
//		document.getElementById(valeur).style.fontWeight = 'normal';

	}
	else
	{
		var url = "./ArbreCompetence?idActivite="+valeur;
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
				document.getElementById(sId).innerHTML = requete.responseText;
				//document.getElementById(valeur).style.backgroundColor = "#ffc";
				//document.getElementById(valeur).style.fontWeight = 'bold';
			}
		else
			alert("pb dans ajax");
		}
	}
}
function In(valeur){
	document.getElementById(valeur).style.backgroundColor = "#ffc";
	document.getElementById(valeur).style.fontWeight = 'bold';

}
function Out(valeur){
	document.getElementById(valeur).style.backgroundColor = "#fff";
	document.getElementById(valeur).style.fontWeight = 'normal';


}
function Plier(valeur){
	var url = "./ArbreCompetence?action="+valeur;
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
			
			if(valeur == "Plier"){
				document.getElementById("labelPlier").innerHTML = "Déplier";
				document.getElementById("full").innerHTML = requete.responseText;

			}else
			{
				document.getElementById("labelPlier").innerHTML = "Plier";
				document.getElementById("full").innerHTML = requete.responseText;

			}

		}
	else
		alert("pb dans ajax");
	}
}
}