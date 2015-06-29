function save(name,valeur){
	//alert("name : " + name + " - valeur : " + valeur);
	j = name.length + 4;
	i = parseInt(valeur.substr(j,1));
	document.getElementById("note").innerHTML = i+"/5";
	while(i>0){
		document.getElementById(name+"star"+i).innerHTML = "★";
		i--;
	}
	j = name.length + 4;
	i = parseInt(valeur.substr(j,1));
	while(i<5){
		i++;
		document.getElementById(name+"star"+i).innerHTML = "☆";
	}
	
}
var requete;
function sendMail(nom,titre,message){
	url = "./Test?action=sendMail&nom="+nom+"&titre="+titre+"&message="+message;
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
				effaceFonction();
			}
		else
			alert("pb dans ajax");
		}
	}
}
function effaceFonction(){
	document.getElementById("formNom").value="";
	document.getElementById("formTitre").value="";
	document.getElementById("formMessage").value="";

}
function detail(action,valeur){
	var ligne = document.getElementById('nom' +valeur);
	var tabValeur = new Array();
//	alert(valeur);
	tabValeur = valeur.split("_");
	switch(action){
	case "on" :
		if(document.getElementById("hidden" + valeur) == null){
			var tr = document.createElement("tr");
			tr.setAttribute("id", "hidden" + valeur);
			document.getElementById("table"+tabValeur[1]).appendChild(tr);
		}
		if(ligne == null){
			document.getElementById("hidden" + valeur).innerHTML += "<td colspan=2 id='nom" + valeur + "'>Liste des productions : " + valeur + "</td>";
		}else if(ligne.innerHTML == ""){
			
			ligne.innerHTML =  valeur ;
		}
		document.getElementById("hidden" + valeur).style.visibility='visible';
		break;
	case "out" :
//		if(ligne == null){
//			document.getElementById("hidden" + valeur).innerHTML += "<td id='nom" + valeur + "'>" + valeur + "</td>";
//		}else{
//			
			document.getElementById('nom' +valeur).innerHTML = "";
	//	}
		document.getElementById("hidden" + valeur).style.visibility='hidden';
		document.getElementById("hidden" + valeur).remove();

		break;
	}
	
}

function help(){
	if(document.getElementById("help1") == null){
		var div = document.createElement("div");
		var question = document.getElementById("question");
		var x = question.offsetLeft;
		var y = question.offsetTop;
//		alert("x : " + x + " - y : " + y); 
		div.setAttribute("id", "help1");
//		var d = document.getElementById('help');
		div.style.position = "fixed";
		div.style.left ="60%";
		div.style.top = "20%";
		div.style.width = "550px";
		div.style.height = "450px";
		div.style.backgroundColor = "#505393";
		div.style.border = "1px solid white";
		//div.style.color = "Red";
		div.style.fontSize = "large";
//		div.style.opacity = .2; //For real browsers;
		var html = "<img id='imgClose' onclick='quit()' src='./img/close.png' width='20px' height='20px'/></br>";//
		html += "Type de situation :<table><tr><td><img width='42px' height='42px' src='./img/cours.png'/></td><td>Situation vue en cours</td></tr>" +
				"<tr><td><img width='42px' height='42px' src='./img/stage.png'/></td><td>Situation vue en stage</td></tr></table>";
		html += "Note :<table><tr><td>★★★☆☆</td><td>3/5</td></tr><tr><td colspan=2 >Note relative à la pratique (temps passés) sur une technologie.</td></tr></table>";
		div.innerHTML = html;
//		var imgMove = document.createElement("img");
//		imgMove.src = "./img/move.png";
//		imgMove.width= "10px";
//		imgMove.height = "10px";
//		imgMove.left="10%";
//		div.appendChild(imgMove);
		
		document.body.appendChild(div);
		var box = $('#help1');

		var drag = {
		    elem: null,
		    x: 0,
		    y: 0,
		    state: false
		};
		var delta = {
		    x: 0,
		    y: 0
		};
		box.mousedown(function(e) {
		    if (!drag.state) {
		        drag.elem = this;
		        this.style.backgroundColor = '#c400ff';
		        drag.x = e.pageX;
		        drag.y = e.pageY;
		        drag.state = true;
		    }
		    return false;
		});


		$(document).mousemove(function(e) {
		    if (drag.state) {
		        drag.elem.style.backgroundColor = '#c400ff';

		        delta.x = e.pageX - drag.x;
		        delta.y = e.pageY - drag.y;

		        $('#log').text(e.pageX + ' ' + e.pageY + ' ' + delta.x + ' ' + delta.y);

		        var cur_offset = $(drag.elem).offset();

		        $(drag.elem).offset({
		            left: (cur_offset.left + delta.x),
		            top: (cur_offset.top + delta.y)
		        });

		        drag.x = e.pageX;
		        drag.y = e.pageY;
		    }
		});

		$(document).mouseup(function() {
		    if (drag.state) {
		        drag.elem.style.backgroundColor = '#505393';
		        drag.state = false;
		    }
		});
	}
	

}

function quit(){
	document.getElementById("help1").remove();
}
function color(){
	var div = document.createElement("div");
	div.setAttribute("id", "code");
	div.style.position = "fixed";
	div.style.left ="10%";
	div.style.top = "10%";
	div.style.width = "80%";
	div.style.height = "80%";
	div.style.backgroundColor = "#fff";

	var rawFile = new XMLHttpRequest();
    rawFile.open("GET", "/SiteE6/ressources/com/metier/Activite.java", false);
    rawFile.onreadystatechange = function ()
    {
        if(rawFile.readyState === 4)
        {
            if(rawFile.status === 200 || rawFile.status == 0)
            {
            	
                var allText = rawFile.responseText;
                div.style.fontSize = "large";
            	var html = "<!DOCTYPE html><html xmlns='http://www.w3.org/1999/xhtml'><head><title>higlight.js example</title>" +
            			"<script src='//cdnjs.cloudflare.com/ajax/libs/highlight.js/7.3/highlight.min.js'></script><link href='//cdnjs.cloudflare.com/ajax/libs/highlight.js/7.3/styles/default.min.css' rel='stylesheet' />" +
            			"<script>hljs.initHighlightingOnLoad();</script></head><body><pre><code class='java'>";
            	html += "<p>Titre</p>";
            	html += "<textarea rows='18' cols='50'>" + allText + "</textarea>";
                html += "</body></html>";
            	div.innerHTML = html;

            	document.body.appendChild(div);
            }
        }
    }
    rawFile.send(null);
	
	

}
