<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/style.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Competence et Situation</title>
<script type="text/javascript" src="js/adminPanel.js"></script>
<jsp:include page="menu.jsp" />
</head>
<body>

<div id="competence">
<form method="GET">
<center><p> Liste Etat</p></center> 
<center>
<table border=1>
<tr>
<th>id Etat </th>
<th>Libelle Etat</th>
<th>${ listeEtat.size() }</th>
</tr>
<c:forEach var="e" items="${ listeEtat }">
<tr>
<td>${e.getIdEtat()}</td>
<td>${e.getLibelleEtat() } </td>
<td><a 	href='#'name="deleteEtat" id="${e.getIdEtat()}" onclick='deleteEtat(this.name,this.id)'><img src='img/delete.png' /></a></td>
</c:forEach>

</tr>
<tr>

<td><input hidden type="text" id="idEtat"></td>
<td><input type="text" id="libelleEtat"></td>
<td><a 	href='#' name="addEtat" onclick='add(this.name,libelleEtat.value)'><img src='img/valid.png' /></a></td>

</tr>

</table>
</center> 
</form>
</br>
<form method="GET">
<center><p> Liste Activite</p></center>
<center>
<table border=1>
<tr>
<th>id Activite </th>
<th>Libelle Activite</th>
<th>${ listeActivite.size() }</th>
</tr>
<c:forEach var="a" items="${ listeActivite }">
<tr>
<td>${a.getIdActivite()}</td>
<td>${a.getLibelleActivite() } </td>
<td><a 	href='#'name="deleteActivite" id="${a.getIdActivite()}" onclick='deleteActivite(this.name,this.id)'><img src='img/delete.png' /></a></td>
</c:forEach>

</tr>
<tr>

<td><input type="text" id="idActivite"></td>
<td><input type="text" id="libelleActivite"></td>
<td><a 	href='#' name="addActivite" onclick='add(this.name,idActivite.value,libelleActivite.value)'><img src='img/valid.png' /></a></td>

</tr>

</table>
</center>
</form>
</br>
<form method="GET">
<center><p> Liste Competence</p></center>
<center>
<table border=1>
<tr>
<th>id Competence </th>
<th>Libelle Competence</th>
<th>Activite</th>
<th>${ listeCompetence.size() }</th>
</tr>
<c:forEach var="c" items="${ listeCompetence }">
<tr>
<td>${c.getIdCompetence()}</td>
<td>${c.getLibelleCompetence() } </td>
<td>${c.getLaActivite().getLibelleActivite() } </td>
<td><a 	href='#'name="deleteCompetence" id="${c.getIdCompetence()}" onclick='deleteCompetence(this.name,this.id)'><img src='img/delete.png' /></a></td>
</tr>
</c:forEach>


<tr>

<td><input type="text" id="idCompetence"></td>
<td><input type="text" id="libelleCompetence"></td>
<td>
<select name="selectActivite" onchange="" size="1">
<c:forEach var="a" items="${listeActivite}">
<option value=<c:out value="${a.getIdActivite()}"/>><c:out value="${a.getLibelleActivite()}"/></option>
</c:forEach>
</select>
</td>
<td><a 	href='#' name="addCompetence" onclick='add(this.name,idCompetence.value,libelleCompetence.value,selectActivite.value)'><img src='img/valid.png' /></a></td>
</tr>

</table>
</center>
</form>

</br>
<form method="GET">
<center><p> Liste Tache</p></center>
<center>
<table border=1>
<tr>
<th>id Tache </th>
<th>Libelle Tache</th>
<th>${ listeTache.size() }</th>
</tr>
<c:forEach var="t" items="${ listeTache }">
<tr>
<td>${t.getIdTache()}</td>
<td>${t.getLibelleTache() } </td>
<td><a 	href='#'name="deleteTache" id="${t.getIdTache()}" onclick='deleteTache(this.name,this.id)'><img src='img/delete.png' /></a></td>
</tr>
</c:forEach>

<tr>

<td><input hidden type="text" id="idTache"></td>
<td><input type="text" id="libelleTache"></td>
<td><a 	href='#' name="addTache" onclick='add(this.name,libelleTache.value)'><img src='img/valid.png' /></a></td>
</tr>

</table>
</center>
</form>
</br>
<form method="GET">
<center><p> Liste Fiche</p></center>
<center>
<table border=1>
<tr>
<th>id Fiche </th>
<th>Libelle Fiche</th>
<th>Type Fiche</th>
<th>Liste de ListeActivite</th>
<th>Environement</th>
<th>Organisation</th>
<th>besoin</th>
<th>${ listeFiche.size() }</th>
</tr>
<c:forEach var="f" items="${ listeFiche }">
<tr>
<td>${f.getIdFiche()}</td>
<td>${f.getLibelleFiche() } </td>
<td>${f.getLeType().getLibelleType() } </td>
<td>

<select size="1">
<c:forEach var="a" items="${f.getListeActivite()}">
<option value=<c:out value="${a.getIdListeActivite()}"/>><c:out value="${a.getLaActivite().getLibelleActivite()}"/></option>
</c:forEach>
</select>
</td>

<td>${f.getEnvironnement() } </td>
<td>${f.getOrganisation() } </td>
<td>${f.getBesoin() } </td>
<td><a 	href='#'name="deleteFiche" id="${f.getIdFiche()}" onclick='deleteFiche(this.name,this.id)'><img src='img/delete.png' /></a></td>
</c:forEach>

