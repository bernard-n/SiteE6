<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%--  
<link rel="stylesheet" type="text/css" href="styles/style.css">
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css">--%>
<style>
    .black_overlay{
    display: none;
    position: fixed;
    top: 0%;
    left: 0%;
    width: 100%;
    height: 100%;
    background-color: black;
    z-index:1001;
    -moz-opacity: 0.8;
    opacity:.80;
    filter: alpha(opacity=80);
}
.white_content {
    display: none;
    position: fixed;
    top: 29px;
    left: 25%;
    width: 50%;
    height: 100%;
    padding: 16px;
    border: 16px solid grey;
    background-color: white;
    z-index:1002;
    overflow: auto;
}

</style>
<jsp:include page="menu.jsp" />
<link rel="stylesheet" href="assets/css/style.css" />
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.scrollex.min.js"></script>
<script src="assets/js/jquery.scrolly.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/init.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des Fiches de Situation</title>
<script type="text/javascript" src="js/listeFiche.js"></script>
</head>
<body>
</br>
<button id="btn" onclick="Charge(titre.innerHTML)">Recherche</button>
</br>
</br>
<h3 id="titre" class="fiche">Toutes les fiches :</h3>
</br>

<div id="recherche"></div>
<div id="listeFiche">
<ul>
<p>Nombre de fiche de situation : ${ listeFiche.size() }</p>
<c:forEach var="f" items="${ listeFiche }">
<section id="${f.getIdFiche() }">
	<li><h3>${f.getIdFiche() } - ${f.getLibelleFiche() }</h3>
	<table class="tableauFiche">
		<tr>
			<th>Organisation </th>
		</tr>
		<tr>
			<td>${f.getOrganisation() }</td>
		</tr>
		<tr>
			<th>Besoin</th>
		</tr>
		<tr>
			<td>${f.getBesoin() }</td>
		</tr>
		<tr>
			<th>Environnement</th>
		</tr>
		<tr>
			<td>${f.getEnvironnement() }</td>
		</tr>
		<tr>
			<th>Tâches réalisées</th>
		</tr>
		<tr>
			<td>
				<ul>
				<c:set var="count" value="0" scope="page" />
				<c:forEach var="t" items="${ f.getListeTacheDistinct() }">
				<c:set var="count" value="${count + 1}" scope="page"/>
					<li><c:out value="${count}" />. ${t.getLibelleTache() }</li>
				</c:forEach>
				</ul>
			</td>
		</tr>
	</table>
	</br>
	</br>
	<table class="tableauFiche">
		<tr>
			<td colspan="8">Activités et compétences </th>
		</tr>
		<tr>
			<th>Activité </th>
			<th>Compétences </th>
			<c:forEach var="e" items="${ listeEtat }">
			<th>${e.getLibelleEtat() } </th>
			</c:forEach>
		</tr>
		<c:forEach var="l" items="${ f.getListeActivite() }">
		<tr>
			<th>${l.getLaActivite().getIdActivite() } - ${l.getLaActivite().getLibelleActivite() }</th>
			<th>
			<c:forEach var="c" items="${ l.getListeCompetence() }">
				${c.getIdCompetence() } - ${c.getLibelleCompetence() }
				</br>
			</c:forEach>
			</th>
			<c:forEach var="e" items="${ listeEtat }">
			<th>${l.getListeTache(e) }</th>
			</c:forEach>
		</tr>
		</c:forEach>
		
	</table>
	</li>
	</br>
	<h3>Liste des docs</h3>
	<select id="selectDoc${f.getIdFiche() }">
		<c:forEach var="d" items="${ f.getListeDocumentation() }">
		<option value="${d.getHref() }">${d.getTitre() }</option>
		</c:forEach>	
	</select>
	</br>
	
	<button onclick = "var something = 'selectDoc${f.getIdFiche() }';doc(document.getElementById(something).value);">Lien vers la doc</button>
    </br></br>
	<hr>
</section>
</c:forEach>
</ul>
</div>
<div id="light" class="white_content"><iframe id="pdf" width="99%" height="99%"></iframe></div>
    <div id="fade" class="black_overlay" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'"></div>
	</body>
</html>