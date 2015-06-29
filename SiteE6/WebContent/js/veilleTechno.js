var requete;

function ajoutArticle() {
	
	var url = "./VeilleTechno?";
	var data = null;
	if(window.XMLHttpRequest) {
		requete = new XMLHttpRequest();
		}else if (window.ActiveXObject){
		requete = new ActiveXObeject("Microsoft.XMLHTTP");
		}
	requete.open("POST", url, true);
	var tabValeur = new Array();
	var titre = document.getElementById("inTitre").value;
	var resume = document.getElementById("inResume").value;
	var href = document.getElementById("inHref").value;
	d = document.getElementById("seCategorie").value;
	var note = document.getElementById("note").innerHTML;
	tabValeur = d.split(".");
	var categorie =tabValeur[0];
	
	//alert(titre +" " + resume +" " + href +" " + categorie);
	
	
	data = "titre="+titre + "&resume=" + resume+ "&href=" +href + "&categorie="+ categorie + "&note=" + note;
	requete.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	requete.onreadystatechange = majIHM;

	 requete.send(data);
	
	function majIHM() {

		if (requete.readyState == 4) {
			if (requete.status == 200) {
				document.getElementById("body").innerHTML = requete.responseText;
			   }
		else
			alert("pb dans ajax");
		}
	}
}
function Charge(valeur){
	
	if(valeur == "Recherche :"){
		document.getElementById("btn").innerHTML = "Recherche";
		document.getElementById("titre").innerHTML = "Toutes les articles :";
		document.getElementById("recherche").innerHTML = "";
		document.location.href="VeilleTechno";
	}else
	{
		reponseText = getCategorie();
		
		//alert(reponseText);
		
	}
	function getCategorie(){
		categorie = "";
		url = "./VeilleTechno?action=getCategorie";
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
					var messageTag = requete.responseXML.getElementsByTagName("message")[0];
					categorie = messageTag.childNodes[0].nodeValue;
					Go(categorie);
				}
			else
				alert("pb dans ajax");
			}
		}
	}
}
function RechercheCategorie(valeur){
	var tabVal = new Array();
	tabVal = valeur.split(".");
	url = "./VeilleTechno?action=recherche&valeur="+tabVal[0];
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
function Go(reponseText){
	var tabCategorie = new Array();
	tabCategorie = reponseText.split(";");
	html = "<select onchange='RechercheCategorie(this.value)' id='sCategorie'>";
	for(i=0;i<= tabCategorie.length-1;i++){
		var sousCateg = new Array();
		sousCateg = tabCategorie[i].split(".");
		html += "<option style='color:black;' id='" + sousCateg[0] + "'>" + sousCateg[0]+"."+sousCateg[1] + "</option>";
	}
	html += "</select>";
	document.getElementById("btn").innerHTML = "Toutes les articles";
	document.getElementById("titre").innerHTML = "Recherche :";
	document.getElementById("recherche").innerHTML = "<table><tr><td>" + html + "</td></tr></table><div id='resultat'></div>";
}
function recupArticle(valeur){
	url = "./VeilleTechno?action=getUnArticle&valeur="+valeur;
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
				document.getElementById("listeArticle").innerHTML = requete.responseText;
			}
		else
			alert("pb dans ajax");
		}
	}
}
function deleteArticle(valeur){
	url = "./VeilleTechno?action=deleteArticle&valeur="+valeur;
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
				document.getElementById("Article"+valeur).innerHTML = "";
			}
		else
			alert("pb dans ajax");
		}
	}
}
function prepareUpdateArticle(valeur,ouvrir){
	//alert(valeur);
	var tabVal = new Array();
	tabVal = valeur.split("_");
	//alert("updateArticle(in"+valeur+".value,"+tabVal[1]+","+tabVal[0]+")");
	if(ouvrir){
		if(document.getElementById(valeur).innerHTML.substr(0,1) != "<"){
			
			var html = document.getElementById(valeur).innerHTML;
			document.getElementById(valeur).onclick = "";
			document.getElementById("Div"+valeur).innerHTML = "<textarea rows='4' cols='50' id='in" + valeur + "'>"+html+"</textarea><span class='image right'><img id='img"+valeur+"' src='./img/save.png' onclick=''></span>";
			valeurLabel = "in" + valeur;
			//alert(document.getElementById(valeurLabel).value);
			document.getElementById("img"+valeur).onclick=function() { update(document.getElementById(valeurLabel).value,tabVal[1],tabVal[0]) };
			//;update(in"+valeur+".value,"+tabVal[1]+","+tabVal[0]+")
		}
	}else{
		var html = document.getElementById("in"+valeur).innerHTML;
		document.getElementById(valeur).innerHTML = html;
	}
	
	
}
function update(valeur,id, attribut){
	
	//alert("val : " + valeur + " - id : " + id + " - attribut : " + attribut);
	url = "./VeilleTechno?action=updateArticle&attribut="+attribut+"&id="+id+"&valeur="+valeur;
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
				document.getElementById("Div"+attribut+"_"+id).innerHTML = "<p onclick='prepareUpdateArticle(this.id,true)' id='"+ attribut+"_" + id + "'>"+valeur+"</p>";
			}
		else
			alert("pb dans ajax");
		}
	}
}