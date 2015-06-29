<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
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
		<title>Accueil</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="assets/css/style.css" />
	</head>
	<body class="landing">

		<!-- Page Wrapper -->
			<div id="page-wrapper">

				<!-- Header -->
					<jsp:include page="menu.jsp" />

				<!-- Banner -->
					<section id="banner">
						<div class="inner">
							<h2>Epreuve E6</h2>
							<p>Site de présentation de BERNARD Nicolas pour l'épreuve E6</p>
							
						</div>						
						<a href="#one" class="more scrolly">Learn More</a>
					</section>

				<!-- One -->
					<section id="one" class="wrapper style1 special">
						<div class="inner">
							<header class="major">
								<h2>Qui suis-je ?</h2>
								<p>Je m'appelle Nicolas Bernard, j'ai obtenu mon Bac Scientifique en 2010 et j'ai suis actuelement en BTS SIO 
								(parcours SLAM), j'ai réalisé mon premier stage	chez Axians à Brest qui est une entreprise spécialisé dans les
								réseaux et télécommunication, puis mon second stage	chez Laïta, une coopérative laitière du grand Ouest, dans le 
								service développement.
								</br>
								Je vais vous présenter mon parcours de professionalisation grâce à ce site réalisé en JAVA EE sous Eclipse Keepler
								hébergé chez moi sous Debian et en lien avec une bdd sous MySql. </p>
							</header>
							<!-- <ul class="icons major">
								<li><span class="icon fa-diamond major style1"><span class="label">Lorem</span></span></li>
								<li><span class="icon fa-heart-o major style2"><span class="label">Ipsum</span></span></li>
								<li><span class="icon fa-code major style3"><span class="label">Dolor</span></span></li>
							</ul> -->
						</div>
					</section>

				<!-- Two -->
					<section id="two" class="wrapper alt style2">
						<center><h2>Projets :</h2></center>
						<section class="spotlight">
							<div class="image"><img src="img/test.gif" alt="" /></div><div class="content">
								<h2>PPE GSB PHP</h2>
								<p>Aliquam ut ex ut augue consectetur interdum. Donec hendrerit imperdiet. Mauris eleifend fringilla nullam aenean mi ligula.</p>
								<a href="./ListeFicheSituation#5">Lien vers la fiche de situation</a></p>
							</div>
						</section>
						<section class="spotlight">
							<div class="image"><img src="img/ppe_java.gif" alt="" /></div><div class="content">
								<h2>PPE GSB JAVA</h2>
								<p>Projet dans le cadre des PPE, avec mon binôme nous avons travaillé sur la gestion des ressources humaines de la société GSB</br>
								<a href="./ListeFicheSituation#6">Lien vers la fiche de situation</a></p>
							</div>
						</section>
						<section class="spotlight">
							<div class="image"><img src="images/pic03.jpg" alt="" /></div><div class="content">
								<h2>Augue eleifend aliquet<br />
								sed condimentum</h2>
								<p>Aliquam ut ex ut augue consectetur interdum. Donec hendrerit imperdiet. Mauris eleifend fringilla nullam aenean mi ligula.</p>
							</div>
						</section>
					</section>

				<!-- Three -->
					<section id="three" class="wrapper style3 special">
						<div class="inner">
							<header class="major">
								<h2>Compétence :</h2><a id="question" onclick="help();return false;"><SUP>?</SUP></a>
								<p>Liste des technologies/langages vues en cours/stage et mon avancement sur chacune.</p>
								<a onclick="color();return false;">WESH CLICK</a>
							</header>
							
							<ul class="features">
								
								<c:forEach var="t" items="${ listeTypeTechno }">
									<li class="icon fa-paper-plane-o">
									<h3>${t.getLibelle() }</h3>
									<table id="table${ t.getIdTypeTechnologie() }">
									<!-- <tr>
									<th>Technologie :</th>
									</tr> -->
									
									<c:forEach var="te" items="${ t.getListeTechnologie() }">
									<tr id="tr_${ t.getIdTypeTechnologie() }_${ te.getIdTechnologie() }" onmouseout="detail('out',this.id);" onmouseover="detail('on',this.id)">
										<td>${ te.getLibelle() }</td>
										<td width="50%"><p><div class="rating">
									<c:set var="note" scope="session" value="${te.getNote()}"/>
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
									</c:choose> <!-- A changer mais c'est stylé sa mère --></div></td>
									<td><img title="${ te.getLibelle() } : Situation vue Cours" height='40px' width='40px' src='./img/cours.png'/></td>
									</tr>
									<!-- <tr hidden></tr>
									<tr id="hiddentr${ t.getIdTypeTechnologie() }${ te.getIdTechnologie() }" style="visibility: hidden;"></tr>
									 -->
									</c:forEach>
									
									</table>
										<!-- <p><div class="rating">
										<span id="star5" onclick="save(this.id);">☆</span><span id="star4" onclick="save(this.id);">☆</span><span id="star3" onclick="save(this.id);">☆</span><span id="star2" onclick="save(this.id);">☆</span><span id="star1" onclick="save(this.id);">☆</span>
										</div> -->
										<p id="note"></p>
									</li>
								</c:forEach>
							</ul> 
						</div>
					</section>

				<!-- CTA -->
					<section id="cta" class="wrapper style4">
						<div class="inner">
							<header>
								<h2>Contact</h2>
								<label align="left">Nom :</label>
								<input id="formNom" type="text"/>
								<label align="left">Titre :</label>
								<input id="formTitre" type="text"/>
								<label align="left">Message :</label>
								<textarea id="formMessage"></textarea>
							</header>
							</br>
							<ul class="actions vertical">
								<li><a onclick="sendMail(formNom.value,formTitre.value,formMessage.value);return false;" class="button fit special">Envoyer</a></li>
								<li><a class="button fit" onclick="effaceFonction();return false;">Effacer</a></li>
							</ul>
						</div>
					</section>

				<!-- Footer -->
					<footer id="footer">
						<ul class="icons">
							<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
							<li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
							<li><a href="#" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
						</ul>
						<ul class="copyright">
							<li>&copy; Bernard Nicolas</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
						</ul>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/init.js"></script>
			<script src="js/index.js"></script>
			<script src="js/jquery-2.1.4.js"></script>
			
	</body>
</html>