</tr>
<tr>

<td><input hidden type="text" id="idFiche"></td>
<td><input type="text" id="libelleFiche"></td>
<td>
<select name="idType" onchange="" size="1">
<c:forEach var="t" items="${listeType}">
<option value=<c:out value="${t.getIdType()}"/>><c:out value="${t.getLibelleType()}"/></option>
</c:forEach>
</select>

</td>
<td>
<select name="idListeActivite" onchange="ajouteMultiple(idListeActivite.value,listeActiviteLabel.id)" size="1">
<option selected/>Par défaut</option>
<c:forEach var="l" items="${listeListeActivite}">
<option value=<c:out value="${l.getIdListeActivite()}"/>><c:out value="${l.getLaActivite().getLibelleActivite()}"/></option>
</c:forEach>
</select>
<p id ="listeActiviteLabel"></p>
</td>
<td><TEXTAREA name="nom" id="environement" rows=5 cols=35></TEXTAREA></td>
<td><TEXTAREA name="nom" id="organisation" rows=5 cols=35></TEXTAREA></td>
<td><TEXTAREA name="nom" id="besoin" rows=5 cols=35></TEXTAREA></td>
<td><a 	href='#' name="addFiche" onclick='addFiche(this.name,idCompetence.value,libelleCompetence.value)'><img src='img/valid.png' /></a></td>
</tr>

</table>
</center>
</form>
</br>
<form method="GET">
<center><p> Liste Type</p></center>
<center>
<table border=1>
<tr>
<th>id Type </th>
<th>Libelle Type</th>
<th>${ listeType.size() }</th>
</tr>
<c:forEach var="t" items="${ listeType }">
<tr>
<td>${t.getIdType()}</td>
<td>${t.getLibelleType() } </td>
<td><a 	href='#'name="deleteType" id="${t.getIdType()}" onclick='deleteType(this.name,this.id)'><img src='img/delete.png' /></a></td>
</tr>
</c:forEach>

<tr>

<td><input hidden type="text" id="idType"></td>
<td><input type="text" id="libelleType"></td>
<td><a 	href='#' name="addType" onclick='add(this.name,libelleType.value)'><img src='img/valid.png' /></a></td>
</tr>

</table>
</center>
</form>
</br>
<form method="GET">
<center><p> Liste ListeActivite</p></center>
<center>
<table border=1>
<tr>
<th>id ListeActivite </th>
<th>id Fiche - libelle Fiche</th>
<th>id Activite - libelle Activite</th>
<th>Liste Competence</th>
<th>Liste Tache</th>
<th>${ listeListeActivite.size() }</th>
</tr>
<c:forEach var="l" items="${ listeListeActivite }">
<tr>
<td>${l.getIdListeActivite()}</td>
<td>${l.getLaFiche().getIdFiche() } - ${l.getLaFiche().getLibelleFiche() }</td>
<td>${l.getLaActivite().getIdActivite() } - ${l.getLaActivite().getLibelleActivite() }</td>
<td>
<c:forEach var="c" items="${ l.getListeCompetence() }">
${c.getIdCompetence() } - ${c.getLibelleCompetence() }

</c:forEach>
</td>
<td>
<c:forEach var="c" items="${ l.getListeTache() }">
${c.getListeTache().getIdTache() } - ${c.getListeTache().getLibelleTache() }

</c:forEach>
</td>
<td><a 	href='#'name="deleteType" id="${t.getIdType()}" onclick='deleteType(this.name,this.id)'><img src='img/delete.png' /></a></td>
</tr>
</c:forEach>

<tr>

<td><input hidden type="text" id="idListeActivite"></td>
<td><select name="idFiche" onchange="" size="1">
<c:forEach var="t" items="${listeFiche}">
<option value=<c:out value="${t.getIdFiche()}"/>><c:out value="${t.getLibelleFiche()}"/></option>
</c:forEach>
</select>
<p id="labelFiche"></p></td>
<td><select name="idActivite" onchange="" size="1">
<c:forEach var="t" items="${listeActivite}">
<option value=<c:out value="${t.getIdActivite()}"/>><c:out value="${t.getLibelleActivite()}"/></option>
</c:forEach>
</select><p id="labelActivite"></p></td>
<td><select name="idCompetence" onchange="ajouteMultiple(idCompetence.value,labelCompetence.id)" size="1">
<option selected/>Par défaut</option>
<c:forEach var="t" items="${listeCompetence}">
<option value=<c:out value="${t.getIdCompetence()}"/>><c:out value="${t.getLibelleCompetence()}"/></option>
</c:forEach>
</select><p id="labelCompetence"></p></td>
<td><select name="idTache" onchange="ajouteMultiple(idTache.value,labelTache.id)" size="1">
<option selected/>Par défaut</option>
<c:forEach var="t" items="${listeTache}">
<option value=<c:out value="${t.getIdTache()}"/>><c:out value="${t.getLibelleTache()}"/></option>
</c:forEach>
</select><p id="labelTache"></p></td>

<td><a 	href='#' name="addListeActivite" onclick='add(this.name,idFiche.value,idActivite.value,labelCompetence.innerHTML,labelTache.innerHTML)'><img src='img/valid.png' /></a></td>
</tr>

</table>
</center>
</form>
</div>
</body>
</html>