<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Veille Technologique</title>
<!-- <link rel="stylesheet" type="text/css" href="styles/style.css">
<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css"> -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.scrollex.min.js"></script>
<script src="assets/js/jquery.scrolly.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/init.js"></script>
<script src="js/veilleTechno.js"></script>
<script src="js/index.js"></script>

<style>
		.myClass{
    content: "\2605";
    position: absolute;
}
			.rating > span:hover:before {
		   		content: "\2605";
		   		position: absolute;
			}
			.rating {
			  unicode-bidi: bidi-override;
			  direction: rtl;
			}
			.rating > span:hover:before,
			.rating > span:hover ~ span:before {
			   content: "\2605";
			   position: absolute;
			}.rating {
			  unicode-bidi: bidi-override;
			  direction: rtl;
			}
			.rating > span {
			  display: inline-block;
			  position: relative;
			  width: 1.1em;
			}
			.rating > span:hover:before,
			.rating > span:hover ~ span:before {
			   content: "\2605";
			   position: absolute;
			}</style>
<link rel="stylesheet" href="assets/css/style.css" />
<jsp:include page="menu.jsp" />
</head>
<body>
<div id="body">
</br>
<button id="btn" onclick="Charge(titre.innerHTML)">Recherche</button>
</br>
</br>
<h3 id="titre" class="fiche">Tous les Articles :</h3>
</br>

<div id="recherche"></div>
<div id="listeArticle">
</br>
<p>Nombre d'article : ${ listeArticle.size() }</p>
<hr>
<c:forEach var="a" items="${ listeArticle }">
<div id="Article${a.getIdArticle()}">

<h3>
</h3>		
<span class="image right"><img src='img/delete.png' id="${a.getIdArticle()}" onclick='deleteArticle(this.id)'/></span>
<table class="table">
	
	<tr>
		<span class="image left"><img src='./img/${a.getLaCategorie().getLibelle() }.png' alt="${a.getLaCategorie().getLibelle() }" width="50" height="50"></span>
		<h3><div id="DivTitre_${a.getIdArticle()}"><p onclick="prepareUpdateArticle(this.id,true)" id="Titre_${a.getIdArticle()}">${a.getLibelle() }</p></div></h3>
		<p><div class="rating">
		<c:set var="note" scope="session" value="${a.getNote()}"/>
		<c:choose>
    <c:when test="${note == 0}">
		<span id="star5" onclick="save(this.id);">☆</span><span id="star4" onclick="save(this.id);">☆</span><span id="star3" onclick="save(this.id);">☆</span><span id="star2" onclick="save(this.id);">☆</span><span id="star1" onclick="save(this.id);">☆</span>
    </c:when>
    <c:when test="${note == 1}">
		<span id="star5" onclick="save(this.id);">☆</span><span id="star4" onclick="save(this.id);">☆</span><span id="star3" onclick="save(this.id);">☆</span><span id="star2" onclick="save(this.id);">☆</span><span id="star1" onclick="save(this.id);">★</span>
    </c:when>
    <c:when test="${note == 2}">
		<span id="star5" onclick="save(this.id);">☆</span><span id="star4" onclick="save(this.id);">☆</span><span id="star3" onclick="save(this.id);">☆</span><span id="star2" onclick="save(this.id);">★</span><span id="star1" onclick="save(this.id);">★</span>
    </c:when>
    <c:when test="${note == 3}">
		<span id="star5" onclick="save(this.id);">☆</span><span id="star4" onclick="save(this.id);">☆</span><span id="star3" onclick="save(this.id);">★</span><span id="star2" onclick="save(this.id);">★</span><span id="star1" onclick="save(this.id);">★</span>
    </c:when>
    <c:when test="${note == 4}">
		<span id="star5" onclick="save(this.id);">☆</span><span id="star4" onclick="save(this.id);">★</span><span id="star3" onclick="save(this.id);">★</span><span id="star2" onclick="save(this.id);">★</span><span id="star1" onclick="save(this.id);">★</span>
    </c:when>
    <c:when test="${note == 5}">
		<span id="star5" onclick="save(this.id);">★</span><span id="star4" onclick="save(this.id);">★</span><span id="star3" onclick="save(this.id);">★</span><span id="star2" onclick="save(this.id);">★</span><span id="star1" onclick="save(this.id);">★</span>
    </c:when>
</c:choose>: etoN <!-- A changer mais c'est stylé sa mère -->

		</div>
		
	</tr>
	<tr>
		<td><h6>Résumé :</h6> <div id="DivResume_${a.getIdArticle()}"><p onclick="prepareUpdateArticle(this.id,true)" id="Resume_${a.getIdArticle()}">${a.getResume() }</p></div></td>
	</tr>
	<tr>
		<td><h6>Lien :</h6> <div id="DivHref_${a.getIdArticle()}"><a onclick="prepareUpdateArticle(this.id,true)" id="Href_${a.getIdArticle()}" href='${a.getHref() }'>${a.getHref() }</a></div></td>
	</tr>
	<tr>
		<td><h6>Categorie :</h6><div id="DivCategorie_${a.getIdArticle()}"><p onclick="prepareUpdateArticle(this.id,true)" id="Categorie_${a.getIdArticle()}">${a.getLaCategorie().getLibelle() }</p></div></td>
		
	</tr>
</table>
</br>
<hr>
</div>
</c:forEach>
</div>
<form type="POST" action="javascript:ajoutArticle()">
<div class="table-wrapper">
<table>
<thead>
<tr><th><h2>Ajout d'article</h2></th></tr>
</thead>
<tbody>
	<tr>
		<td>Titre : <input type="text" id="inTitre"></input></td>
	</tr>
	<tr>
		<td>Résumé : <textarea id="inResume" rows="4" cols="50"></textarea></td>
	</tr>
	<tr>
		<td>Lien : <input type="text" id="inHref"></input></td>
	</tr>
	<tr>
		<td>Note : <p id="ajoutNote"><div align="left" class="rating"><span id="ajoutNotestar5" onclick="save(ajoutNote.id,this.id);">☆</span><span id="ajoutNotestar4" onclick="save(ajoutNote.id,this.id);">☆</span><span id="ajoutNotestar3" onclick="save(ajoutNote.id,this.id);">☆</span><span id="ajoutNotestar2" onclick="save(ajoutNote.id,this.id);">☆</span><span id="ajoutNotestar1" onclick="save(ajoutNote.id,this.id);">☆</span>
		</div></p><p id="note">0/5</p></td>
	</tr>
	<tr>
		<td>Categorie : 
		<select id="seCategorie">
		<c:forEach var="c" items="${ listeCategorie }">
			<option value="${c.getIdCategorie() }. ${c.getLibelle()}" id="${c.getIdCategorie() }" style="color:black;">${c.getIdCategorie() }. ${c.getLibelle()}</option>
		</c:forEach>
		</select>
		</td>
	</tr>
	</tbody>
</table>
</div>
<button id="ajoutArticle" type="submit" class="button special fit" >Ajout</button>
</br>
</form>
</div>
 <div id="fade" class="black_overlay" onclick = "prepareUpdateArticle(this.name,false);"></div>

</body>
</html>