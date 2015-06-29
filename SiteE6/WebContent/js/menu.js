function onChangeMenu(valeur){
//	var url = "";
//	switch(valeur){
//		case "1" :
//			url = "./Accueil";
//			break;
//		case "2" :
//			url = "./Test";
//			break;
//		case "3" :
//			url = "./ArbreCompetence";
//			break;
//		case "4" :
//			url = "./ListeFicheSituation";
//			break;
//	}
//	if(window.XMLHttpRequest) {
//		requete = new XMLHttpRequest();
//		}else if (window.ActiveXObject){
//		requete = new ActiveXObeject("Microsoft.XMLHTTP");
//		}
//	requete.open("POST", url, true);
//	requete.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//	//alert(data);
//	//requete.onreadystatechange = majIHM;
//
//	 requete.send(null);
//	function majIHM() {
//	
//		if (requete.readyState == 4) {
//			if (requete.status == 200) {
//				document.getElementById("resultat").innerHTML = requete.responseText;
//			}
//		else
//			alert("pb dans ajax");
//		}
//	}
	document.getElementById(valeur).className = "current";
}