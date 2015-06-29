<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<jsp:include page="menu.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/treeview.js"></script>
<title>Arbre des compétences</title>
</head>
<body>
</br>
</br>
</br>
<button id="labelPlier" onclick="Plier(this.innerHTML)">Plier</button>
<div id="full">
<ul>
<c:forEach var="la" items="${ listeActivite }">
	<div id="Activite${la.getIdActivite()}" onmouseover="In(this.id)" onmouseout="Out(this.id)">
	<li id="${la.getIdActivite()}"  onclick="Detail(this.id)">${la.getIdActivite()} - ${la.getLibelleActivite()}
		<ul>
		<div id="Competence${la.getIdActivite()}">
		<c:forEach var="lc" items="${ la.getListeCompetence() }">
			<li>
			${lc.getIdCompetence()} - ${lc.getLibelleCompetence()}
			</li>
		</c:forEach>
		</div>
		</ul>
	</li>
	</div>
</c:forEach>
</ul>
</div>
</body>
</html>